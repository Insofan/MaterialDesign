package com.example.mymaterialdesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Haixiao on 2017/10/14.
 * Email:insofan3156@gmail.com
 * https://github.com/Insofan
 */

public class BottomNavActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_tab_activity);

        textView = (TextView) findViewById(R.id.bottom_text_view);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_item_home:
                    textView.setText(R.string.bottom_home);
                    return true;
                case R.id.bottom_item_camera:
                    textView.setText(R.string.bottom_camera);
                    return true;
                case R.id.bottom_item_music:
                    textView.setText(R.string.bottom_music);
                    return true;
                case R.id.bottom_item_cloud:
                    textView.setText(R.string.bottom_cloud);
                    return true;
            }
            return false;
        }
    };
}
