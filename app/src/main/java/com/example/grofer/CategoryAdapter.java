package com.example.grofer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<CategoryModel> categoryModelList;

    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_itemlayout, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryModel categoryModel = categoryModelList.get(position);
        holder.setData(categoryModel);
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }
    public void updateData(List<CategoryModel> categoryModelList){
        this.categoryModelList = categoryModelList;
        notifyDataSetChanged();
    }
}

