package chhatrachhorm.onenterpise.mvcdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTextView =  findViewById(R.id.home_username);
        mTextView.setText(getIntent().getStringExtra("username"));

    }
}
