package iout.chhatrachhorm.simpleauth;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private SQLiteHelper sqLiteHelper;

    private TextInputEditText mSignInEmail, mSignInPass;
    private TextInputEditText mSignUpName, mSignUpEmail, mSignUpPhone, mSignUpPass, mSignUpConfirm;
    private TextView mFormSignIn, mFormSignUp;
    private ConstraintLayout mSignIn, mSignUp;

    private static boolean isSignUpForm = false;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteHelper = new SQLiteHelper(this);
        mSignInEmail = findViewById(R.id.main_email_sing_in);
        mSignInPass = findViewById(R.id.main_password_sign_in);
        Button mSignInBtn = findViewById(R.id.main_sign_in_btn);
        Button mSignUpNav = findViewById(R.id.main_sign_up_nav);
        Button mSignUpBtn = findViewById(R.id.main_sign_up_btn);
        mSignUpName = findViewById(R.id.main_name_sign_up);
        mSignUpEmail = findViewById(R.id.main_email_sign_up);
        mSignUpPhone = findViewById(R.id.main_phone_sign_up);
        mSignUpPass = findViewById(R.id.main_password_sign_up);
        mSignUpConfirm = findViewById(R.id.main_con_pass_sign_up);
        mFormSignIn = findViewById(R.id.main_sign_in_form_error);
        mFormSignUp = findViewById(R.id.main_sign_up_form_error);
        mSignIn = findViewById(R.id.main_sign_in);
        mSignUp = findViewById(R.id.main_sign_up);
        FloatingActionButton fab = findViewById(R.id.main_sign_up_cancel);

        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signingIn();
            }
        });
        mSignUpNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeForm();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeForm();
            }
        });
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpValidation();
            }
        });

        sharedPreferences = this.getSharedPreferences(getString(R.string.parentKey), Activity.MODE_PRIVATE);
        String token = sharedPreferences.getString(getString(R.string.authTokenKey), "no_token");
        if(!token.equals("no_token")){
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        if(isSignUpForm){
            changeForm();
        }else{
            super.onBackPressed();
        }
    }

    private void setToken(String name, String email, String phone){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.auth_name), name);
        editor.putString(getString(R.string.auth_email), email);
        editor.putString(getString(R.string.auth_phone), phone);
        editor.putString(getString(R.string.authTokenKey), name + email).apply();
    }
    private void signingIn(){
        String email = mSignInEmail.getEditableText().toString();
        String password = mSignInPass.getEditableText().toString();
        String[] validation = FormValidation.emailPassValidation(email, password);
        if(validation[0].equals("valid")){
            Cursor res = sqLiteHelper.getCredential(email, password);
            if(res.getCount()!=0){
                while (res.moveToNext()){
                    Intent startHome = new Intent(MainActivity.this, HomeActivity.class);
                    setToken(res.getString(0), res.getString(1), res.getString(2));
                    startActivity(startHome);
                    finish();
                }
            }else{
                setAlertError("No Credential Found");
            }
        }
        setSignInErrorForm(validation[1]);
    }
    private void setSignInErrorForm(String error){
        mFormSignIn.setText(error);
    }
    private void setSignUpErrorForm(String error){
        mFormSignUp.setText(error);
    }
    private void setAlertError(String message){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }
    private void signUpValidation(){
        String name = mSignUpName.getEditableText().toString();
        String email = mSignUpEmail.getEditableText().toString();
        String phone = mSignUpPhone.getEditableText().toString();
        String password = mSignUpPass.getEditableText().toString();
        String confirmPass = mSignUpConfirm.getEditableText().toString();
        String[] validation = FormValidation.signUpValidation(name, email, phone, password, confirmPass);
        if(validation[0].equals("valid")){
            if(sqLiteHelper.insertCredential(name, email, phone, password)){
                Cursor res = sqLiteHelper.getCredential(email, password);
                if(res.getCount()!=0){
                    while (res.moveToNext()){
                        Intent startHome = new Intent(MainActivity.this, HomeActivity.class);
                        setToken(res.getString(0), res.getString(1), res.getString(2));
                        startActivity(startHome);
                        finish();
                    }
                }
            }else setAlertError("The email is already exist");
        }
        setSignUpErrorForm(validation[1]);

    }
    private void changeForm(){
        if(!isSignUpForm){
            mSignIn.setVisibility(View.GONE);
            mSignUp.setVisibility(View.VISIBLE);
            isSignUpForm = true;
        }else{
            mSignIn.setVisibility(View.VISIBLE);
            mSignUp.setVisibility(View.GONE);
            isSignUpForm = false;
        }
    }
}