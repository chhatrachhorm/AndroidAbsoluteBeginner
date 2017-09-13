package chhatrachhorm.onenterpise.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FrameViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_view);

        final LinearLayout mPage1 = findViewById(R.id.fva_page1);
        final LinearLayout mPage2 = findViewById(R.id.fva_page2);

        final Button mPrev = findViewById(R.id.fva_prev_btn);
        final Button mNext = findViewById(R.id.fva_next_btn);

        mPage1.setVisibility(View.VISIBLE);

        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPage1.setVisibility(View.VISIBLE);
                mPage2.setVisibility(View.GONE);
            }
        });
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPage1.setVisibility(View.GONE);
                mPage2.setVisibility(View.VISIBLE);
            }
        });

    }
}
