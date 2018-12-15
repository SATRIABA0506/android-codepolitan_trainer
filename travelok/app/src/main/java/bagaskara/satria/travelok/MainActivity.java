package bagaskara.satria.travelok;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textkota;
    private TextView textpesawat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textkota = findViewById(R.id.kota_text);
        textpesawat = findViewById(R.id.pesawat_text);
    }

    public void launchPilihKota(View view) {
        //Log.d("MainActivity", "Sudah masuk ke fungsi launchPilihKota");

        Intent pilihan_kota = new Intent(this, KotaActivity.class);

        startActivityForResult(pilihan_kota, 111);
    }

    public void launchPilihPesawat(View view) {
        Log.d("MainActivity", "Sudah masuk ke fungsi launchPilihPesawat");

        Intent pilihan_pesawat = new Intent(this, PesawatActivity.class);

        startActivityForResult(pilihan_pesawat, 112);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 111) {
            if (resultCode == RESULT_OK) {
                String replykota = data.getStringExtra("REPLY_KOTA");
                textkota.setText(replykota);
            }
        }

        if (requestCode == 112) {
            if (resultCode == RESULT_OK) {
                String reply_pesawat = data.getStringExtra("REPLY_PESAWAT");
                textpesawat.setText(reply_pesawat);
            }
        }

    }

}
