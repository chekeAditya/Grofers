package com.example.grofer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.grofer.model.Profile;
import com.example.grofer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MembershipActivity extends AppCompatActivity {

    TextView mTvFaq;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);
        Button mBtnProfile = findViewById(R.id.btnProfile);
        mTvFaq = findViewById(R.id.tvFaq);
        mBtnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MembershipActivity.this, Profile.class);
            startActivity(intent);
        });

        mTvFaq.setOnClickListener(v -> {
            Intent intent3 = new Intent(MembershipActivity.this, FAQS.class);
            startActivity(intent3);
        });

    //init and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);

        //set home Selected
        bottomNavigationView.setSelectedItemId(R.id.memberShipIcon);

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
                    startActivity(new Intent(getApplicationContext(), OfferActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.memberShipIcon:
                    return true;
            }
            return false;
        });
    }
}