package com.example.instatry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Problem extends AppCompatActivity {

    private TextInputEditText email_tv, problem_tv;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);
        Firebase.setAndroidContext(this);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("problems");

        email_tv = (TextInputEditText) findViewById(R.id.email_edit_text);
        problem_tv = (TextInputEditText) findViewById(R.id.problem_edit_text);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
    }

    public void ReportProblem(View view) {
        String uid = mAuth.getUid().toString();
        ref.push().setValue(new ProblemModel(uid, email_tv.getText().toString(), problem_tv.getText().toString()));
        Snackbar.make(coordinatorLayout, "Reported!", Snackbar.LENGTH_SHORT)
                .show();
        problem_tv.setText("");
        email_tv.setText("");
    }
}
