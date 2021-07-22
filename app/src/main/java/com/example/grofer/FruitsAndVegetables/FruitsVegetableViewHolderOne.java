package com.example.grofer.FruitsAndVegetables;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.grofer.R;

import org.jetbrains.annotations.NotNull;

public class FruitsVegetableViewHolderOne extends RecyclerView.ViewHolder {

    private ImageView mivFruitsOne;
    private TextView mTvFruiName;

    public FruitsVegetableViewHolderOne(@NonNull @NotNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mivFruitsOne = itemView.findViewById(R.id.ivFruitsImage);
        mTvFruiName = itemView.findViewById(R.id.tvFruitsDetails);
    }

    public void setData(FruitsVegetableOne fruitsVegetableOne){
        Glide.with(mivFruitsOne).load(fruitsVegetableOne.getIvUrl()).into(mivFruitsOne);
        mTvFruiName.setText(fruitsVegetableOne.getTvFruitsDetailsOne());

    }
}
