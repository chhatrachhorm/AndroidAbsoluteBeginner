package chhatrachhorm.onenterpise.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class SimpleWebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_web_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        WebView mWebView = findViewById(R.id.swva);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.chhorm-chhatra.ml/");
    }
}
