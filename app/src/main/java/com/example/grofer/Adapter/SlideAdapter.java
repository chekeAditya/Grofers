package com.example.grofer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.grofer.Activity.HomeActivity;
import com.example.grofer.R;
import com.example.grofer.Activity.slideItemLayoutHomeActivity;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SlideAdapter extends SliderViewAdapter<SlideAdapter.SliderAdapterViewHolder> {
    private final List<slideItemLayoutHomeActivity> mSliderItems;


    public SlideAdapter(HomeActivity homeActivity, List<slideItemLayoutHomeActivity> mSliderItems) {
        this.mSliderItems = mSliderItems;
    }


    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {

        final slideItemLayoutHomeActivity sliderItem = mSliderItems.get(position);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);
    }

    // this method will return
    // the count of our list.
    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        // Adapter class for initializing
        // the views of our slider view.
        View itemView;
        ImageView imageViewBackground;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.mimage);
            this.itemView = itemView;
        }
    }
}
