package onenterprise.chhatrachhorm.simpleservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startServiceMethod(View view){
        startService(new Intent(this, MyMediaService.class));

    }
    public void endServiceMethod(View view){
        stopService(new Intent(this, MyMediaService.class));

    }
}
