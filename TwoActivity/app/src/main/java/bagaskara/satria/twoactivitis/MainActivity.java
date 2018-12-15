package bagaskara.satria.twoactivitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mMessageEditText;
    private TextView replyText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        replyText = findViewById(R.id.reply_text);
    }

    public void launchSecondActivity(View view) {
        Log.d("MainActivity", "Sudah masuk launch");
        String message = mMessageEditText.getText().toString();
        Intent pindahIntent = new Intent(this, SecondActivity.class);
        pindahIntent.putExtra("MESSAGE", message);
        //startActivity(pindahIntent);
        startActivityForResult(pindahIntent, 212);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 212) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra("REPLY");
                replyText.setText(reply);
            }
        }
    }
}
