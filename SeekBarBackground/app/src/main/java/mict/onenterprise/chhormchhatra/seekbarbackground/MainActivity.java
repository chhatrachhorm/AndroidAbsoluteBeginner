package mict.onenterprise.chhormchhatra.seekbarbackground;


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
        Button mFMC = findViewById(R.id.fmc_btn);
        Button mRCA = findViewById(R.id.rca_btn);
        Button mCMA = findViewById(R.id.cm_btn);
        mFMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FixedMixedColorActivity.class));
            }
        });
        mRCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RandomColorActivity.class));
            }
        });
        mCMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ColorMixerActivity.class));
            }
        });

    }


}
