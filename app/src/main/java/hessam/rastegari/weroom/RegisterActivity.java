package hessam.rastegari.weroom;

import androidx.appcompat.app.AppCompatActivity;
import hessam.rastegari.weroom.connections.RetrofirServices;
import hessam.rastegari.weroom.data.RegisterClass;
import hessam.rastegari.weroom.data.ResponseClass;
import hessam.rastegari.weroom.databinding.ActivityMainFragmentBinding;
import hessam.rastegari.weroom.databinding.ActivityRegisterBinding;
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
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private RetrofirServices retrofirServices;
    private ActivityRegisterBinding activityRegisterBinding;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);



        activityRegisterBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(activityRegisterBinding.getRoot());
//        activityRegisterBinding.signinAnimationView.setSpeed(0.5f);

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
                //createPost();



                // create an instance of the snackbar
                final Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE);

                // inflate the custom_snackbar_view created previously
                View customSnackView = getLayoutInflater().inflate(R.layout.custom_snackbar_layout, null);
//                customSnackView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));

                // set the background of the default snackbar as transparent
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);

                // now change the layout of the snackbar
                Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();

                // set padding of the all corners as 0
                snackbarLayout.setPadding(0, 0, 0, 0);
//                snackbarLayout.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;

                // register the button from the custom_snackbar_view layout file
                Button bGotoWebsite = customSnackView.findViewById(R.id.gotoWebsiteButton);

                // now handle the same button with onClickListener
                bGotoWebsite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Redirecting to Website", Toast.LENGTH_SHORT).show();
                        snackbar.dismiss();
                    }
                });

                // add the custom snack bar layout to snackbar layout
                snackbarLayout.addView(customSnackView, 0);

                snackbar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
                snackbar.show();


                //createPostFeild();
            }
        });
    }


//    private void createPost() {
//
//        RegisterClass registerClass = new RegisterClass(activityRegisterBinding.itfirstname.getText().toString(),
//                activityRegisterBinding.itsurename.getText().toString(),
//                activityRegisterBinding.itUsername.getText().toString(),
//                activityRegisterBinding.itpassword.getText().toString(),
//                "_NONE",
//                "_NONE",
//                "_NONE",
//                1);
//
//        Call<ResponseClass> call = retrofirServices.createPost(registerClass);
//
//        call.enqueue(new Callback<ResponseClass>() {
//            @Override
//            public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {
//
//                if (!response.isSuccessful()) {
//                    activityRegisterBinding.textViewResult.setText("Code: " + response.code());
//                    return;
//                }else{
//                    Toast.makeText(RegisterActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
//                }
//
////                RegisterClass postResponse = response.body();
//
////                String content = "";
////                content += "Code: " + response.code() + "\n";
////                content += "ID: " + postResponse.getId() + "\n";
////                content += "User ID: " + postResponse.getUserId() + "\n";
////                content += "Title: " + postResponse.getTitle() + "\n";
////                content += "Text: " + postResponse.getText() + "\n\n";
//
//                try {
//
//                    String responseRecieved = response.body().toString();
//                    // Add Your Logic
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//                activityRegisterBinding.textViewResult.setText(response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<ResponseClass> call, Throwable t) {
//                activityRegisterBinding.textViewResult.setText(t.getMessage());
//            }
//        });
//    }
    private void createPostFeild() {

        RegisterClass registerClass = new RegisterClass(activityRegisterBinding.itfirstname.getText().toString(),
                activityRegisterBinding.itsurename.getText().toString(),
                activityRegisterBinding.itUsername.getText().toString(),
                activityRegisterBinding.itpassword.getText().toString(),
                "_NONE",
                "_NONE",
                "_NONE",
                1);

        Call<ResponseClass> call = retrofirServices.createPostField(activityRegisterBinding.itfirstname.getText().toString(),
                activityRegisterBinding.itsurename.getText().toString(),
                activityRegisterBinding.itUsername.getText().toString(),
                activityRegisterBinding.itpassword.getText().toString(),
                "_NONE",
                "_NONE",
                "_NONE",
                1);

        call.enqueue(new Callback<ResponseClass>() {
            @Override
            public void onResponse(Call<ResponseClass> call, Response<ResponseClass> response) {

                if (!response.isSuccessful()) {
                    activityRegisterBinding.textViewResult.setText("Code: " + response.code());
                    return;
                }else{
                    Toast.makeText(RegisterActivity.this, response.body().getSuccess(), Toast.LENGTH_SHORT).show();
                }


                activityRegisterBinding.textViewResult.setText(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ResponseClass> call, Throwable t) {
                activityRegisterBinding.textViewResult.setText(t.getMessage());
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
            Intent intent = new Intent(RegisterActivity.this, MainFragmentActivity.class);
            startActivity(intent);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("GoogleSignIn", "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(this, "we are sorry, there is a problem with your sign in", Toast.LENGTH_SHORT).show();
            //updateUI(null);
        }
    }
}