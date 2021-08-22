package com.example.grofer.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.grofer.Adapter.MyCartAdapter;
import com.example.grofer.R;
import com.example.grofer.eventBus.MyUpdateCartEvent;
import com.example.grofer.listener.ICartLoadListener;
import com.example.grofer.model.CartModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity implements ICartLoadListener {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.recycler_cart)
    RecyclerView recyclerCart;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.mainLayout)
    RelativeLayout mainLayout;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btnBack)
    ImageView btnBack;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.txtTotal)
    TextView txtTotal;

    ICartLoadListener cartLoadListener;

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        if (EventBus.getDefault().hasSubscriberForEvent(MyUpdateCartEvent.class))
            EventBus.getDefault().removeStickyEvent(MyUpdateCartEvent.class);
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ImageView mBtnCheckoutCart = findViewById(R.id.btnCheckoutCart);
        initViews();
        loadCartFromFirebase();
        mBtnCheckoutCart.setOnClickListener(v -> {
            Intent cartIntent = new Intent(CartActivity.this, VerifyPhoneNumber.class);
            startActivity(cartIntent);
        });

    }

    private void loadCartFromFirebase() {
        List<CartModel> cartModels = new ArrayList<>();
        FirebaseDatabase.getInstance()
                .getReference("Cart")
                .child("UNIQUE_USER_ID")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            for (DataSnapshot cartSnapshot : snapshot.getChildren()) {
                                CartModel cartModel = cartSnapshot.getValue(CartModel.class);
                                assert cartModel != null;
                                cartModel.setKey(cartSnapshot.getKey());
                                cartModels.add(cartModel);
                            }
                            cartLoadListener.onCartLoadSuccess(cartModels);
                        } else
                            cartLoadListener.onCartLoadFailed("Cart Empty");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        cartLoadListener.onCartLoadFailed(error.getMessage());
                    }
                });
    }

    private void initViews() {
        ButterKnife.bind(this);
        cartLoadListener = this;
        //asking layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerCart.setLayoutManager(linearLayoutManager);
        recyclerCart.addItemDecoration(new DividerItemDecoration(this, linearLayoutManager.getOrientation()));
        recyclerCart.addItemDecoration(new DividerItemDecoration(this, linearLayoutManager.getOrientation()));
        btnBack.setOnClickListener(v -> finish());
    }

    @Override
    public void onCartLoadSuccess(List<CartModel> cartModelList) {
        double sum = 0;
        for (CartModel cartModel : cartModelList) {
            sum += cartModel.getTotalPrice();
        }
        txtTotal.setText(new StringBuilder("Rs").append(sum));
        MyCartAdapter adapter = new MyCartAdapter(this, cartModelList);
        recyclerCart.setAdapter(adapter);
    }

    @Override
    public void onCartLoadFailed(String message) {
        Snackbar.make(mainLayout, message, Snackbar.LENGTH_SHORT).show();
    }
}