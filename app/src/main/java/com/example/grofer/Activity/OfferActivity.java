package com.example.grofer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.grofer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OfferActivity extends AppCompatActivity {
    EditText mEtSearchProduct;
    ImageButton mImBtnMin30;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        mEtSearchProduct = findViewById(R.id.etSearchProduct);
        mImBtnMin30 = findViewById(R.id.btnMin30);
        //init and assign variable
        mImBtnMin30.setOnClickListener(v -> {
            Intent intent1 = new Intent(OfferActivity.this,LowPriceActivity.class);
            startActivity(intent1);
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        mEtSearchProduct.setOnClickListener(v -> {
            Intent intent = new Intent(OfferActivity.this,SearchActivity.class);
            startActivity(intent);
        });

        //set home Selected
        bottomNavigationView.setSelectedItemId(R.id.offersIcon);

        //perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (bottomNavigationView.getSelectedItemId()) {
                case R.id.categoriesIcon:
                    startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.homeIcon:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.offersIcon:
                    return true;
                case R.id.memberShipIcon:
                    startActivity(new Intent(getApplicationContext(), MembershipActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });
    }
}