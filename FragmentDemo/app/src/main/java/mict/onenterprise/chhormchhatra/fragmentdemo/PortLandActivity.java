package mict.onenterprise.chhormchhatra.fragmentdemo;


import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
* Associated Fragments :
*   PortraitFragment
*   LandscapeFragment
* Technique :
*   Use FragmentManagers to inflate fragments into Activity by finding the container
*       view in the Activity by Id (doesn't use fragment in the activity to link the fragment class directly)
*   Use getResources().getConfiguration() to get the screen orientation and display it accordingly
* */
public class PortLandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pot_land);

//        FragmentManager mFragmentManger = getFragmentManager();
        FragmentTransaction mTransaction = getFragmentManager().beginTransaction();
        Configuration mConfig = getResources().getConfiguration();

        if(mConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            mTransaction.replace(android.R.id.content, new PortraitFragment()).commit();
        }else{
            mTransaction.replace(android.R.id.content, new LandscapeFragment()).commit();
        }


    }
}
