package com.example.instatry;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.firebase.client.Firebase;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.instatry.HomeActivity.gender;
import static com.example.instatry.HomeActivity.username;

public class ProfileFragment extends Fragment {

    private TextView gender_tv, dob_tv, email_tv, username_tv;
    private Button edit_profile, save_profile, cancel_profile;
    private CircleImageView profile_pic;
    private TextInputEditText usn_edit, gnd_edit;
    private TextInputLayout usn_layout, gnd_layout;

    private static final String TAG = "ProfileFragment";

    private FirebaseAuth mAuth;
    private Firebase mRootRef;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View p_view = inflater.inflate(R.layout.profile_fragment, container, false);

        Firebase.setAndroidContext(getContext());

        mAuth = FirebaseAuth.getInstance();

        gender_tv = (TextView) p_view.findViewById(R.id.gender);
        dob_tv = (TextView) p_view.findViewById(R.id.dob);
        email_tv = (TextView) p_view.findViewById(R.id.email);
        username_tv = (TextView) p_view.findViewById(R.id.username);

        usn_edit = (TextInputEditText) p_view.findViewById(R.id.username_edit_text);
        gnd_edit = (TextInputEditText) p_view.findViewById(R.id.gender_edit_text);
        usn_layout = (TextInputLayout) p_view.findViewById(R.id.username_edit);
        gnd_layout = (TextInputLayout) p_view.findViewById(R.id.gender_edit);

        save_profile = (Button) p_view.findViewById(R.id.save_profile_btn);
        edit_profile = (Button) p_view.findViewById(R.id.edit_profile_btn);
        cancel_profile = (Button) p_view.findViewById(R.id.cancel_profile_btn);
        profile_pic = (CircleImageView) p_view.findViewById(R.id.profile_pic);


        dob_tv.setText(HomeActivity.dob);
        email_tv.setText(HomeActivity.email);
        username_tv.setText(username);
        gender_tv.setText(gender);
        Glide.with(this).load(HomeActivity.photourl).into(profile_pic);

        edit_profile.setOnClickListener(v -> {
            usn_edit.setText(username_tv.getText());
            gnd_edit.setText(gender_tv.getText());

            edit_profile.setVisibility(View.INVISIBLE);
            username_tv.setVisibility(View.INVISIBLE);
            gender_tv.setVisibility(View.INVISIBLE);

            cancel_profile.setVisibility(View.VISIBLE);
            save_profile.setVisibility(View.VISIBLE);
            usn_layout.setVisibility(View.VISIBLE);
            gnd_layout.setVisibility(View.VISIBLE);

        });

        save_profile.setOnClickListener(v -> {

            username = usn_edit.getText().toString();
            gender = gnd_edit.getText().toString();
            String uid = mAuth.getCurrentUser().getUid();

            Log.d(TAG, "onCreateView: " + uid);
            mRootRef = new Firebase("https://instatry-18296.firebaseio.com/users/" + uid + "/");
            int k = 0;
            mRootRef.child("gender").setValue(gender);
            mRootRef.child("username").setValue(username);
            k = 1;
            Log.d(TAG, "onCreateView: " + String.valueOf(k));
            username_tv.setText(username);
            gender_tv.setText(gender);

            Snackbar.make(save_profile, "Changes Saved!", Snackbar.LENGTH_SHORT)
                    .show();

            edit_profile.setVisibility(View.VISIBLE);
            username_tv.setVisibility(View.VISIBLE);
            gender_tv.setVisibility(View.VISIBLE);

            save_profile.setVisibility(View.INVISIBLE);
            usn_layout.setVisibility(View.INVISIBLE);
            gnd_layout.setVisibility(View.INVISIBLE);
            cancel_profile.setVisibility(View.INVISIBLE);

        });

        cancel_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_profile.setVisibility(View.VISIBLE);
                username_tv.setVisibility(View.VISIBLE);
                gender_tv.setVisibility(View.VISIBLE);

                save_profile.setVisibility(View.INVISIBLE);
                usn_layout.setVisibility(View.INVISIBLE);
                gnd_layout.setVisibility(View.INVISIBLE);
                cancel_profile.setVisibility(View.INVISIBLE);
            }
        });

        return p_view;
    }

}