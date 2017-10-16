package com.example.mymaterialdesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haixiao on 2017/10/14.
 * Email:insofan3156@gmail.com
 * https://github.com/Insofan
 */

public class BottomNavActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private ViewPager viewPager;
    private List<View> viewList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_tab_activity);

        initView();


    }

    private void initView() {
        //4 item view
        View viewOne = getLayoutInflater().inflate(R.layout.bottom_tab_item_one, null);
        View viewTwo = getLayoutInflater().inflate(R.layout.bottom_tab_item_two, null);
        View viewThree = getLayoutInflater().inflate(R.layout.bottom_tab_item_three, null);
        View viewFour = getLayoutInflater().inflate(R.layout.bottom_tab_item_four, null);

        viewList = new ArrayList<>();
        viewList.add(viewOne);
        viewList.add(viewTwo);
        viewList.add(viewThree);
        viewList.add(viewFour);

        viewPager = (ViewPager) findViewById(R.id.bottom_view_pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(pageChangeListener);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_bar);


        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationItemSelectedListener);
        //disable shift mode
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_item_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.bottom_item_camera:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.bottom_item_music:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.bottom_item_cloud:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    //pager change listener
    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    bottomNavigationView.setSelectedItemId(R.id.bottom_item_home);
                    break;
                case 1:
                    bottomNavigationView.setSelectedItemId(R.id.bottom_item_camera);
                    break;
                case 2:
                    bottomNavigationView.setSelectedItemId(R.id.bottom_item_music);
                    break;
                case 3:
                    bottomNavigationView.setSelectedItemId(R.id.bottom_item_cloud);
                    break;

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }
    };
}
