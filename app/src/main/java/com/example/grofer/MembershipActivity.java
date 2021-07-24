package com.example.grofer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MembershipActivity extends AppCompatActivity {

    private ImageView mBtnImageView;
    private Button mBtnProfile;
    private CardView mCardFaqs;
    TextView mTvFaq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);
        mBtnImageView = findViewById(R.id.tvBtnRightAngle);
        mBtnProfile = findViewById(R.id.btnProfile);
        mCardFaqs =findViewById(R.id.cardFaqs);
        mTvFaq = findViewById(R.id.tvFaq);
        mBtnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MembershipActivity.this,Profile.class);
                startActivity(intent);
            }
        });

        mTvFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MembershipActivity.this, FAQS.class);
                startActivity(intent3);
            }
        });

    //init and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);

        //set home Selected
        bottomNavigationView.setSelectedItemId(R.id.memberShipIcon);

        //perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (bottomNavigationView.getSelectedItemId()) {
                    case R.id.categoriesIcon:
                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.homeIcon:
                        startActivity(new Intent(getApplicationContext(), HomeAcitivity.class));
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
            }
        });
    }
}