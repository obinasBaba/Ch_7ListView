package com.hfad.ch_7listview;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    private TabLayout tabs;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


           Toolbar tb = findViewById ( R.id.toolbar );
           setSupportActionBar( tb );
//
//
        vp = findViewById( R.id.viewPager_ID );
           vp.setAdapter( new customPagerAdapter( getSupportFragmentManager() ) );

           tabs = findViewById( R.id.tabs );
           tabs.setupWithViewPager(vp);
    }

    void setUp()
    {

    }

    private class customPagerAdapter extends FragmentStatePagerAdapter
    {
        customPagerAdapter( FragmentManager fm ){
            super( fm );
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return drinkFragment.getInstance(position);
                case 1:
                    return new FoodsFragment();
                case 2:
                    return new StoreFragment();
            }
            return null;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString( R.string.home_tab );
                case 1:
                    return getResources().getString( R.string.pizza_tab );
                case 2:
                    return getResources().getString( R.string.pasta_tab );
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
