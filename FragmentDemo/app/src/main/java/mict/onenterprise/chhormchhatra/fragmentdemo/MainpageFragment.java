package mict.onenterprise.chhormchhatra.fragmentdemo;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainpageFragment extends Fragment {


    private View mView;
    private FrameLayout mFrame;
    private int pages = 0;
    private int index = 0;
    public MainpageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_mainpage, container, false);
        mFrame = mView.findViewById(R.id.frag_main_frameLayout);

        // generate pages
        for(int i =0 ; i<100; i++){
            LinearLayout l = new LinearLayout(getActivity().getApplicationContext());
            l.setOrientation(LinearLayout.VERTICAL);
            l.setId(i);
            TextView t = new TextView(getActivity().getApplicationContext());
            t.setText(getString(R.string.page_number_index, (i+1)));
            l.addView(t);
            l.setVisibility(View.INVISIBLE);
            l.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            l.setBackgroundColor(Color.argb(255, 150, 120, 120));
            mFrame.addView(l);
        }

        mFrame.getChildAt(index).setVisibility(View.VISIBLE);
        pages = mFrame.getChildCount();

        final Button mPrev = mView.findViewById(R.id.frag_main_prev);
        final Button mNext = mView.findViewById(R.id.frag_main_next);

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

        final EditText mPageNum = mView.findViewById(R.id.frag_main_go_edit);
        final Button mGo = mView.findViewById(R.id.frag_main_go);
        mGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mPageNum.getEditableText() != null){
                    int go = Integer.parseInt(mPageNum.getEditableText().toString()) - 1;
                    if(go >= 0 && go <= pages - 1)
                        showPages(index, go);
                    else Toast.makeText(getActivity().getApplicationContext(), "Please Enter from 1 to 100 only", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return mView;
    }
    public void showPages(int index, int newIndex){
        if(!(index==newIndex)){
            mFrame.getChildAt(index).setVisibility(View.INVISIBLE);
            mFrame.getChildAt(newIndex).setVisibility(View.VISIBLE);
            this.index = newIndex;
        }
    }

}
