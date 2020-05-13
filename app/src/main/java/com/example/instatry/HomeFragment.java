package com.example.instatry;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {

    private HomeFragmentAdapter adapter1, adapter2, adapter3, adapter4, adapter5, adapter6, adapter7;
    private static final String TAG = "HomeFragment";
    private TextView name_tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View home_view = inflater.inflate(R.layout.home_fragment, container, false);
        name_tv = home_view.findViewById(R.id.welcome_name);
        name_tv.setText(HomeActivity.username);

        //  beaches
        RecyclerView recyclerView = home_view.findViewById(R.id.beachesRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        FirebaseRecyclerOptions<HomeModel> options = new FirebaseRecyclerOptions.Builder<HomeModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("places").child("Beaches"), HomeModel.class)
                .build();

        adapter1 = new HomeFragmentAdapter(options);
        recyclerView.setAdapter(adapter1);

        //   restaurants

        RecyclerView restruants = home_view.findViewById(R.id.restrauntsRV);
        restruants.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        FirebaseRecyclerOptions<HomeModel> options2 = new FirebaseRecyclerOptions.Builder<HomeModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("places").child("Restruants"), HomeModel.class)
                .build();

        adapter2 = new HomeFragmentAdapter(options2);
        restruants.setAdapter(adapter2);

        // nightlife  (change child)

        RecyclerView nightLife = home_view.findViewById(R.id.nightlifeRV);
        nightLife.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        FirebaseRecyclerOptions<HomeModel> options3 = new FirebaseRecyclerOptions.Builder<HomeModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("places").child("Beaches"), HomeModel.class)
                .build();

        adapter3 = new HomeFragmentAdapter(options3);
        nightLife.setAdapter(adapter3);


        // religious  (change child)

        RecyclerView religious = home_view.findViewById(R.id.religiousRV);
        religious.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        FirebaseRecyclerOptions<HomeModel> options4 = new FirebaseRecyclerOptions.Builder<HomeModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("places").child("Restruants"), HomeModel.class)
                .build();

        adapter4 = new HomeFragmentAdapter(options4);
        religious.setAdapter(adapter4);

        // hillstations  (change child)

        RecyclerView hillstation = home_view.findViewById(R.id.hillsationRV);
        hillstation.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        FirebaseRecyclerOptions<HomeModel> options5 = new FirebaseRecyclerOptions.Builder<HomeModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("places").child("Beaches"), HomeModel.class)
                .build();

        adapter5 = new HomeFragmentAdapter(options5);
        hillstation.setAdapter(adapter5);


        return home_view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter1.startListening();
        adapter2.startListening();
        adapter3.startListening();
        adapter4.startListening();
        adapter5.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        adapter1.stopListening();
        adapter2.stopListening();
        adapter3.stopListening();
        adapter4.stopListening();
        adapter5.stopListening();
    }
}




