package com.example.grofer.FruitsAndVegetables;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grofer.FruitsItem;
import com.example.grofer.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FruitsVegetableAdapter extends RecyclerView.Adapter<FruitsVegetableViewHolder> {

    private ArrayList<FruitsModel> fruitsModelList;
    private FruitsItemClickListener fruitsItemClickListener;

    public FruitsVegetableAdapter(ArrayList<FruitsModel> fruitsModelList, FruitsItemClickListener fruitsItemClickListener) {
        this.fruitsModelList = fruitsModelList;
        this.fruitsItemClickListener = fruitsItemClickListener;
    }

    @NonNull
    @Override
    public FruitsVegetableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_categories,parent,false);
        return new FruitsVegetableViewHolder(view,fruitsItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsVegetableViewHolder holder, int position) {
        FruitsModel fruitsModel = fruitsModelList.get(position);
        holder.setData(fruitsModel);
    }

    @Override
    public int getItemCount() {
        return fruitsModelList.size();
    }
}