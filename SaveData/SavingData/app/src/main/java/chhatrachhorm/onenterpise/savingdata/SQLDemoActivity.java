package chhatrachhorm.onenterpise.savingdata;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SQLDemoActivity extends AppCompatActivity {

    private SQLiteHelper mSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqldemo);

        // binding view
        Button mSaveData = findViewById(R.id.sqldemo_save_btn);
        final TextInputEditText mUsername = findViewById(R.id.sqldemo_username);
        final TextInputEditText mEmail = findViewById(R.id.sqldemo_email);


        // instantiate SQLiteHelper Class
        mSQLiteHelper = new SQLiteHelper(SQLDemoActivity.this);

        mSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsername.getEditableText().toString();
                String email = mEmail.getEditableText().toString();
                if(!(username.isEmpty() && email.isEmpty())){
                    if(mSQLiteHelper.insertDat(username, email)){
                        Toast.makeText(SQLDemoActivity.this, "Your Data Has Been Saved", Toast.LENGTH_LONG).show();
                    }else Toast.makeText(SQLDemoActivity.this, "Failed to Save Data", Toast.LENGTH_LONG).show();

                }else Toast.makeText(SQLDemoActivity.this, "Please Fill out all the field", Toast.LENGTH_LONG).show();
            }
        });

        // button to query all data from DB
        Button mShowAllData = findViewById(R.id.sqldemo_show_all_data);
        mShowAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor mCursor = mSQLiteHelper.getAllData();

                if(mCursor.getCount() != 0){
                    StringBuilder stringBuffer = new StringBuilder();

                    // loop through cursor obj getting from DB
                    while (mCursor.moveToNext()){
                        // index starts from 0
                        stringBuffer.append("Id: ").append(mCursor.getInt(0)).append("\n");
                        stringBuffer.append("UserName: ").append(mCursor.getString(1)).append("\n");
                        stringBuffer.append("Email: ").append(mCursor.getString(2)).append("\n\n");
                    }
                    showMessage("Success", stringBuffer.toString());

                }else showMessage("Error", "Sorry, No Data has been found");

            }
        });

        // button to query search
        final TextInputEditText mSearchInput = findViewById(R.id.sqldemo_search);
        Button mSearch = findViewById(R.id.sqldemo_search_btn);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mSearchInput.getEditableText().toString();
                if(!email.isEmpty()){
                    Cursor mCursor = mSQLiteHelper.getDataByEmail(email);
                    List<String> emailFounds = new ArrayList<>();
                    if(mCursor.getCount()!=0){
                        while(mCursor.moveToNext()){
                            String e = mCursor.getString(mCursor.getColumnIndexOrThrow(SQLiteHelper.COL_3));
                            emailFounds.add(e);
                        }
                        showMessage("What We Found", emailFounds.toString());
                    }else showMessage("Nothing", "Sorry We have found nothing");
                }else Toast.makeText(SQLDemoActivity.this, "Please Enter Something to search", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showMessage(String title, String message){
        new AlertDialog.Builder(SQLDemoActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }

}
