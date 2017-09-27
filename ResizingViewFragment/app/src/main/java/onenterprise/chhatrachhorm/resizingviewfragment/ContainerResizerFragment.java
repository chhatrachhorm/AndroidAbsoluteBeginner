package onenterprise.chhatrachhorm.resizingviewfragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContainerResizerFragment extends Fragment {

    protected ChangeSizeListener changeSizeListener;
    private SeekBar mWidth, mHeight;

    public ContainerResizerFragment() {
        // Required empty public constructor
    }

    public interface ChangeSizeListener{
        void setSize(int width, int height);
    }

    public void setMaxValues(int width, int height){
        mWidth.setMax(width);
        mHeight.setMax(height);
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        changeSizeListener = (ChangeSizeListener) context;
//    }

    protected void onResizedChange(){
        changeSizeListener.setSize(mWidth.getProgress(), mHeight.getProgress());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_container_resizer, container, false);
        changeSizeListener = (ChangeSizeListener) getActivity();
        mWidth = mView.findViewById(R.id.main_resize_frag_seekbar_width);
        mHeight = mView.findViewById(R.id.main_resize_frag_seekbar_height);
        // Listener
        mWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                onResizedChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                onResizedChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return mView;
    }

}
