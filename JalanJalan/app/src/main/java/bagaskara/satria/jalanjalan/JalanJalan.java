package bagaskara.satria.jalanjalan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JalanJalan extends AppCompatActivity {
    private TextView textkota;
    private TextView textpesawat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jalan_jalan);
        textkota =findViewById(R.id.textKota);
        textpesawat=findViewById(R.id.textPesawat);

    }

    public void launchPilihPesawat(View view) {
        Intent replyPesawat=new Intent(this,Pesawat.class);
        startActivityForResult(replyPesawat,2);

    }

    public void launchPilihKota(View view) {
        Intent replyKota=new Intent(this,Kota.class);
        startActivityForResult(replyKota,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1) {
            if (resultCode == RESULT_OK) {
                String ReplyKota = data.getStringExtra("PILIHKOTA");
                textkota.setText(ReplyKota);
            }
        }
        if(requestCode==2){
            if(resultCode==RESULT_OK){
                String ReplyPesawat=data.getStringExtra("PILIHPESAWAT");
                textpesawat.setText(ReplyPesawat);
            }

        }
    }
}
