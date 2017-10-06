package chhatrachhorm.onenterpise.savingdata;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // setting toolbar
        getSupportActionBar().setTitle("Key Value Demo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView mKeyValue = findViewById(R.id.result_key_value);

        // to read data from key value
        // get parent key
        SharedPreferences sharedPreferences = getApplicationContext()
                .getSharedPreferences(getString(R.string.parentKey), Activity.MODE_PRIVATE);
        // read one of the child key from the parent key
        String keyValue = sharedPreferences.getString(getString(R.string.keyValueUserInput), "Default");
        mKeyValue.setText(getString(R.string.resultKeyValue, keyValue));



    }
}
