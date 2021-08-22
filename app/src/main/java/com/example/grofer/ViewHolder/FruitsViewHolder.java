package com.example.grofer.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.grofer.R;
import com.example.grofer.model.FruitsModel;

public class FruitsViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvItemImage;
    private TextView mTvDiscount,mTvDescription,mTvPrice,mTvRatings,mTvTotalRatings,mTvQuantity;
    private TextView mTvMemberShiPrice;

    public FruitsViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }
    private void initViews(View itemView) {
        mIvItemImage = itemView.findViewById(R.id.ivItemImage);
        mTvDiscount = itemView.findViewById(R.id.tvDiscount);
        mTvDescription = itemView.findViewById(R.id.tvDescription);
        mTvPrice = itemView.findViewById(R.id.tvPrice);
        mTvRatings = itemView.findViewById(R.id.tvRatings);
        mTvTotalRatings = itemView.findViewById(R.id.tvTotalRatings);
        mTvQuantity = itemView.findViewById(R.id.tvQuantity);
        mTvMemberShiPrice = itemView.findViewById(R.id.tvMembershipPrice);
    }

    public void setData(FruitsModel fruitsModel) {
        Glide.with(mIvItemImage).load(fruitsModel.getAvatar()).into(mIvItemImage);
        mTvDescription.setText(fruitsModel.getDescription());
        mTvPrice.setText(fruitsModel.getPrice());
        mTvQuantity.setText(fruitsModel.getQuantity());
    }
}
