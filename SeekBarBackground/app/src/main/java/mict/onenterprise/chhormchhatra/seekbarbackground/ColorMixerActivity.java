package mict.onenterprise.chhormchhatra.seekbarbackground;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.TextView;

public class ColorMixerActivity extends AppCompatActivity {

    private SeekBar mRedSeekBar, mGreenSeekbar, mBlueSeekbar;
    private TextView mPercentage;
    private ConstraintLayout mLayout;
    private FrameLayout mColorMixerDemo;
//    private FrameLayout mRedDemo, mGreenDemo, mBlueDemo;
    private TextInputEditText mALphaInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_mixer);
        mRedSeekBar = findViewById(R.id.cma_red_seekbar);
        mGreenSeekbar = findViewById(R.id.cma_green_seekbar);
        mBlueSeekbar = findViewById(R.id.cma_blue_seekbar);

        mRedSeekBar.setMax(255);
        mGreenSeekbar.setMax(255);
        mBlueSeekbar.setMax(255);

        Button mSetBack  = findViewById(R.id.cma_background);
        mSetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackColor();

            }
        });


        mPercentage = findViewById(R.id.cm_color_percentage);

        mLayout = findViewById(R.id.cma_layout);

//        mRedDemo = findViewById(R.id.cma_red_demo);
//        mGreenDemo = findViewById(R.id.cma_green_demo);
//        mBlueDemo = findViewById(R.id.cma_blue_demo);
        mColorMixerDemo = findViewById(R.id.cma_mixed_color_demo);

        mALphaInput = findViewById(R.id.cm_alpha);

        mRedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mGreenSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mBlueSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    private void setColor(){
        int r = mRedSeekBar.getProgress();
        int g = mGreenSeekbar.getProgress();
        int b = mBlueSeekbar.getProgress();
        String s = mALphaInput.getEditableText().toString();
        int alpha = s.isEmpty()?255:(
                Integer.parseInt(s)>=255?255:Integer.parseInt(s)
                );
        mALphaInput.setText(getString(R.string.alpha_val, alpha));
        int color = Color.argb(alpha, r, g, b);
        mColorMixerDemo.setBackgroundColor(color);
        mPercentage.setText(getString(R.string.color_percentage, r, g, b, alpha));
    }
    private void setBackColor(){
        setColor();
            int r = mRedSeekBar.getProgress();
            int g = mGreenSeekbar.getProgress();
            int b = mBlueSeekbar.getProgress();
            String s = mALphaInput.getEditableText().toString();
            int alpha = s.isEmpty()?255:(
                    Integer.parseInt(s)>=255?255:Integer.parseInt(s)
            );
            int color = Color.argb(alpha, r, g, b);
            mLayout.setBackgroundColor(color);

    }
}
