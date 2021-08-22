package com.example.grofer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grofer.model.FruitsModel;
import com.example.grofer.ViewHolder.FruitsViewHolder;
import com.example.grofer.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsViewHolder> {
    private final List<FruitsModel> fruitsModelList;

    public FruitsAdapter(List<FruitsModel> fruitsModelList) {
        this.fruitsModelList = fruitsModelList;
    }

    @NotNull
    @Override
    public FruitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lowestpricestore_itemlayout, parent, false);
        return new FruitsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  FruitsViewHolder holder, int position) {
        FruitsModel fruitsModel = fruitsModelList.get(position);
        holder.setData(fruitsModel);
    }

    @Override
    public int getItemCount() {
        return fruitsModelList.size();
    }
}
