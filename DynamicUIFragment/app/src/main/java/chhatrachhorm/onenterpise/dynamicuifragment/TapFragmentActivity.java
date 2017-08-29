package chhatrachhorm.onenterpise.dynamicuifragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class TapFragmentActivity extends AppCompatActivity {


    /**
     * creating taps with fragment
     * 1. make 2 or 3 fragments
     *  - right click on project
     *  -> new -> fragment
     *  -> give a name
     *  -> exclude fragment factory() and onInterfaceCallback()
     * 2. create layout resource file for toolbar v7 and change the style to no action bar
     * 3. include App bar layout, tab layout, and viewPager in activity_fragment
     * 4. link view with this file
     * 5. create a class called SectionsPagerAdapter that extends FragmentPagerAdapter - to map tab and fragment
     * 6. set position, name, max_tab in SectionsPagerAdapter
     * */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_fragment);

        // initialize local var
        Toolbar mToolbar;
        TabLayout mTabLayout;
        ViewPager mViewPager;
        // to map fragment and tab
        SectionsPagersAdapter mSectionsPagerAdapter;


        // mapping controller and view
        mToolbar = findViewById(R.id.tfa_toolbar);
        mViewPager = findViewById(R.id.tfa_viewpager);
        mTabLayout = findViewById(R.id.tfa_tab_layout);

        // configure toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Fragment with Tab");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // map tab and pager
        mSectionsPagerAdapter = new SectionsPagersAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }






    // class to map from tab to fragment
    public class SectionsPagersAdapter extends FragmentPagerAdapter{

        public SectionsPagersAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // when the tap click, it will trigger a number
            // link the position number to the fragment that prefer
            switch (position){
                case 0:
                    return new Tab1Fragment();
                case 1:
                    return new Tap2Fragment();
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            // number of tab implemented
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // set tab title
            switch (position){
                case 0:
                    return "Sample 1";
                case 1:
                    return "Sample 2";
                default:
                    return null;
            }
        }
    }
}
