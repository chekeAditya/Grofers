package com.example.grofer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OilAdapter extends RecyclerView.Adapter<OilViewHolder> {
    private List<OilModel> oilModelList;

    public OilAdapter(List<OilModel> oilModelList) {
        this.oilModelList = oilModelList;
    }

    @NotNull
    @Override
    public OilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lowestpricestore_itemlayout, parent, false);
        return new OilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OilViewHolder holder, int position) {
        OilModel oilModel = oilModelList.get(position);
        holder.setData(oilModel);
    }

    @Override
    public int getItemCount() {
        return oilModelList.size();
    }
}
