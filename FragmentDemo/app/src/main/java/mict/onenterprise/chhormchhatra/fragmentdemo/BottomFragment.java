package mict.onenterprise.chhormchhatra.fragmentdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {

    private FrameLayout bottomFrag;

    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_bottom, container, false);
        bottomFrag = mView.findViewById(R.id.fragment_bottom_layout);
        return mView;
    }
    public void setBackground(int colorCode){
        bottomFrag.setBackgroundColor(colorCode);
        Log.i("COLORCODE", String.valueOf(colorCode));
    }

}
