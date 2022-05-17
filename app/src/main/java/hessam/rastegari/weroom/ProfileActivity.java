package hessam.rastegari.weroom;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class ProfileActivity extends Fragment {


    CardView cardViewMood1,cardViewMood2,cardViewMood3,cardViewMood4,cardViewMood5,cardViewMood6,cardViewMood7,cardViewMood8;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_profile, container, false);


        cardViewMood1 = v.findViewById(R.id.cardMood1);
        cardViewMood2 = v.findViewById(R.id.cardMood2);
        cardViewMood3 = v.findViewById(R.id.cardMood3);
        cardViewMood4 = v.findViewById(R.id.cardMood4);
        cardViewMood5 = v.findViewById(R.id.cardMood5);
        cardViewMood6 = v.findViewById(R.id.cardMood6);
        cardViewMood7 = v.findViewById(R.id.cardMood7);
        cardViewMood8 = v.findViewById(R.id.cardMood8);

        cardViewMood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCardsClickLinstener(cardViewMood1);
            }
        });
        cardViewMood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCardsClickLinstener(cardViewMood2);
            }
        });
        cardViewMood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCardsClickLinstener(cardViewMood3);
            }
        });
        cardViewMood4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCardsClickLinstener(cardViewMood4);
            }
        });
        cardViewMood5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCardsClickLinstener(cardViewMood5);
            }
        });
        cardViewMood6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCardsClickLinstener(cardViewMood6);
            }
        });
        cardViewMood7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCardsClickLinstener(cardViewMood7);
            }
        });
        cardViewMood8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCardsClickLinstener(cardViewMood8);
            }
        });

        return v;
    }

    public void OnCardsClickLinstener (CardView cardView){

        cardViewMood1.setElevation(12);
        cardViewMood1.setCardBackgroundColor(getResources().getColor(R.color.white));

        cardViewMood2.setElevation(12);
        cardViewMood2.setCardBackgroundColor(getResources().getColor(R.color.white));

        cardViewMood3.setElevation(12);
        cardViewMood3.setCardBackgroundColor(getResources().getColor(R.color.white));

        cardViewMood4.setElevation(12);
        cardViewMood4.setCardBackgroundColor(getResources().getColor(R.color.white));

        cardViewMood5.setElevation(12);
        cardViewMood5.setCardBackgroundColor(getResources().getColor(R.color.white));

        cardViewMood6.setElevation(12);
        cardViewMood6.setCardBackgroundColor(getResources().getColor(R.color.white));

        cardViewMood7.setElevation(12);
        cardViewMood7.setCardBackgroundColor(getResources().getColor(R.color.white));

        cardViewMood8.setElevation(9);
        cardViewMood8.setCardBackgroundColor(getResources().getColor(R.color.white));



        ObjectAnimator animator = ObjectAnimator.ofFloat(cardView, "cardElevation", 8, 1);
        // if needed set duration, interpolator, or what you want on the animator
        animator.setDuration(500);
        animator.start();

        cardView.setCardBackgroundColor(getResources().getColor(R.color.blue_gradient_2));
    }


}