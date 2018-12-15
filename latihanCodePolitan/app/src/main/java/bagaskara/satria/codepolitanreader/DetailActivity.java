package bagaskara.satria.codepolitanreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {
WebView  webView;
    private Toolbar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);




        Artikel artikel=getIntent().getParcelableExtra("ARTIKEL");

        webView=findViewById(R.id.browser);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(artikel.getLink());

        getSupportActionBar().setTitle(artikel.getLink());
    }

//    public void setSupportActionBar(Toolbar supportActionBar) {
//        this.supportActionBar = supportActionBar;
//    }
}
