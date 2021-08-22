package com.example.grofer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grofer.R;
import com.example.grofer.model.VegetableModel;
import com.example.grofer.ViewHolder.VegetablesViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VegetablesAdapter extends RecyclerView.Adapter<VegetablesViewHolder> {
    private List<VegetableModel> vegetableModelList;

    public VegetablesAdapter(List<VegetableModel> vegetableModelList) {
        this.vegetableModelList = vegetableModelList;
    }

    @NotNull
    @Override
    public VegetablesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lowestpricestore_itemlayout, parent, false);
        return new VegetablesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VegetablesViewHolder holder, int position) {
        VegetableModel vegetableModel = vegetableModelList.get(position);
        holder.setData(vegetableModel);
    }

    @Override
    public int getItemCount() {
        return vegetableModelList.size();
    }
    public void updateData(List<VegetableModel> vegetableModelList){
        this.vegetableModelList = vegetableModelList;
        notifyDataSetChanged();
    }
}
