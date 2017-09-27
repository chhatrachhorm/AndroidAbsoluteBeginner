package onenterprise.chhatrachhorm.resizingviewfragment;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements ContainerResizerFragment.ChangeSizeListener, SidebarMenuFragment.ButtonClickListener{


    private int Width, Height;
    private WebContainerFragment webContainerFragment;
    private ContainerResizerFragment containerResizerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        webContainerFragment = (WebContainerFragment) manager.findFragmentById(R.id.main_web_container_fragment);
        DisplayMetrics displayMetrics = new DisplayMetrics();

        webContainerFragment.getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Width = displayMetrics.widthPixels;
        Height = displayMetrics.heightPixels;

        containerResizerFragment = (ContainerResizerFragment) manager.findFragmentById(R.id.main_resizer_fragment);
        containerResizerFragment.setMaxValues(Width, Height);

    }

    @Override
    public void setWebsiteUrl(String url) {
        webContainerFragment.setWebURL(url);
    }

    @Override
    public void setSize(int width, int height) {
        ViewGroup.LayoutParams layoutParams = webContainerFragment.getView().getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        webContainerFragment.getView().setLayoutParams(layoutParams);
    }
}
