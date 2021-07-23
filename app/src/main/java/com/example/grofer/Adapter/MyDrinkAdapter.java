package com.example.grofer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.grofer.R;
import com.example.grofer.eventBus.MyUpdateCartEvent;
import com.example.grofer.listener.ICartLoadListener;
import com.example.grofer.listener.IRecyclerViewClickListener;
import com.example.grofer.model.CartModel;
import com.example.grofer.model.DrinkModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyDrinkAdapter extends RecyclerView.Adapter<MyDrinkAdapter.MyDrinkViewHolder> {

    private Context context;
    private List<DrinkModel> drinkModelsList;
    private ICartLoadListener iCartLoadListener;

    public MyDrinkAdapter(Context context, List<DrinkModel> drinkModelsList, ICartLoadListener iCartLoadListener) {
        this.context = context;
        this.drinkModelsList = drinkModelsList;
        this.iCartLoadListener = iCartLoadListener;
    }

    @NonNull
    @Override
    public MyDrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyDrinkViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.layout_drink_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyDrinkViewHolder holder, int position) {
        Glide.with(context)
                .load(drinkModelsList.get(position).getImage())
                .into(holder.imageView);
        holder.txtPrice.setText(new StringBuilder("Rs.").append(drinkModelsList.get(position).getPrice()));
        holder.txtName.setText(new StringBuilder().append(drinkModelsList.get(position).getName()));

        //holder for item added to cart
        holder.setListener((view, adapterPosition) -> {
            addTocart(drinkModelsList.get(position));
        });
    }

    private void addTocart(DrinkModel drinkModel) {
        DatabaseReference userCart = FirebaseDatabase.getInstance()
                .getReference("Cart")
                .child("UNIQUE_USER_ID");//In other project we can add user id here
        userCart.child(drinkModel.getKey())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) { //if user already have item in cart
                            //just update and totalPrice
                            CartModel cartModel = snapshot.getValue(CartModel.class);
                            cartModel.setQuantity(cartModel.getQuantity() +1 );//quantity changed
                            Map<String, Object> updateData = new HashMap<>();
                            updateData.put("quantity", cartModel.getQuantity() +1 );//quantity changed
                            updateData.put("totalPrice", cartModel.getQuantity()*Float.parseFloat(cartModel.getPrice()));
                            userCart.child(drinkModel.getKey())
                                    .updateChildren(updateData)
                                    .addOnSuccessListener(unused -> {
                                        iCartLoadListener.onCartLoadFailed("Add to cart Success");
                                    })
                                    .addOnFailureListener(e -> {
                                iCartLoadListener.onCartLoadFailed(e.getMessage());
                            });


                        } else { //if item not have in cart, add new
                            CartModel cartModel = new CartModel();
                            cartModel.setName(drinkModel.getName());
                            cartModel.setImage(drinkModel.getImage());
                            cartModel.setKey(drinkModel.getKey());
                            cartModel.setPrice(drinkModel.getPrice());
                            cartModel.setQuantity(1);
                            cartModel.setTotalPrice(Float.parseFloat(drinkModel.getPrice()));
                            userCart.child(drinkModel.getKey())
                                    .setValue(cartModel)
                                    .addOnSuccessListener(unused -> {
                                        iCartLoadListener.onCartLoadFailed("Add to cart Success");
                                    })
                                    .addOnFailureListener(e -> {
                                        iCartLoadListener.onCartLoadFailed(e.getMessage());
                                    });
                        }
                        EventBus.getDefault().postSticky(new MyUpdateCartEvent());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        iCartLoadListener.onCartLoadFailed(error.getMessage());
                    }
                });
    }

    @Override
    public int getItemCount() {
        return drinkModelsList.size();
    }


    public class MyDrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtPrice)
        TextView txtPrice;

        //adding to cart Listener
        IRecyclerViewClickListener listener;

        public void setListener(IRecyclerViewClickListener listener) {
            this.listener = listener;
        }


        private Unbinder unbinder;

        public MyDrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onRecyclerViewClick(v, getAdapterPosition());
        }
    }
}
