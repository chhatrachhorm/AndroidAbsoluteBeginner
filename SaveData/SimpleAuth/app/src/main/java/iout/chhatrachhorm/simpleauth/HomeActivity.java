package iout.chhatrachhorm.simpleauth;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        TextView welcome = findViewById(R.id.home_name);
        welcome.setText(getString(R.string.welcome, name));
        findViewById(R.id.home_sign_out_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearToken();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.auth_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.auth_logout){
            clearToken();
        }
        return true;
    }
    private void clearToken(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.auth_name), "");
        editor.putString(getString(R.string.auth_email), "");
        editor.putString(getString(R.string.auth_phone), "");
        editor.putString(getString(R.string.authTokenKey), "no_token").apply();
        checkToken();
    }
}
