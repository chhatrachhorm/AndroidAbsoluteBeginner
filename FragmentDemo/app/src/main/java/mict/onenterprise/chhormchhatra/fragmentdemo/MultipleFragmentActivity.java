package mict.onenterprise.chhormchhatra.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MultipleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_fragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FragmentManager mFragmentManager = getFragmentManager();
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();

        Configuration mConf = getResources().getConfiguration();
        if(mConf.orientation == Configuration.ORIENTATION_LANDSCAPE){
            findViewById(R.id.amf_portrait).setVisibility(View.GONE);
            mTransaction.replace(R.id.amf_left_menu, new MenuFragment());
            mTransaction.replace(R.id.amf_main_page, new MainpageFragment());
            mTransaction.commit();
        }else{
            findViewById(R.id.amf_landscape).setVisibility(View.GONE);
            mTransaction.replace(R.id.amf_main_page_top, new MainpageFragment());
            mTransaction.replace(R.id.amf_main_menu_bottom, new MenuFragment());
            mTransaction.commit();
        }
    }
}
