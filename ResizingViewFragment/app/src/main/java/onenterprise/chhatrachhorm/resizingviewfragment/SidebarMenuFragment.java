package onenterprise.chhatrachhorm.resizingviewfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SidebarMenuFragment extends Fragment {

    ButtonClickListener buttonClickListener;

    public SidebarMenuFragment() {
        // Required empty public constructor
    }
    public interface ButtonClickListener{
        void setWebsiteUrl(String url);
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        buttonClickListener = (ButtonClickListener) context;
//    }

    protected void onWebButtonClick(String webUrl){
        buttonClickListener.setWebsiteUrl(webUrl);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_sidebar_menu, container, false);
        buttonClickListener = (ButtonClickListener) getActivity();
        mView.findViewById(R.id.youtube_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWebButtonClick("https://www.youtube.com/watch?v=HPz-Ifn6vOs&index=5&list=PLN7CFnnUrUvyrUBmD5omeoSNHwpnJwiae");
            }
        });
        mView.findViewById(R.id.facebook_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWebButtonClick("https://www.facebook.com/chhatra.chhorm");
            }
        });
        mView.findViewById(R.id.github_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWebButtonClick("https://github.com/chhatrachhorm/");
            }
        });
        return mView;
    }

}
