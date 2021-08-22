package com.example.grofer.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.grofer.R;
import com.example.grofer.model.CategoryModel;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvProductImage;
    private TextView mTvDiscount;
    private TextView mTvType;
    private TextView mTvDesc;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvDiscount = itemView.findViewById(R.id.tvDiscount);
        mTvType = itemView.findViewById(R.id.tvType);
        mTvDesc = itemView.findViewById(R.id.tvDesc);
        mIvProductImage = itemView.findViewById(R.id.ivProductImage);
    }

    public void setData(CategoryModel categoryModel) {
        Glide.with(mIvProductImage).load(categoryModel.getAvatar()).into(mIvProductImage);
        mTvDiscount.setText(categoryModel.getDiscount());
        mTvType.setText(categoryModel.getType());
        mTvDesc.setText(categoryModel.getDesc());
    }
}