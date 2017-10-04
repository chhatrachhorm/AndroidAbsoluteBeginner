package mict.onenterprise.chhormchhatra.fragmentdemo;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {

    private TopBottomFragListener topBottomFragListener;

    public TopFragment() {
        // Required empty public constructor
    }

    protected interface TopBottomFragListener{
        void setBackGround(int colorCode);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        topBottomFragListener = (TopBottomFragListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_top, container, false);
        final SeekBar mRedSeekBar = mView.findViewById(R.id.afi_red_seekbar);
        final SeekBar mGreenSeekBar = mView.findViewById(R.id.afi_green_seekbar);
        final SeekBar mBlueSeekBar = mView.findViewById(R.id.afi_blue_seekbar);
        mRedSeekBar.setMax(255);
        mGreenSeekBar.setMax(255);
        mBlueSeekBar.setMax(255);
        mView.findViewById(R.id.afi_set_background).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topBottomFragListener.setBackGround(Color.rgb(
                        mRedSeekBar.getProgress(),
                        mGreenSeekBar.getProgress(),
                        mBlueSeekBar.getProgress()
                ));
            }
        });
        return mView;
        
    }
}
