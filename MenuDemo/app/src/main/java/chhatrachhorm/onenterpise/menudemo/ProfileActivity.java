package chhatrachhorm.onenterpise.menudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle("Profile Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
