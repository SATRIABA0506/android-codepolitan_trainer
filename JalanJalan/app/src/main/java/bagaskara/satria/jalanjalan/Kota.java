package bagaskara.satria.jalanjalan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Kota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kota);
    }

    String replyresult;
    public void replybandung(View view) {
        replyresult="Bandung";
        Intent replyIntent=new Intent();
        replyIntent.putExtra("PILIHKOTA",replyresult);
        setResult(RESULT_OK,replyIntent);
        finish();
    }

    public void replyjakarta(View view) {
        replyresult="Jakarta";
        Intent replyIntent=new Intent();
        replyIntent.putExtra("PILIHKOTA",replyresult);
        setResult(RESULT_OK,replyIntent);
        finish();
    }

    public void replySurabaya(View view) {
    replyresult="Surabaya";
    Intent replyintent=new Intent();
    replyintent.putExtra("PILIHKOTA",replyresult);
    setResult(RESULT_OK,replyintent);
    finish();
    }
}
