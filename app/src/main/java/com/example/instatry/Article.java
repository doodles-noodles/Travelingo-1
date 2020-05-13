package com.example.instatry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Article extends AppCompatActivity {

    public String articlepicture;
    public String description;
    public String shortdesc;
    public String title;

    private static final String TAG = "Article";
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private TextView title_tv;
    private TextView subtitle_tv;
    private TextView title_info_tv;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Intent enter = getIntent();

        articlepicture = enter.getStringExtra("articlepicture");
        description = enter.getStringExtra("description");
        shortdesc = enter.getStringExtra("shortdesc");
        title = enter.getStringExtra("title");

        title_tv = (TextView) findViewById(R.id.art_title);
        subtitle_tv = (TextView) findViewById(R.id.art_sub_title);
        title_info_tv = (TextView) findViewById(R.id.art_info);
        image = (ImageView) findViewById(R.id.backdrop);

        title_tv.setText(title);
        subtitle_tv.setText(shortdesc);
        title_info_tv.setText(Html.fromHtml(description));

        Glide.with(Article.this)
                .asBitmap()
                .load(articlepicture)
                .into(image);
    }

    public void SendMessage(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, articlepicture + "\n" + title);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
