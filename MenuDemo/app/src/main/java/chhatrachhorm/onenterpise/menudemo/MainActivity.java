package chhatrachhorm.onenterpise.menudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
/**
 * 1. create menu resource directory, and main_menu.xml file
 * 2. include some items (unique id to each item)
 * 3. inflate the menu to the activity containing menu
 *      onCreateOptionsMenu() -> getMenuInflater.inflate(R.menu.main_menu, menu)
 * 4. Specifies callback action in onOptionsItemSelected
 * */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.main_menu_setting:
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                break;
            case R.id.main_menu_profile:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                break;
            case R.id.main_menu_log_out:
                startActivity(new Intent(MainActivity.this, LogoutActivity.class));
                break;
        }
        return true;
    }
}
