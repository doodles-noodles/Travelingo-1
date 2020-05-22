package com.example.instatry;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    public static int checked = 0;
    static final int GOOGLE_SIGN = 123;
    private FirebaseAuth mAuth;
    private Firebase firebaseRef;

    Button btn_login, btn_fb_login;

    ProgressBar progressBar;
    GoogleSignInClient mGoogleSignInClient;
    String checkParam;

    private static final String TAG = "MainActivity";
    private CallbackManager mCallbackManager;

    public String gender = "Female";
    public String date = "11/11/1999";
    public String email = "something@gmail.com";
    public String photourl = "None";
    public String username = "None";

    FrameLayout progressBarHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getIntent();


        Firebase.setAndroidContext(this);
        btn_login = (Button) findViewById(R.id.login_google_btn);

        btn_fb_login = (Button) findViewById(R.id.login_fb_btn);
        progressBar = findViewById(R.id.progress_circular);


        progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            Snackbar.make(btn_login, "Please wait ...", Snackbar.LENGTH_SHORT)
                    .show();
            btn_login.setEnabled(false);
            btn_fb_login.setEnabled(false);
            gotonextActivity(mAuth.getCurrentUser());
        }

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions
                .Builder()
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        btn_login.setOnClickListener(v -> SignInGoogle());


        //Facebook Login starts
        mCallbackManager = CallbackManager.Factory.create();

        btn_fb_login.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            btn_fb_login.setEnabled(false);
            checkParam = "facebook";
            Log.d(TAG, "onClick: " + checkParam);
            LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, Arrays.asList("email", "public_profile"));
            LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    Log.d(TAG, "facebook:onSuccess:" + loginResult);
                    handleFacebookAccessToken(loginResult.getAccessToken());
                }

                @Override
                public void onCancel() {
                    Log.d(TAG, "facebook:onCancel");
                    // ...
                }

                @Override
                public void onError(FacebookException error) {
                    Log.d(TAG, "facebook:onError", error);
                    // ...
                }
            });
        });

        //Facebook login ends


    }//end of OnCreate


    void SignInGoogle() {
        checkParam = "google";
        btn_login.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
        Intent signIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signIntent, GOOGLE_SIGN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (checkParam.equals("google")) {
            if (requestCode == GOOGLE_SIGN) {
                Task<GoogleSignInAccount> task = GoogleSignIn
                        .getSignedInAccountFromIntent(data);
                try {
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                    if (account != null) {
                        firebaseAuthWithGoogle(account);
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }

            }
        } else if (checkParam.equals("facebook")) {
            Log.d(TAG, "onActivityResult: yes pliss");
            mCallbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Log.d(TAG, "firebaseAuthWithGoogle: " + account.getId());

        AuthCredential credential = GoogleAuthProvider
                .getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Log.d(TAG, "firebaseAuthWithGoogle: Sign In Successfull");

                        FirebaseUser user = mAuth.getCurrentUser();

                        Log.d(TAG, "firebaseAuthWithGoogle: provider data");
                        //updateUI(user);
                        gotonextActivity(user);
                    } else {
                        progressBar.setVisibility(View.INVISIBLE);

                        Log.w(TAG, "firebaseAuthWithGoogle: Sigin failure", task.getException());

                        Toast.makeText(this, "SignIn Failed", Toast.LENGTH_SHORT).show();

                    }
                });

    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "Sign In Successfull", Toast.LENGTH_SHORT).show();
                            //updateUI(user);
                            gotonextActivity(user);
                            //btn_fb_login.setEnabled(true);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();


                        }


                    }
                });
    }


    private void gotonextActivity(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {

            String uid = firebaseUser.getUid();

            firebaseRef = new Firebase("https://instatry-18296.firebaseio.com/users/");
            firebaseRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (checkIfUidExists(uid, dataSnapshot)) {
                        //gotoHomeActivity

                        Intent home = new Intent(MainActivity.this, HomeActivity.class);
                        home.putExtra("gender", gender);
                        home.putExtra("date", date);
                        home.putExtra("email", email);
                        home.putExtra("photourl", photourl);
                        home.putExtra("username", username);

                        startActivity(home);
                        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                        finish();
                    } else {
                        //gotoEnterDetailsActivity

                        Intent enterdets = new Intent(MainActivity.this, EnterDetails.class);
                        startActivity(enterdets);
                        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                        finish();
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });


        }

    }

    public boolean checkIfUidExists(String uid, DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Log.d(TAG, "checkIfUidExists: " + ds);
            if (ds.getKey().equals(uid)) {
                Map<String, String> map = ds.getValue(Map.class);
                gender = map.get("gender");
                date = map.get("dob");
                email = map.get("email");
                photourl = map.get("picture");
                username = map.get("username");
                return true;
            }

        }
        return false;
    }

}






