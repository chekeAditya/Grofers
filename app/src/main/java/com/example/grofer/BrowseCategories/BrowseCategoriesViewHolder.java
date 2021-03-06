package com.example.grofer.BrowseCategories;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.grofer.R;


public class BrowseCategoriesViewHolder extends RecyclerView.ViewHolder {

    private BrowseItemClickListener browseItemClickListener;
    private ImageView mIvImageCategories;
    private TextView mTvOfferCategories;
    private TextView mTvCategoriesName;
    private CardView mCardView;


    public BrowseCategoriesViewHolder(@NonNull View itemView,BrowseItemClickListener browseItemClickListener) {
        super(itemView);
        this.browseItemClickListener = browseItemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvImageCategories = itemView.findViewById(R.id.ivImageCategories);
        mTvOfferCategories = itemView.findViewById(R.id.tvOfferCategories);
        mTvCategoriesName = itemView.findViewById(R.id.tvCategoriesName);
        mCardView = itemView.findViewById(R.id.cardViewBrowseCategories);
    }

    public void setData(BrowseCategoriesModel categoriesModel){
       Glide.with(mIvImageCategories).load(categoriesModel.getUrl()).into(mIvImageCategories);
        mTvCategoriesName.setText(categoriesModel.getTvCategoriesName());
        mTvOfferCategories.setText(categoriesModel.getTvOfferCategories());
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browseItemClickListener.browseOnItemClicked(getLayoutPosition(),categoriesModel);
            }
        });
    }
}
