package com.example.mymaterialdesign;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.widget.NestedScrollView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class WidgetSrollView extends Fragment implements View.OnClickListener {
    private FloatingActionButton fab_plus, fab_email, fab_phone;
    private Animation FabOpen, FabClose, FabRotateClockwise, FabRotateConterClockwise;
    private Snackbar snackbar;
    boolean fabIsOpen = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View nestedScrollView = (View) inflater.inflate(R.layout.nested_scroll_widget, container, false);

        //Floating action button
        fab_plus = (FloatingActionButton) nestedScrollView.findViewById(R.id.fab_plus);
        fab_email = (FloatingActionButton) nestedScrollView.findViewById(R.id.fab_email);
        fab_phone = (FloatingActionButton) nestedScrollView.findViewById(R.id.fab_phone);

        fab_plus.setOnClickListener(this);
        fab_email.setOnClickListener(this);
        fab_phone.setOnClickListener(this);

        FabOpen = AnimationUtils.loadAnimation(this.getContext(), R.anim.floating_button_open);
        FabClose = AnimationUtils.loadAnimation(this.getContext(), R.anim.floating_button_close);
        FabRotateClockwise = AnimationUtils.loadAnimation(this.getContext(), R.anim.rotate_clockwise);
        FabRotateConterClockwise = AnimationUtils.loadAnimation(this.getContext(), R.anim.rotate_counter_clockwise);

//        //get snackbar view
//        View snackbarView = snackbar.getView();
//        //change text color
//        int snackbarTextId = android.support.design.R.id.snackbar_text;
//        TextView textView = (TextView)snackbarView.findViewById(snackbarTextId);
//        textView.setTextColor(getResources().getColor(R.color.colorAccent));

        return nestedScrollView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.fab_plus:
                setFabIsOpen();
               Snackbar.make(view, "", Snackbar.LENGTH_SHORT).dismiss();
               break;
           case R.id.fab_email:
                setFabIsOpen();
               //Snackbar
               Snackbar snack = Snackbar.make(view, "Send email", Snackbar.LENGTH_SHORT).setAction("UNDO", new View.OnClickListener(){

                   @Override
                   public void onClick(View v) {
                       Snackbar.make(v, "", Snackbar.LENGTH_SHORT).dismiss();
                   }
               });
               View snackView = snack.getView();
               TextView tv1 = (TextView) snackView.findViewById(android.support.design.R.id.snackbar_text);
               tv1.setTextColor(Color.WHITE);
               snack.show();
               break;
           case R.id.fab_phone:
               setFabIsOpen();
               break;
           default:
               break;
       }

    }

    private void setFabIsOpen() {
        if (fabIsOpen) {
                   fab_email.startAnimation(FabClose);
                   fab_phone.startAnimation(FabClose);
                   fab_plus.startAnimation(FabRotateConterClockwise);
                   fab_email.setClickable(false);
                   fab_phone.setClickable(false);
                   fabIsOpen = false;
               } else {
                   fab_email.startAnimation(FabOpen);
                   fab_phone.startAnimation(FabOpen);
                   fab_plus.startAnimation(FabRotateClockwise);
                   fab_email.setClickable(true);
                   fab_phone.setClickable(true);
                   fabIsOpen = true;
               }
    }

}
