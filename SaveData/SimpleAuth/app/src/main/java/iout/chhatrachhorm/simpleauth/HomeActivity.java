package iout.chhatrachhorm.simpleauth;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreferences = this.getSharedPreferences(getString(R.string.parentKey), Activity.MODE_PRIVATE);
        checkToken();
        String name = sharedPreferences.getString(getString(R.string.auth_name), "No Name");
//        String email = sharedPreferences.getString(getString(R.string.auth_email), "No Email");
        TextView welcome = findViewById(R.id.home_name);
        welcome.setText(getString(R.string.welcome, name));
        findViewById(R.id.home_sign_out_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getString(R.string.auth_name), "");
                editor.putString(getString(R.string.auth_email), "");
                editor.putString(getString(R.string.auth_phone), "");
                editor.putString(getString(R.string.authTokenKey), "no_token").apply();
                checkToken();
            }
        });

    }
    private void checkToken(){
        String token = sharedPreferences.getString(getString(R.string.authTokenKey), "no_token");
        if(token.equals("no_token")){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}
