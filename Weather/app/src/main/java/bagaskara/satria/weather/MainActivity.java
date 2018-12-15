package bagaskara.satria.weather;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

import bagaskara.satria.weather.model.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    java.util.List<List> list=new ArrayList<>();
    RecyclerView recyclerView;
    weatheradapter weatheradapter;


    public static final int MY_PERMISIONS_REQUEST_LOCATION = 99;

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView kota, tanggal, cuaca;
    private ImageView img;

    FusedLocationProviderClient fusedLocationProviderClient;

    Location lastlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        getLocatin();


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<WeatherIndukJson> weatherCall = apiInterface.getWheater(-6.789, 107.7772, "422e485d10fbfc9e80ba21ffbde332f6");
        weatherCall.enqueue(new Callback<WeatherIndukJson>() {
            @Override
            public void onResponse(Call<WeatherIndukJson> call, Response<WeatherIndukJson> response) {
        WeatherIndukJson weather=response.body();
        java.util.List<List> list=weather.getList();
                weatheradapter=new weatheradapter(getBaseContext(),list);
                recyclerView.setAdapter(weatheradapter);

            }

            @Override
            public void onFailure(Call<WeatherIndukJson> call, Throwable t) {
                Log.e("MainActivity", t.toString());
            }
        });

    }

    private void getLocatin() {
        if (!checkLocationPermission())
            return;

        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {

            @Override
            public void onSuccess(Location location) {
                lastlocation = location;

                if (location == null) {
                    return;
                }
                updateUI();
            }
        });
    }

    private boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISIONS_REQUEST_LOCATION);
            return false;
        } else {
            return true;
        }
    }



    private void updateUI() {
        String strLocation = "Latitude : " + lastlocation.getLatitude() + "\nLonglatitude : " + lastlocation.getLatitude();
        cuaca.setText(strLocation);
        tanggal.setText(strLocation);
        kota.setText(strLocation);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMISIONS_REQUEST_LOCATION:{
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                        getLocatin();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Aplikasi tidak membutuhkan izin lokasi",Toast.LENGTH_LONG).show();

                }
            }
        }
    }
}
