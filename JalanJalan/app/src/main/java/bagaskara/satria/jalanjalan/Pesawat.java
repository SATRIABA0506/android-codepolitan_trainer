package bagaskara.satria.jalanjalan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pesawat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesawat);
    }
String Pesawat;
    public void replyPusaka(View view) {
        Pesawat="Pusaka Air";
        Intent replypesawat=new Intent();
        replypesawat.putExtra("PILIHPESAWAT",Pesawat);
        setResult(RESULT_OK,replypesawat);
        finish();
    }

    public void replyMandala(View view) {
        Pesawat="Mandala Air";
        Intent replypesawat=new Intent();
        replypesawat.putExtra("PILIHPESAWAT",Pesawat);
        setResult(RESULT_OK,replypesawat);
        finish();
    }

    public void replyBernabu(View view) {
        Pesawat="Bernabu Air";
        Intent replypesawat=new Intent();
        replypesawat.putExtra("PILIHPESAWAT",Pesawat);
        setResult(RESULT_OK,replypesawat);
        finish();
    }
}
