package com.example.mymaterialdesign;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment implements View.OnClickListener {
    private boolean isCard2FavoriteClicked, isCard2BookmarkClicked,isCard3FavoriteClicked, isCard3BookmarkClicked;
    private Button card_1_button_1,card_1_button_2, card_2_favorite_button,card_2_bookmark_button, card_3_favorite_button,card_3_bookmark_button;
    private AlphaAnimation alphaAnimation, alphaAnimationShowIcon;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View  cardView = inflater.inflate(R.layout.fragment_card, container, false);

        //Button
        card_1_button_1 = (Button) cardView.findViewById(R.id.card_button_1);
        card_1_button_2 = (Button) cardView.findViewById(R.id.card_button_2);
        card_2_favorite_button = (Button) cardView.findViewById(R.id.card_2_favorite_button);
        card_2_bookmark_button = (Button) cardView.findViewById(R.id.card_2_bookmark_button);
        card_3_favorite_button = (Button) cardView.findViewById(R.id.card_3_favorite_button);
        card_3_bookmark_button = (Button) cardView.findViewById(R.id.card_3_bookmark_button);

//        card_2_favorite_button.setOnClickListener((View.OnClickListener) this);
//        card_2_bookmark_button.setOnClickListener((View.OnClickListener) this);
        // Inflate the layout for this fragment
        return cardView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Set button listener
        card_1_button_1.setOnClickListener(this);
        card_1_button_2.setOnClickListener(this);
        card_2_favorite_button.setOnClickListener(this);
        card_2_bookmark_button.setOnClickListener(this);
        card_3_favorite_button.setOnClickListener(this);
        card_3_bookmark_button.setOnClickListener(this);
        //Set alpha animation

        alphaAnimationShowIcon = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimationShowIcon.setDuration(500);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_button_1:
                Toast.makeText(getActivity(), "You click button 1", Toast.LENGTH_SHORT).show();
                break;
             case R.id.card_button_2:
                Toast.makeText(getActivity(), "You click button 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_2_favorite_button:
                if (!isCard2FavoriteClicked){
                    card_2_favorite_button.setBackgroundResource(R.drawable.ic_favorite);
                    card_2_favorite_button.startAnimation(alphaAnimationShowIcon);
                    isCard2FavoriteClicked = true;
                } else {
                     card_2_favorite_button.setBackgroundResource(R.drawable.ic_favorite_border);
                    card_2_favorite_button.startAnimation(alphaAnimationShowIcon);
                    isCard2FavoriteClicked = false;
                }
                break;
            case R.id.card_2_bookmark_button:
                 if (!isCard2BookmarkClicked){
                    card_2_bookmark_button.setBackgroundResource(R.drawable.ic_bookmark);
                    card_2_bookmark_button.startAnimation(alphaAnimationShowIcon);
                    isCard2BookmarkClicked = true;
                } else {
                     card_2_bookmark_button.setBackgroundResource(R.drawable.ic_bookmark_border);
                    card_2_bookmark_button.startAnimation(alphaAnimationShowIcon);
                    isCard2BookmarkClicked = false;
                }
                break;
            case R.id.card_3_favorite_button:
                if (!isCard3FavoriteClicked){
                    card_3_favorite_button.setBackgroundResource(R.drawable.ic_favorite);
                    card_3_favorite_button.startAnimation(alphaAnimationShowIcon);
                    isCard3FavoriteClicked = true;
                } else {
                     card_3_favorite_button.setBackgroundResource(R.drawable.ic_favorite_border);
                    card_3_favorite_button.startAnimation(alphaAnimationShowIcon);
                    isCard3FavoriteClicked = false;
                }
                break;
            case R.id.card_3_bookmark_button:
                 if (!isCard3BookmarkClicked){
                    card_3_bookmark_button.setBackgroundResource(R.drawable.ic_bookmark);
                    card_3_bookmark_button.startAnimation(alphaAnimationShowIcon);
                    isCard3BookmarkClicked = true;
                } else {
                     card_3_bookmark_button.setBackgroundResource(R.drawable.ic_bookmark_border);
                    card_3_bookmark_button.startAnimation(alphaAnimationShowIcon);
                    isCard3BookmarkClicked = false;
                }
                break;

            default:
                break;
        }

    }

}
