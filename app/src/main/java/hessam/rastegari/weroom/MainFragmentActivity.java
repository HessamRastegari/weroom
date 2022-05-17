package hessam.rastegari.weroom;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

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
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = mainFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainFragmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        replaceFragment(new MainActivity());
        fm.beginTransaction().add(R.id.frameLayout, mainFragment, "1").commit();
        fm.beginTransaction().add(R.id.frameLayout, profileFragment, "2").hide(profileFragment).commit();
        fm.beginTransaction().add(R.id.frameLayout,mapFragment, "3").hide(mapFragment).commit();



        binding.animationMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().hide(active).show(mapFragment).commit();
                active = mapFragment;
            }
        });

        binding.animationProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().hide(active).show(profileFragment).commit();
                active = profileFragment;
            }
        });

        binding.animationSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().hide(active).show(mainFragment).commit();
                active = mainFragment;
            }
        });
        binding.animationHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().hide(active).show(mainFragment).commit();
                active = mainFragment;
            }
        });

//        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
//
//                    switch (item.getItemId()){
//                        case R.id.home:
//
//                            fm.beginTransaction().hide(active).show(mainFragment).commit();
//                            active = mainFragment;
//                            break;
//                        case R.id.settings:
//                            fm.beginTransaction().hide(active).show(profileFragment).commit();
//                            active = profileFragment;
//                            break;
//                        case R.id.profile:
//                            fm.beginTransaction().hide(active).show(mapFragment).commit();
//                            active = mapFragment;
////                            replaceFragment(new MapsActivity());
//                            break;
//                    }
//
//                    return true;
//                }
//        );

    }

//    private void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frameLayout,fragment);
//        fragmentTransaction.commit();
//    }


}