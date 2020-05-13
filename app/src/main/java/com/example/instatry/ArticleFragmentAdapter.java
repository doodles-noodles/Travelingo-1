package com.example.instatry;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ArticleFragmentAdapter extends FirebaseRecyclerAdapter<ArticleModel, ArticleFragmentAdapter.ArticleFragmentHolder> {

    private Context mContext;
    public String articlepicture;
    public String description;
    public String shortdesc;
    public String title;

    private static final String TAG = "ArticleFragmentAdapter";

    public ArticleFragmentAdapter(@NonNull FirebaseRecyclerOptions<ArticleModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ArticleFragmentHolder holder, int position, @NonNull ArticleModel model) {


        holder.title_tv.setText(model.getTitle());
        holder.subtitle.setText(model.getShortdesc());

        holder.viewArticle.setOnClickListener(v -> {
            Log.d(TAG, "onBindViewHolder: " + model.getArticlepicture() + model.getDescription() + model.getShortdesc() + model.getTitle());

            Intent article = new Intent(mContext, Article.class);

            article.putExtra("articlepicture", model.getArticlepicture());
            article.putExtra("description", model.getDescription());
            article.putExtra("shortdesc", model.getShortdesc());
            article.putExtra("title", model.getTitle());

            mContext.startActivity(article);
        });
    }

    @NonNull
    @Override
    public ArticleFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_adapter, parent, false);

        return new ArticleFragmentHolder(view);
    }

    class ArticleFragmentHolder extends RecyclerView.ViewHolder {
        TextView title_tv, subtitle;
        CardView viewArticle;


        public ArticleFragmentHolder(@NonNull View itemView) {
            super(itemView);
            title_tv = itemView.findViewById(R.id.article_title);
            subtitle = itemView.findViewById(R.id.article_sub_title);
            viewArticle = itemView.findViewById(R.id.article_card_view);
        }
    }
}
