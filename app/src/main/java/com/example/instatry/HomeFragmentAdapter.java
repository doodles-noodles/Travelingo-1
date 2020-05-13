package com.example.instatry;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class HomeFragmentAdapter extends FirebaseRecyclerAdapter<HomeModel, HomeFragmentAdapter.HomeViewHolder> {

    private Context mContext;
    public String description, placepicture, title, latitude, longitude;


    private static final String TAG = "HomeFragmentAdapter";

    public HomeFragmentAdapter(@NonNull FirebaseRecyclerOptions<HomeModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull HomeViewHolder holder, int position, @NonNull HomeModel model) {
        holder.title.setText(model.getTitle());
        Glide.with(mContext)
                .asBitmap()
                .load(model.placepicture)
                .into(holder.image);

        holder.image.setOnClickListener(v -> {

            Log.d(TAG, "onClick: " + model.toString());
            Intent home = new Intent(mContext, Place.class);

            home.putExtra("description", model.getDescription());
            home.putExtra("latitude", model.getLatitude());
            home.putExtra("longitude", model.getLongitude());
            home.putExtra("placepicture", model.getPlacepicture());
            home.putExtra("title", model.getTitle());

            mContext.startActivity(home);

        });
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_items, parent, false);

        return new HomeViewHolder(view);
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_of_place);
            image = itemView.findViewById(R.id.image_of_place);
        }
    }
}
