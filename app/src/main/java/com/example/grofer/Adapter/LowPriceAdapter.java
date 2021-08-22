package com.example.grofer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grofer.model.LowPriceStoreModel;
import com.example.grofer.ViewHolder.LowPriceViewHolder;
import com.example.grofer.R;

import java.util.List;
public class LowPriceAdapter extends RecyclerView.Adapter<LowPriceViewHolder> {
    private List<LowPriceStoreModel> lowPriceStoreModelList;

    public LowPriceAdapter(List<LowPriceStoreModel> lowPriceStoreModelList) {
        this.lowPriceStoreModelList = lowPriceStoreModelList;
    }
    @NonNull
    @Override
    public LowPriceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lowestpricestore_itemlayout, parent, false);
        return new LowPriceViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LowPriceViewHolder holder, int position) {
        LowPriceStoreModel lowPriceStoreModel = lowPriceStoreModelList.get(position);
        holder.setData(lowPriceStoreModel);
    }
    @Override
    public int getItemCount() {
        return lowPriceStoreModelList.size();
    }
    public void updateData(List<LowPriceStoreModel> lowPriceStoreModelList){
        this.lowPriceStoreModelList = lowPriceStoreModelList;
        notifyDataSetChanged();
    }
}