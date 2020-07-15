package com.example.instatry;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Place extends AppCompatActivity {

    public String description, placepicture, title, latitude, longitude;
    private static final String TAG = "Place";
    private TextView title_tv, desc_tv;
    private ImageView bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        Intent enterdets = getIntent();

        description = enterdets.getStringExtra("description");
        latitude = enterdets.getStringExtra("latitude");
        longitude = enterdets.getStringExtra("longitude");
        placepicture = enterdets.getStringExtra("placepicture");
        title = enterdets.getStringExtra("title");

        title_tv = (TextView) findViewById(R.id.place_title_tv);
        desc_tv = (TextView) findViewById(R.id.place_info_tv);
        bg = (ImageView) findViewById(R.id.place_image_bg);

        title_tv.setText(title);
        desc_tv.setText(description);

        Glide.with(Place.this)
                .asBitmap()
                .load(placepicture)
                .into(bg);
    }

    public void gotoMaps(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr="+latitude+","+longitude));
        startActivity(intent);
    }
}
