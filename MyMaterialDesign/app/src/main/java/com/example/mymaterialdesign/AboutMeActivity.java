package com.example.mymaterialdesign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Haixiao on 2017/10/12.
 * Email:insofan3156@gmail.com
 * https://github.com/Insofan
 */

public class AboutMeActivity extends AppCompatActivity implements View.OnClickListener {
    //private value
    private Button emialButton, githubButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me_activity);


        Toolbar toolbar = (Toolbar) findViewById(R.id.about_me_toolbar);
        setSupportActionBar(toolbar);

        emialButton = (Button) findViewById(R.id.about_me_email_button);
        githubButton = (Button) findViewById(R.id.about_me_github_button);

        emialButton.setOnClickListener(this);
        githubButton.setOnClickListener(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //back top
        Intent backTopIntent = new Intent(this, MainActivity.class);
        backTopIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(backTopIntent);
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.about_me_email_button:
                sendEmail(view.getContext());
                break;

            case R.id.about_me_github_button:
                 Uri uri1 = Uri.parse("https://github.com/Insofan/MaterialDesign");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }

    public static void sendEmail(Context context) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"insofan3156@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Material Design Demo");
        intent.putExtra(Intent.EXTRA_TEXT, "Hi, Insomnia");
        try {
            if (!(context instanceof Activity)) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "Can't find email !", Toast.LENGTH_SHORT).show();
        }
    }
}
