package bagaskara.satria.lokasiku;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.content.ContentValues.TAG;



public class MainActivity extends AppCompatActivity {
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 0;//value request bebas

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tvLocation;


    FusedLocationProviderClient fusedLocationProviderClient;

    Location lastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLocation = (TextView) findViewById(R.id.location);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getLocation();
    }

    private void getLocation() {
        if (!checkLocationPermission())
            return;

        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                lastLocation = location;
                if (location == null) {
                    return;
                }
                if (!Geocoder.isPresent()) {
                    Toast.makeText(MainActivity.this, "gecoder tidak tersedia", Toast.LENGTH_LONG).show();
                    return;
                }
                new AmbilAlamat().execute();
            }

            private void updateUI() {
                String strLocation = "Latitude: " + lastLocation.getLatitude() + "\nLongitude: " + lastLocation.getLongitude();
                tvLocation.setText(strLocation);

            }


        });
    }

    private boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);//1 code untuk 1 permintaan
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {////permision wajib untuk marsmelow ke atas
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        getLocation();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Aplikasi Tidak Membutuhkan Izin Lokasi", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    class AmbilAlamat extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            Geocoder gecoder = new Geocoder(MainActivity.this, Locale.getDefault());
            String errorMessage = "";
            List<Address> adresses = null;
            try {
                adresses = gecoder.getFromLocation(lastLocation.getLatitude(), lastLocation.getLongitude(), 1);
            } catch (IOException ioException) {
                errorMessage = "Layanan tidak tersedia";
                Log.e(TAG, errorMessage, ioException);
            } catch (IllegalArgumentException illegalArgumentException) {
                errorMessage = "Nilai latidtude dan longitude tidak valid";

                Log.e(TAG, errorMessage + ". " + "Latitude" + lastLocation.getLatitude() + ", Longitude = " + lastLocation.getLongitude(), illegalArgumentException);

            }

            if (adresses == null || adresses.size() == 0) {
                if (errorMessage.isEmpty()) {
                    errorMessage = "Alamat tidak ditemukan";

                    Log.e(TAG, errorMessage);
                }
                return errorMessage;
            } else {
                Address address = adresses.get(0);
                ArrayList<String> addressFragment = new ArrayList<String>();

                for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                    addressFragment.add(address.getAddressLine(i));

                }

                Log.i(TAG, "alamat ditemukan");
                return TextUtils.join(System.getProperty("line.separator"), addressFragment);
            }

        }



        @Override////ditambah sendiri
        protected void onPostExecute(String mAddressOutput) {


            super.onPostExecute(mAddressOutput);
            tvLocation.setText(mAddressOutput);

           // tvLocation.setText(mAddressOutput);

        }
    }
}
