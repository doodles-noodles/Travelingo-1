package com.example.instatry;


import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private HashMap<String, List<String>> stringListHashMap;
    private String[] listHeaderGroup;
    private List<String> imageUrl;


    public ExpandableListAdapter(HashMap<String, List<String>> stringListHashMap, List<String> imageUrl) {
        this.stringListHashMap = stringListHashMap;
        this.imageUrl = imageUrl;
        listHeaderGroup = stringListHashMap.keySet().toArray(new String[0]);
    }


    @Override
    public int getGroupCount() {
        return listHeaderGroup.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return stringListHashMap.get(listHeaderGroup[i]).size();
    }

    @Override
    public Object getGroup(int i) {
        return listHeaderGroup[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return stringListHashMap.get(listHeaderGroup[i]).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i * i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.expandable_list, viewGroup, false);

        TextView textView = view.findViewById(R.id.listviewtv);
        textView.setText(String.valueOf(getGroup(i)));

        ImageView imageView = view.findViewById(R.id.image_icon);
        Glide.with(view).load(imageUrl.get(i)).into(imageView);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.expandable_list_item, viewGroup, false);

        TextView textView = view.findViewById(R.id.listviewitemtv);

        textView.setText(Html.fromHtml(String.valueOf(getChild(i, i1))));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v.findViewById(R.id.listviewitemtv);
                String str = tv.getText().toString().trim();
                String numberOnly = str.replaceAll("[^0-9]", "");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + numberOnly));
                v.getContext().startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

}
