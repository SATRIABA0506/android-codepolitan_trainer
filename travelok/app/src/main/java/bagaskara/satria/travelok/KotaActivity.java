package bagaskara.satria.travelok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class KotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kota);
    }

    String reply_result;

    public void reply_jakarta(View view) {
        reply_result = "JAKARTA";

        Intent replyIntent = new Intent();
        replyIntent.putExtra("REPLY_KOTA", reply_result);

        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void reply_bandung(View view) {
        reply_result = "BANDUNG";///////////////////////////////////

        Intent replyIntent = new Intent();
        replyIntent.putExtra("REPLY_KOTA", reply_result);

        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void reply_surabaya(View view) {
        reply_result = "SURABAYA";

        Intent replyIntent = new Intent();
        replyIntent.putExtra("REPLY_KOTA", reply_result);

        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void reply_german(View view) {
        reply_result="German";

        Intent replyIntent=new Intent();
        replyIntent.putExtra("REPLY_KOTA",reply_result);

        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
