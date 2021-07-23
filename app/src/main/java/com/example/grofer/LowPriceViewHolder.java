package com.example.grofer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class LowPriceViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvItemImage;
    private TextView mTvDiscount,mTvDescription,mTvPrice,mTvRatings,mTvTotalRatings,mTvQuantity;
    private TextView mTvMemberShiPrice;


    public LowPriceViewHolder(@NonNull View itemView) {
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

    public void setData(LowPriceStoreModel lowPriceStoreModel) {
        Glide.with(mIvItemImage).load(lowPriceStoreModel.getAvatar()).into(mIvItemImage);
        mTvDiscount.setText(lowPriceStoreModel.getDiscount());
        mTvDescription.setText(lowPriceStoreModel.getDescription());
        mTvPrice.setText(lowPriceStoreModel.getPrice());
        mTvRatings.setText(lowPriceStoreModel.getRatings());
        mTvTotalRatings.setText(lowPriceStoreModel.getTotalRatings());
        mTvQuantity.setText(lowPriceStoreModel.getQuantity());
        mTvMemberShiPrice.setText(lowPriceStoreModel.getUnlockPrice());
    }
}