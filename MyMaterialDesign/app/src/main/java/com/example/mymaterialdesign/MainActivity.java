package com.example.mymaterialdesign;

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
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //init ToolBar
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            default:
                Intent intent = new Intent(this, CollpaseActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()){
            case R.id.navigation_item_bottom_tab:
                Snackbar.make(drawerLayout,"bottom tab", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.navigation_item_collapse_view:
                intent.setClass(MainActivity.this, CollpaseActivity.class);
                startActivity(intent);
                break;
            case R.id.navigation_item_about_me:

                break;
            default:
                break;
        }
        return true;
    }

}
