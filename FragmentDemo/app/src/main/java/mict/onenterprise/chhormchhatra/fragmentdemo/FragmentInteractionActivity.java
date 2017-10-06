package mict.onenterprise.chhormchhatra.fragmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
* Associated Fragment :
*   TopFragment
*   BottomFragment
* Techniques :
*   Sending Data between Fragments using an interface to listen
*   Using getSupportFragmentManager to findFragmentById
*   Using fragment with the fragment class name in Activity Layout instead of using FragmentTransaction
* */

public class FragmentInteractionActivity extends AppCompatActivity implements TopFragment.TopBottomFragListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragement_interaction);

    }

    @Override
    public void setBackGround(int colorCode) {
        BottomFragment bottomFragment = (BottomFragment) getSupportFragmentManager().findFragmentById(R.id.afi_bottom_fragment);
        bottomFragment.setBackground(colorCode);
    }
}
