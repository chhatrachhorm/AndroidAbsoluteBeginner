package onenterprise.tra.bindingservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyBoundService myBoundService;
    private boolean bindServiceStatus = false;
    EditText num1, num2;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService.LocalBinder binder = (MyBoundService.LocalBinder) iBinder;
            myBoundService = binder.getService();
            bindServiceStatus = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            bindServiceStatus = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.main_first_num);
        num2 = findViewById(R.id.main_second_num);
    }
    public void bindMyService(View view){
        if(!bindServiceStatus){
            Intent i = new Intent(this, MyBoundService.class);
            bindService(i, serviceConnection, Context.BIND_AUTO_CREATE);
            Toast.makeText(this, "Binding Service started", Toast.LENGTH_LONG).show();
        }
    }
    public void unBindMyService(View view){
        if(bindServiceStatus){
            unbindService(serviceConnection);
            bindServiceStatus = false;
        }

    }
    public void addNumber(View view){
        if(bindServiceStatus){
            Toast.makeText(
                    MainActivity.this,
                    String.valueOf(myBoundService.add(Integer.parseInt(num1.getEditableText().toString()), Integer.parseInt(num2.getEditableText().toString()))),
                    Toast.LENGTH_LONG
            ).show();
        }else Toast.makeText(this, "Please Bind the Service First", Toast.LENGTH_LONG).show();
    }
}
