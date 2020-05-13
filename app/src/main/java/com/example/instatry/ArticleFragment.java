package com.example.instatry;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ArticleFragment extends Fragment {

    private ArticleFragmentAdapter adapter1;
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View article_frag = inflater.inflate(R.layout.article_fragment, container, false);

        rv = article_frag.findViewById(R.id.articleRV);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<ArticleModel> options = new FirebaseRecyclerOptions.Builder<ArticleModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("articles"), ArticleModel.class)
                .build();

        adapter1 = new ArticleFragmentAdapter(options);
        rv.setAdapter(adapter1);

        return article_frag;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter1.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter1.stopListening();
    }
}