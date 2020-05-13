package com.example.instatry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.client.Firebase;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.util.StringTokenizer;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    public static String gender;
    public static String dob;
    public static String email;
    public static String photourl;
    public static String username;

    private static final String TAG = "HomeActivity";

    private ExpandableListView expandableListView;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent enterdets = getIntent();

        gender = enterdets.getStringExtra("gender");
        dob = enterdets.getStringExtra("date");
        email = enterdets.getStringExtra("email");
        photourl = enterdets.getStringExtra("photourl");
        username = enterdets.getStringExtra("username");

        if (username == null) {
            username = getUserName(email);
        }
        //Glide.with(HomeActivity.this).load(photourl).into(img);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout_menu);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }

    }//end of Oncreate


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.article_section:
                            selectedFragment = new ArticleFragment();
                            break;
                        case R.id.contact_section:
                            selectedFragment = new ContactFragment();
                            break;
                        case R.id.home_section:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.profile_section:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.menu_section:
                            selectedFragment = new MenuFragment();
                            break;
                    }


                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }

            }; //end of bottomNavigationListener

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent home = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(home);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }

    private String getUserName(String email) {
        StringTokenizer st = new StringTokenizer(email, "@");
        String uname = st.nextToken();
        return uname;
    }

    public void ReportProblem(View view) {
        Intent repo = new Intent(HomeActivity.this, Problem.class);
        startActivity(repo);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

    public void clearcache(View view) {

        new MaterialAlertDialogBuilder(HomeActivity.this)
                .setTitle("Do you want to clear the app cache?")
                .setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteCache(getApplicationContext());
                        Snackbar.make(view.getRootView(), "Cache Cleared!", Snackbar.LENGTH_SHORT)
                                .show();
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //do nothing
                    }
                })
                .show();
    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}
