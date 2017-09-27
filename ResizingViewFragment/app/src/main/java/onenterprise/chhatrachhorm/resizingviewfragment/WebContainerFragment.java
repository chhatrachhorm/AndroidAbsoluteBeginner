package onenterprise.chhatrachhorm.resizingviewfragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebContainerFragment extends Fragment {


    private WebView mWebView;
    public WebContainerFragment() {
        // Required empty public constructor
    }


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_web_container, container, false);
        mWebView = mView.findViewById(R.id.main_web_frag);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://github.com/chhatrachhorm/");
        mWebView.setWebViewClient(new InternalWebView());
        return mView;
    }
    public class InternalWebView extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void setWebURL(String webURL){
        mWebView.loadUrl(webURL);
    }

}
