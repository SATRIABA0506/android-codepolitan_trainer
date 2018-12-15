package bagaskara.satria.helloworld;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount=0;
    private TextView mShowCount;

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ANGKA",mCount);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount=findViewById(R.id.countText);
    }
    public void showToast(View view){
        Toast toast= Toast.makeText(this,"Hallo",Toast.LENGTH_SHORT);
        toast.show();


    }
    public void countUP(View view){
    mCount++;
    mShowCount.setText(String.valueOf(mCount));
    }
}
