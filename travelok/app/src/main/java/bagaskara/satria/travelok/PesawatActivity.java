package bagaskara.satria.travelok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PesawatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesawat);
    }

    String reply_pesawat;

    public void reply_garuda(View view) {
        reply_pesawat = "GARUDA";

        Intent replyIntent = new Intent();
        replyIntent.putExtra("REPLY_PESAWAT", reply_pesawat);

        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void reply_etihad(View view) {
        reply_pesawat = "ETIHAD";

        Intent replyIntent = new Intent();
        replyIntent.putExtra("REPLY_PESAWAT", reply_pesawat);

        setResult(RESULT_OK, replyIntent);
        finish();


    }

    public void reply_airasia(View view) {
        reply_pesawat = "AIR ASIA";

        Intent replyIntent = new Intent();
        replyIntent.putExtra("REPLY_PESAWAT", reply_pesawat);

        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void reply_satria(View view) {
        reply_pesawat="Satria Cargo";
         Intent replyIntent=new Intent();
         replyIntent.putExtra("REPLY_PESAWAT",reply_pesawat);

         setResult(RESULT_OK,replyIntent);
         finish();
    }
}
