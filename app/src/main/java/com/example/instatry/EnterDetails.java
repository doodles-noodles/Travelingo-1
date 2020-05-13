package com.example.instatry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;
import java.util.StringTokenizer;

public class EnterDetails extends AppCompatActivity {
    private static final String TAG = "EnterDetails";
    private FirebaseAuth mAuth;
    private Firebase mRootRef;

    private RadioButton rb;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private TextView mDisplayDate;

    public String gender;
    public String date;
    public String email;
    public String photourl;
    public String username;
    public String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);
        getIntent();

        mAuth = FirebaseAuth.getInstance();
        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://instatry-18296.firebaseio.com/users/");

        mDisplayDate = (TextView) findViewById(R.id.calender);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EnterDetails.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mOnDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(date);
                Toast.makeText(EnterDetails.this, date, Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void getGender(View view) {
        rb = (RadioButton) view;
        gender = rb.getText().toString();
        Toast.makeText(this, gender, Toast.LENGTH_SHORT).show();
    }

    public void enterDetails(View view) {

        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

        FirebaseUser user = mAuth.getCurrentUser();
        //put user details into database before going to home activity
        email = user.getEmail();
        photourl = user.getPhotoUrl().toString();
        username = user.getDisplayName();
        uid = user.getUid();
        if (username == null) {
            username = getUserName(email);
        }
        boolean z = addNewUser();
        Log.d(TAG, "enterDetails: z=" + z);
        Intent home = new Intent(EnterDetails.this, HomeActivity.class);

        home.putExtra("gender", gender);
        home.putExtra("date", date);
        home.putExtra("email", email);
        home.putExtra("photourl", photourl);
        home.putExtra("username", username);

        startActivity(home);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }

    private String getUserName(String email) {
        StringTokenizer st = new StringTokenizer(email, "@");
        String uname = st.nextToken();
        Toast.makeText(this, uname, Toast.LENGTH_SHORT).show();
        return uname;
    }

    public boolean addNewUser() {
        int k = 0;
        Firebase useridtitle = mRootRef.child(uid);

        useridtitle.child("dob").setValue(date);
        useridtitle.child("email").setValue(email);
        useridtitle.child("gender").setValue(gender);
        useridtitle.child("picture").setValue(photourl);
        useridtitle.child("uid").setValue(uid);
        useridtitle.child("username").setValue(username);
        k = 1;
        if (k == 1)
            return true;
        else
            return false;

    }
}
