package mict.onenterprise.chhormchhatra.fragmentdemo;


import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private LinearLayout mLinearLayout;
    private View mMenuFragment;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mMenuFragment = inflater.inflate(R.layout.fragment_menu, container, false);

        mLinearLayout = mMenuFragment.findViewById(R.id.frag_menu);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            setLayout(true);
        }else setLayout(false);
        return mMenuFragment;
    }

    protected void setLayout(boolean isLandscape){
        if(isLandscape)
            mLinearLayout.setOrientation(LinearLayout.VERTICAL);
        else mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
    }


}
