package chhatrachhorm.onenterpise.userinterface;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Dynamic Elements
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
            // make text view
            TextView mTextView = new TextView(this);
            mTextView.setId(i+1);
            mTextView.setText(getString(R.string.page_number, (i+1)));
            // make linear layout
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.dynamic_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.menu_main:
                startActivity(new Intent(DynamicElements.this, MainActivity.class));
                finish();
                break;
            case R.id.menu_dev:
                Intent me = new Intent(Intent.ACTION_VIEW);
                me.setData(Uri.parse(getString(R.string.my_url)));
                startActivity(me);
                break;
        }
        return true;
    }
}
