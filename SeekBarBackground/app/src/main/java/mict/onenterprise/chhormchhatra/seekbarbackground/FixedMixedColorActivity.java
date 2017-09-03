package mict.onenterprise.chhormchhatra.seekbarbackground;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class FixedMixedColorActivity extends AppCompatActivity {
    private SeekBar mSeekBar;
    private ConstraintLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed_mixed_color);
        mSeekBar = findViewById(R.id.fmc_seekbar);
        mLayout = findViewById(R.id.fmc_layout);
        mSeekBar.setMax(100);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // for min sdk version < 21, use getResources.getColor()
                // for min sdk version >= 21, use getColor() directly
                if(i<25)mLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                else if(i<50)mLayout.setBackgroundColor(getResources().getColor(R.color.pink_darken_2));
                else if(i<75)mLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
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
