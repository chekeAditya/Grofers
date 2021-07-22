package com.example.grofer.FruitsAndVegetables;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grofer.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FruitVegetableAdapterOne extends RecyclerView.Adapter<FruitsVegetableViewHolderOne> {

    private ArrayList<FruitsVegetableOne> fruitsVegetableOnesList;

    public FruitVegetableAdapterOne(ArrayList<FruitsVegetableOne> fruitsVegetableOnesList) {
        this.fruitsVegetableOnesList = fruitsVegetableOnesList;
    }

    @NotNull
    @Override
    public FruitsVegetableViewHolderOne onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruits_vegetable_one,parent,false);
        return new FruitsVegetableViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  FruitsVegetableViewHolderOne holder, int position) {
        FruitsVegetableOne fruitsVegetableOne = fruitsVegetableOnesList.get(position);
        holder.setData(fruitsVegetableOne);
    }

    @Override
    public int getItemCount() {
        return fruitsVegetableOnesList.size();
    }
}
