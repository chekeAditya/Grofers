package com.example.grofer.FruitsAndVegetables;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.grofer.R;

import org.jetbrains.annotations.NotNull;

public class FruitsVegetableViewHolder extends RecyclerView.ViewHolder {

    private FruitsItemClickListener fruitsItemClickListener;
    private ImageView mImageFruitsVegetables;
    private TextView mTitleFruitsVegetables;
    private TextView mPriceTagFruitView;
    private TextView mPriceFruitsVegetables;
    private Button mBtnAddFruitsVegetable;


    public FruitsVegetableViewHolder(@NonNull @NotNull View itemView,FruitsItemClickListener fruitsItemClickListener) {
        super(itemView);
        this.fruitsItemClickListener = fruitsItemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mImageFruitsVegetables = itemView.findViewById(R.id.ivFruitsImage);
        mTitleFruitsVegetables = itemView.findViewById(R.id.tvTitleFruits);
        mPriceTagFruitView = itemView.findViewById(R.id.tvPriceTagFruitsVegetable);
        mPriceFruitsVegetables = itemView.findViewById(R.id.tvPriceFruits);
        mBtnAddFruitsVegetable = itemView.findViewById(R.id.btnAddFruitsVegetables);
    }
    public void setData(FruitsModel fruitsModel){
        Glide.with(mImageFruitsVegetables).load(fruitsModel.getAvatar()).into(mImageFruitsVegetables);
        mTitleFruitsVegetables.setText(fruitsModel.getDescription());
        mPriceFruitsVegetables.setText(fruitsModel.getPrice());
        mPriceTagFruitView.setText(fruitsModel.getQuantity());
        mBtnAddFruitsVegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
