package hessam.rastegari.weroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;
import hessam.rastegari.weroom.connections.RetrofirServices;
import hessam.rastegari.weroom.data.CategoryData;
import hessam.rastegari.weroom.data.RegisterClass;
import hessam.rastegari.weroom.data.ResponseClass;
import hessam.rastegari.weroom.databinding.ActivityMainFragmentBinding;
import hessam.rastegari.weroom.databinding.ActivityRegisterBinding;
import hessam.rastegari.weroom.loading.LoadingDialog;
import hessam.rastegari.weroom.loading.LoadingSnackbar;
import hessam.rastegari.weroom.viewmodel.RegisterActivityViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AndroidEntryPoint
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private RetrofirServices retrofirServices;
    private ActivityRegisterBinding activityRegisterBinding;
    GoogleSignInClient mGoogleSignInClient;
    LoadingDialog loadingDialog;
    LoadingSnackbar loadingSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);



        activityRegisterBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(activityRegisterBinding.getRoot());
        activityRegisterBinding.signinAnimationView.setSpeed(0.2f);

        loadingDialog = new LoadingDialog(this);
        loadingSnackbar = new LoadingSnackbar(this);

//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.5:8888/weroom_api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofirServices = retrofit.create(RetrofirServices.class);


        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        activityRegisterBinding.signInButton.setOnClickListener(this);




        activityRegisterBinding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createPostFeild(activityRegisterBinding.edFirstname.getText().toString(),
                        activityRegisterBinding.edSurename.getText().toString(),
                        activityRegisterBinding.edUsername.getText().toString(),
                        activityRegisterBinding.edPassword.getText().toString(),
                        "_NONE",
                        "_NONE",
                        "_NONE",
                        0);

                loadingDialog.showLoading();
                loadingSnackbar.ShowSnackBar(view);
            }
        });
    }

    private void createPostFeild(String Firstname, String Surename, String Username, String Password, String Email, String Token, String Avatar, Integer Mood) {


        loadingDialog.showLoading();
        Call<ResponseClass> call = retrofirServices.createPostField(Firstname,Surename, Username, Password, Email, Token, Avatar, Mood);

        call.enqueue(new Callback<ResponseClass>() {
            @Override
            public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {

                if (!response.isSuccessful()) {
                    //activityRegisterBinding.textViewResult.setText("Code: " + response.code());
                    Toast.makeText(RegisterActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    loadingDialog.dismissDialog();
                    return;
                }else{
                    Toast.makeText(RegisterActivity.this, response.body().getSuccess(), Toast.LENGTH_SHORT).show();
                    loadingDialog.dismissDialog();
                    Intent intent = new Intent(RegisterActivity.this, MainFragmentActivity.class);
                    startActivity(intent);
                }


                //activityRegisterBinding.textViewResult.setText(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ResponseClass> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                loadingDialog.dismissDialog();
            }
        });
    }


    @Override
    protected void onStart() {

//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        if (account !=null) {
//            Toast.makeText(this, "Name: "+account.getGivenName()+" \n Family Name: "+account.getFamilyName()+"\n Email: "+account.getEmail()+ "given name: "+ account.getGivenName()+"\n DisplayName: "+account.getDisplayName() , Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(RegisterActivity.this, MainFragmentActivity.class);
//            startActivity(intent);
//        }
        super.onStart();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_button:
                GoogleSignIn();

                break;
        }
    }
    private void GoogleSignIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 122);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 122) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            //updateUI(account);

            Toast.makeText(this, "Name: "+account.getGivenName()+"Family Name: "+account.getFamilyName()+" Email: "+account.getEmail(), Toast.LENGTH_SHORT).show();
            String[] separated = account.getEmail().split("@");

            //createPostFeild(account.getGivenName(),account.getFamilyName(),separated[0],"Google",account.getEmail(),"_NONE",account.getPhotoUrl().toString(),0);
            RegisterClass registerClass = new RegisterClass(account.getGivenName(),account.getFamilyName(),separated[0],"Google",account.getEmail(),"_NONE",account.getPhotoUrl().toString(),0);
            initViewModel(registerClass);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("GoogleSignIn", "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(this, "we are sorry, there is a problem with your sign in", Toast.LENGTH_SHORT).show();
            //updateUI(null);
        }
    }


    private void initViewModel(RegisterClass registerClass){

        RegisterActivityViewModel registerActivityViewModel = new ViewModelProvider(this).get(RegisterActivityViewModel.class);

        registerActivityViewModel.setInputs(registerClass);

        registerActivityViewModel.getMutableLiveDataCategroryData().observe(this, new Observer<List<CategoryData>>() {
            @Override
            public void onChanged(List<CategoryData> categoryData) {
                if (categoryData != null){
                    Intent intent = new Intent(RegisterActivity.this, MainFragmentActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(RegisterActivity.this, "Error in getting data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerActivityViewModel.makeApiCall();
    }
}