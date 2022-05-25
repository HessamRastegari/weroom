package hessam.rastegari.weroom;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.messaging.FirebaseMessaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import hessam.rastegari.weroom.databinding.ActivityMainFragmentBinding;

public class MainFragmentActivity extends AppCompatActivity {

    private ActivityMainFragmentBinding binding;

    final Fragment mainFragment = new MainActivity();
    final Fragment profileFragment = new ProfileActivity();
    final Fragment mapFragment = new MapsActivity();
    final Fragment searchFragment = new SearchFragment();
    final ChatFragment chatFragment = new ChatFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = mainFragment;

    private static final String TAG = "PushNotification";
    private static final String CHANNEL_ID = "101";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        replaceFragment(new MainActivity());
        fm.beginTransaction().add(R.id.frameLayout, mapFragment, "1").hide(mapFragment).commit();
        fm.beginTransaction().add(R.id.frameLayout, mainFragment, "2").commit();
        fm.beginTransaction().add(R.id.frameLayout, searchFragment, "3").hide(searchFragment).commit();
//        fm.beginTransaction().add(R.id.frameLayout, chatFragment, "3").hide(chatFragment).commit();
        fm.beginTransaction().add(R.id.frameLayout, profileFragment, "4").hide(profileFragment).commit();


        binding.animationMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().hide(active).show(mapFragment).commit();
                active = mapFragment;
                binding.animationMap.playAnimation();
            }
        });

        binding.animationProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().hide(active).show(profileFragment).commit();
                active = profileFragment;
                binding.animationProfile.playAnimation();
            }
        });

        binding.animationSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().hide(active).show(searchFragment).commit();
                active = searchFragment;
                binding.animationSearch.playAnimation();
            }
        });
        binding.animationHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().hide(active).show(mainFragment).commit();
                active = mainFragment;
                binding.animationHome.playAnimation();
            }
        });



        createNotificationChannel();
        getToken();

    }

    private void getToken() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                //If task is failed then
                if (!task.isSuccessful()) {
                    Log.d(TAG, "onComplete: Failed to get the Token");
                }

                //Token
                String token = task.getResult();
                Log.d(TAG, "onComplete: " + token);
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "firebaseNotifChannel";
            String description = "Receve Firebase notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }




}