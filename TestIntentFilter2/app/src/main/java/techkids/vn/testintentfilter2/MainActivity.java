package techkids.vn.testintentfilter2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView wvMain;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        getDataFromIntent();
        setupUI();
    }

    private void setupUI() {
        wvMain.setWebViewClient(new WebViewClient());
        if(url != null) {
            wvMain.loadUrl(url);
        }
    }

    private void getReferences() {
        wvMain = (WebView) findViewById(R.id.wv_main);
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null) {
            url = data.toString();
            Toast.makeText(MainActivity.this,
                    url + " (Suong qua)",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this,
                    "No data",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
