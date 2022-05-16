package hessam.rastegari.weroom;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

public class ProfileActivity extends AppCompatActivity {


    CardView cardViewMood1,cardViewMood2,cardViewMood3,cardViewMood4,cardViewMood5,cardViewMood6,cardViewMood7,cardViewMood8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        cardViewMood1 = findViewById(R.id.cardMood1);
        cardViewMood2 = findViewById(R.id.cardMood2);
        cardViewMood3 = findViewById(R.id.cardMood3);
        cardViewMood4 = findViewById(R.id.cardMood4);
        cardViewMood5 = findViewById(R.id.cardMood5);
        cardViewMood6 = findViewById(R.id.cardMood6);
        cardViewMood7 = findViewById(R.id.cardMood7);
        cardViewMood8 = findViewById(R.id.cardMood8);

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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}