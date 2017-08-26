package chhatrachhorm.onenterpise.calculator;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button PlusBtn, MinusBtn, MultiBtn, DiviBtn, EqualBtn;
    private TextInputEditText mInputOutput;
    private boolean isInitial, isNum1;
    private float num1, num2, ans;
    private String operator;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlusBtn = findViewById(R.id.plus);
        MinusBtn = findViewById(R.id.minus);
        MultiBtn = findViewById(R.id.multi);
        DiviBtn = findViewById(R.id.division);
        EqualBtn = findViewById(R.id.equal);
        mInputOutput = findViewById(R.id.main_input_output);
        mTextView = findViewById(R.id.answer);
        isInitial = true;
        isNum1 = false;
        num1 = num2 = ans = 0;
        operator = "default";
        mInputOutput.setText("");

        PlusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInput();
                operator = "plus";

            }
        });

        MinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInput();
                operator = "minus";
            }
        });
        MultiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInput();
                operator = "multiply";
            }
        });
        DiviBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInput();
                operator = "division";

            }
        });
        EqualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInput();
                if(isNum1)
                switch (operator){
                    case "plus":
                        ans = num1 + num2;
                        break;
                    case "minus":
                        ans = num1 - num2;
                        break;
                    case "multiply":
                        ans = num1 * num2;
                        break;
                    case "division":
                        if(Float.compare(num2, 0) != 0)
                            ans = num1 / num2;
                        else ans = 0;
                        break;
                }
                mTextView.setText("The ans: " +ans);
                operator = "default";
                isNum1 = false;
                num1 = num2 = ans = 0;
            }
        });

    }
    private void getInput(){
        if(!mInputOutput.getEditableText().toString().isEmpty()){
            if(isInitial){
                num1 = Float.parseFloat(mInputOutput.getEditableText().toString());
                mInputOutput.setText("");
                isInitial = false;
                isNum1 = true;
            }else{
                num2 = Float.parseFloat(mInputOutput.getEditableText().toString());
                mInputOutput.setText("");
                isInitial = true;
            }
        }
    }
}
