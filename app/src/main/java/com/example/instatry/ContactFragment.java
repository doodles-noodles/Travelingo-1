package com.example.instatry;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ContactFragment extends Fragment {
    private DatabaseReference rootRef, childRef;
    private FirebaseDatabase firebaseDatabase;
    private ImageView mExpandArrow;
    private int rotationAngle[];
    HashMap<String, List<String>> expandableListDetail;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contact_frag = inflater.inflate(R.layout.contact_fragment, container, false);
        ExpandableListView expandableListView = contact_frag.findViewById(R.id.expandable_view_contacts);

        expandableListView.setGroupIndicator(null);
        expandableListView.setChildIndicator(null);
        expandableListView.setChildDivider(getResources().getDrawable(R.color.white));
        expandableListView.setDivider(getResources().getDrawable(R.color.white));
        expandableListView.setDividerHeight(2);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                mExpandArrow = (ImageView) expandableListView.getChildAt(groupPosition).findViewById(R.id.expandArrow);
                ObjectAnimator anim = ObjectAnimator.ofFloat(mExpandArrow, "rotation", rotationAngle[groupPosition], rotationAngle[groupPosition] + 180);
                anim.setDuration(200);
                anim.start();
                rotationAngle[groupPosition] += 180;
                rotationAngle[groupPosition] = rotationAngle[groupPosition] % 360;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                mExpandArrow = (ImageView) expandableListView.getChildAt(groupPosition).findViewById(R.id.expandArrow);
                ObjectAnimator anim = ObjectAnimator.ofFloat(mExpandArrow, "rotation", rotationAngle[groupPosition], rotationAngle[groupPosition] - 180);
                anim.setDuration(200);
                anim.start();
                rotationAngle[groupPosition] += 180;
                rotationAngle[groupPosition] = rotationAngle[groupPosition] % 360;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                TextView tv = (TextView) parent.getChildAt(childPosition).findViewById(R.id.listviewitemtv);
                String number = tv.getText().toString();
                Toast.makeText(getContext(), number, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        HashMap<String, List<String>> item = new HashMap<>();
        List<String> imageUrl = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();
        rootRef = firebaseDatabase.getReference();
        childRef = rootRef.child("contactDirectory");

        childRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("amru", dataSnapshot.toString());
                String image = null;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    image = dataSnapshot1.child("Image").getValue().toString();
                    imageUrl.add(image);
                    List<String> list = new ArrayList<>();
                    for (DataSnapshot dataSnapshot2 : dataSnapshot1.child("Details").getChildren()) {
                        DirectoryModel directoryModel = dataSnapshot2.getValue(DirectoryModel.class);
                        String temp = "<p><strong>" + directoryModel.getName() + "</strong><br><span style=\"font-size: 5px\">" + directoryModel.getContact() + "</span></p>";
                        list.add(temp);
                        item.put(dataSnapshot1.getKey(), list);
                    }
                }
                ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter(item, imageUrl);
                rotationAngle = new int[expandableListAdapter.getGroupCount()];
                expandableListView.setAdapter(expandableListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return contact_frag;
    }
}
