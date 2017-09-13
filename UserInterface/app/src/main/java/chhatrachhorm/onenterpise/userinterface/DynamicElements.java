package chhatrachhorm.onenterpise.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 *
 * Created by chhatra on 9/12/2017.
 */

public class DynamicElements extends AppCompatActivity {
    private int index = 0;
    private FrameLayout mFrame;
    private int pages = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        mFrame = findViewById(R.id.ad_frame_layout);
        // set pages
        for(int i = 0 ; i <100; i++){
            TextView mTextView = new TextView(this);
            mTextView.setId(i+1);
            mTextView.setText(getString(R.string.page_number, (i+1)));
            LinearLayout mLinearLayout = new LinearLayout(this);
            mLinearLayout.setId(i);
            mLinearLayout.setOrientation(LinearLayout.VERTICAL);
            mLinearLayout.addView(mTextView);
            mLinearLayout.setVisibility(View.INVISIBLE);
            mFrame.addView(mLinearLayout);

        }

        pages = mFrame.getChildCount();
        mFrame.getChildAt(index).setVisibility(View.VISIBLE);

        final Button mPrev = findViewById(R.id.ad_prev_btn);
        final Button mNext = findViewById(R.id.ad_next_btn);




        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPages(index, (index > 0)?(index-1):0);
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPages(index, (index<pages-1)?(index+1):(pages-1));
            }
        });

    }
    public void showPages(int index, int newIndex){
        // toast
        if(newIndex == 0)
            Toast.makeText(DynamicElements.this, getString(R.string.PrevMessage), Toast.LENGTH_SHORT).show();
        else if (newIndex == pages -1)
            Toast.makeText(DynamicElements.this, getString(R.string.NextMessage), Toast.LENGTH_SHORT).show();

        // Page navigation
        if(!(index==newIndex)){
            mFrame.getChildAt(index).setVisibility(View.INVISIBLE);
            mFrame.getChildAt(newIndex).setVisibility(View.VISIBLE);
            this.index = newIndex;
        }
    }
}
