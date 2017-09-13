package chhatrachhorm.onenterpise.userinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button mGridView = findViewById(R.id.main_gridview);
        mGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GridViewActivity.class));
            }
        });
        final Button mICA = findViewById(R.id.main_ica);
        mICA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InputControlsActivity.class));
            }
        });
        final Button mAA = findViewById(R.id.main_ala);
        mAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AlertActivity.class));
            }
        });
        final Button mFVA = findViewById(R.id.main_frame);
        mFVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FrameViewActivity.class));
            }
        });
        final Button mDynamic = findViewById(R.id.main_dynamic_page);
        mDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DynamicElements.class));
            }
        });

        final Button mSWVA = findViewById(R.id.swva_btn);
        mSWVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SimpleWebViewActivity.class));
            }
        });

    }
}
