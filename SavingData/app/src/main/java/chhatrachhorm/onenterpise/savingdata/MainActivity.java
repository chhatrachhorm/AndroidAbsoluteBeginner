package chhatrachhorm.onenterpise.savingdata;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    /**
     * Ways to Store Data :
     *
     *
     * Key Value:
     * 1. instantiate sharePref from SharePreferences Class by passing ParentKey and Activity.MODE_PRIVATE)
     * 2. to edit or to write :
     *      a. instantiate editor from SharePreferences.Editor and use putString or putInt (passing key and Value)
     *      b. then call .commit() or .apply()
     * 3. to read (Result Activity for more)
     *      a. call sharePref.getInt or getString by passing two params : child_key and default value
     *      e.g. String keyValue = sharedPreferences.getString(getString(R.string.keyValueUserInput), "Default");
     *
     * SQLite Database :
     * 1. create DatabaseHelper Class for SQLite => SQLiteHelper that extends SQLiteOpenHelper
     * (go to the class and see)
     * 2. instantiate the SQLiteHelper class in the activity
     *
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Various Way to work with Data");


        // Storing Data with KeyValue
        final TextInputEditText mKeyValInput = findViewById(R.id.main_key_val_input);
        Button mSeeKeyVal = findViewById(R.id.main_see_key_val);
        mSeeKeyVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String KeyVal = mKeyValInput.getEditableText().toString();
                if(!(KeyVal.isEmpty())){
                    Context ctx = getApplicationContext();
                    SharedPreferences sharedPreferences = ctx
                            .getSharedPreferences(getString(R.string.parentKey), Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(getString(R.string.keyValueUserInput), KeyVal).apply();

                    // start result activity
                    startActivity(new Intent(MainActivity.this, ResultActivity.class));
                }else{
                    Toast.makeText(MainActivity.this, "Please Enter Something", Toast.LENGTH_LONG).show();
                }
            }
        });

        // starting SQLite demo
        Button mSQLiteDemoBtn = findViewById(R.id.main_sqlitedemo_btn);
        mSQLiteDemoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SQLDemoActivity.class));
            }
        });


    }
}
