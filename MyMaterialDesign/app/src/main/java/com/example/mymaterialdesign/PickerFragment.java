package com.example.mymaterialdesign;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.DatePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class PickerFragment extends Fragment implements View.OnClickListener {
    FloatingActionButton fab;
    DatePicker datePicker;

    boolean isFabClicked = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picker, container, false);
        view.setBackgroundColor(Color.WHITE);

        datePicker = (DatePicker) view.findViewById(R.id.date_picker);
        fab = (FloatingActionButton) view.findViewById(R.id.reveal_button);

        fab.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reveal_button:
//                //https://developer.android.com/training/material/animations.html?hl=zh-tw

                wheatherFabClicked();

                break;
        }
    }

    public void wheatherFabClicked() {
        // get the final radius for the clipping circle
        double screenWidth = getView().getWidth();
        double screenHeight = getView().getHeight();
        double x = Math.pow(screenWidth, 2);
        double y = Math.pow(screenHeight, 2);
        float diagonal = (float) Math.sqrt(x + y);

        if (isFabClicked) {
            // get the center for the clipping circle
            int cx = (fab.getLeft() + fab.getRight()) / 2;
            int cy = (fab.getTop() + fab.getBottom()) / 2;
            // create the animator for this view (the start radius is zero)
            // create the animation (the final radius is zero)
            android.animation.Animator anim =
                    ViewAnimationUtils.createCircularReveal(datePicker, cx, cy, diagonal, 0);
            // make the view invisible when the animation is done

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(android.animation.Animator animation) {
                    super.onAnimationStart(animation);

                }


                @Override
                public void onAnimationEnd(android.animation.Animator animation) {
                    super.onAnimationEnd(animation);
                    getView().setBackgroundColor(Color.rgb(0, 187, 211));
                    datePicker.setVisibility(View.INVISIBLE);
                }
            });

            fab.setImageResource(R.drawable.ic_date_picker);
            // start the animation
            anim.setDuration(500);
            anim.start();

            isFabClicked = false;
        } else {
            //https://developer.android.com/training/material/animations.html?hl=zh-tw
            // get the center for the clipping circle
            int cx = (fab.getLeft() + fab.getRight()) / 2;
            int cy = (fab.getTop() + fab.getBottom()) / 2;

            // create the animator for this view (the start radius is zero)
            android.animation.Animator anim =
                    ViewAnimationUtils.createCircularReveal(datePicker, cx, cy, 0, diagonal);

            // make the view visible and start the animation
            getView().setBackgroundColor(Color.WHITE);
            datePicker.setVisibility(View.VISIBLE);
            fab.setImageResource(R.drawable.ic_date_picker_close);

            anim.setDuration(500);
            anim.start();
            isFabClicked = true;
        }
    }
}
