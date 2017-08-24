package chhatrachhorm.onenterpise.seekbardemo;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private TextInputEditText mEditText;
    private SeekBar mSeekBar;
    int default_size = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.main_textview);
        mEditText = findViewById(R.id.main_input_text);
        mSeekBar = findViewById(R.id.main_seekBar);

        mSeekBar.setMax(100);
        mTextView.setTextSize(default_size);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String text = mEditText.getText().toString();
                if(text.isEmpty())
                    text = "Please Enter Something";
                mTextView.setText(text);
                mTextView.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
