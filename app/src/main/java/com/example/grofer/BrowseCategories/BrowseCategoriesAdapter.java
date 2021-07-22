package com.example.grofer.BrowseCategories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grofer.R;


import java.util.ArrayList;

public class BrowseCategoriesAdapter extends RecyclerView.Adapter<BrowseCategoriesViewHolder> {

    private ArrayList<BrowseCategoriesModel> browseCategoriesModels;
    private BrowseItemClickListener browseItemClickListener;

    public BrowseCategoriesAdapter(ArrayList<BrowseCategoriesModel> browseCategoriesModels, BrowseItemClickListener browseItemClickListener) {
        this.browseCategoriesModels = browseCategoriesModels;
        this.browseItemClickListener = browseItemClickListener;
    }

    @NonNull
    @Override
    public BrowseCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_categories,parent,false);
        return new BrowseCategoriesViewHolder(view,browseItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseCategoriesViewHolder holder, int position) {
        BrowseCategoriesModel browseCategoriesModel = browseCategoriesModels.get(position);
        holder.setData(browseCategoriesModel);
    }

    @Override
    public int getItemCount() {
        return browseCategoriesModels.size();
    }
}
