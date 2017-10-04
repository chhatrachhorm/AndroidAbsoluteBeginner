package mict.onenterprise.chhormchhatra.fragmentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mPLA = findViewById(R.id.main_pla_btn);
        mPLA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PortLandActivity.class));
            }
        });
        Button mMPF = findViewById(R.id.main_multiple_fragment);
        mMPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MultipleFragmentActivity.class));
            }
        });
        findViewById(R.id.main_afi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FragmentInteractionActivity.class));
            }
        });
    }
}
