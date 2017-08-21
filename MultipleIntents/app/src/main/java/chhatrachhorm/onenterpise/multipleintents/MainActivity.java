package chhatrachhorm.onenterpise.multipleintents;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mGoBtn;
    private TextInputEditText mPageNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGoBtn = findViewById(R.id.main_go_btn);
        mPageNumber = findViewById(R.id.main_navigator);

        mGoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer pageNum = Integer.parseInt(mPageNumber.getEditableText().toString());
                switch (pageNum){
                    case 1:
                        startActivity(new Intent(MainActivity.this, Act1Activity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, Act2Activity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, Act3Activity.class));
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Please input number from 1-3 only", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}
