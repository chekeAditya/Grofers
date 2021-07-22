package com.example.grofer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //init and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);

        //set home Selected
        bottomNavigationView.setSelectedItemId(R.id.categoriesIcon);

        //perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (bottomNavigationView.getSelectedItemId()) {
                    case R.id.categoriesIcon:
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
                        startActivity(new Intent(getApplicationContext(), MembershipActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}