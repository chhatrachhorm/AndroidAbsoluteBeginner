package chhatrachhorm.onenterpise.dynamicuifragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = findViewById(R.id.main_toolbar);
        // configure toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Tab Fragment");

        Button TFAbtn = findViewById(R.id.main_tfa);
        TFAbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TapFragmentActivity.class));
            }
        });

    }
}
