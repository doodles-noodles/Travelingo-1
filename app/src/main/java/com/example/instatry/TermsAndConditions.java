package com.example.instatry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TermsAndConditions extends AppCompatActivity {

    private TextView mTerms;
    private final String Description = "<div class>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        getIntent();
        mTerms = findViewById(R.id.terms_text);
        mTerms.setText(Html.fromHtml(Description));

    }
}
