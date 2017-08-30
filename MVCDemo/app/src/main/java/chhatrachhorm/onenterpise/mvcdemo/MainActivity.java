package chhatrachhorm.onenterpise.mvcdemo;

import android.content.Intent;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/**
 * MVC
 * 1. create a Model Class with getter, setter, constructor and empty constructor
 * 2. get value from Model (model get value from DB, each var in Model class must be the same as the name in DB)
 * */

public class MainActivity extends AppCompatActivity {

    private TextInputEditText mUserName, mPassword;
    private Button mSingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserName = findViewById(R.id.main_username);
        mPassword = findViewById(R.id.main_password);
        mSingIn = findViewById(R.id.main_sign_in);


    }

    @Override
    protected void onStart() {
        super.onStart();
        final StudentModel studentModel = new StudentModel("123456", "chhatrachhorm@yahoo.com");
        mSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = mUserName.getEditableText().toString();
                String password = mPassword.getEditableText().toString();
                if(!(username.isEmpty() && password.isEmpty())){
                    if(username.equals(studentModel.getUserName()) && password.equals(studentModel.getPassword())){
                        Intent startHome = new Intent(MainActivity.this, HomeActivity.class);
                        startHome.putExtra("username", username);
                        startActivity(startHome);
                        finish();
                    }else Toast.makeText(MainActivity.this, "Either Username or Password is invalid", Toast.LENGTH_LONG).show();
                }else Toast.makeText(MainActivity.this, "Please Enter Username and Password", Toast.LENGTH_LONG).show();

            }
        });

    }
}
