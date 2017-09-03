package mict.onenterprise.chhormchhatra.seekbarbackground;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import java.util.Random;

public class RandomColorActivity extends AppCompatActivity {

    private SeekBar mSeekBar;
    private ConstraintLayout mLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_color);
        mSeekBar = findViewById(R.id.rca_seekbar);
        mLayout = findViewById(R.id.rca_layout);
        mSeekBar.setMax(100);
        final Random r = new Random();
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int color = Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256));
                mLayout.setBackgroundColor(color);
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
