package bagaskara.satria.twoactivitis;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
private TextView textMessage;
private EditText replyMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textMessage=findViewById(R.id.text_message);
        replyMessage=findViewById(R.id.replyText);

        Intent intent=getIntent();
        String message = intent.getStringExtra("MESSAGE");
        textMessage.setText(message);

    }
    public void returnReply(View view){
        String reply = replyMessage.getText().toString();
        replyMessage=findViewById(R.id.replyText);

        Intent replyIntent= new Intent();
        replyIntent.putExtra("REPLY",reply);

        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
