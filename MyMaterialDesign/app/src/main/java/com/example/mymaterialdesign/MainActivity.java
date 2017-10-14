package com.example.mymaterialdesign;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //init ToolBar
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //Intent
        intent = new Intent();

        toolbar = (Toolbar) findViewById(R.id.app_bar_main);
        setSupportActionBar(toolbar);

        //Set tab and viewPager
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        //Set view adapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new CardFragment(), "Card");
        viewPagerAdapter.addFragment(new WidgetFragment(), "Widget");
        viewPagerAdapter.addFragment(new PickerFragment(), "Picker");

        //hiden soft keyboard
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                final InputMethodManager imm = (InputMethodManager)getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(viewPager.getRootView().getWindowToken(), 0);
            }

            @Override
            public void onPageScrolled(int position, float offset, int offsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //Add drawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Add action bar drawer toggle
        ActionBarDrawerToggle actionDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        //Set drawer listener
        drawerLayout.addDrawerListener(actionDrawerToggle);
        actionDrawerToggle.syncState();

        //Set navigationView
        NavigationView view = (NavigationView) findViewById(R.id.navigation_view);
        view.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.main_about_me:
                intent.setClass(this, AboutMeActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_item_bottom_tab:
                intent.setClass(this, BottomNavActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
                break;
            case R.id.navigation_item_collapse_view:
                intent.setClass(this, CollpaseActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
                break;
            case R.id.navigation_item_about_me:
                intent.setClass(MainActivity.this, AboutMeActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
                break;
            default:
                break;
        }
        return true;
    }

}
