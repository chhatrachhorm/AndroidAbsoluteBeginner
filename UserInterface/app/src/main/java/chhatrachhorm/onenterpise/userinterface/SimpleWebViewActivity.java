package chhatrachhorm.onenterpise.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SimpleWebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_web_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        WebView mWebView = findViewById(R.id.swva);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new InternalWebView());
        mWebView.loadUrl("http://www.chhorm-chhatra.ml/");
    }
    // Loading internal web browser
    protected class InternalWebView extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
