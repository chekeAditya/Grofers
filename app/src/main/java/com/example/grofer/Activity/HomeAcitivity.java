package com.example.grofer.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.grofer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class HomeAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acitivity);

        //init and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);

        //set home Selected
        bottomNavigationView.setSelectedItemId(R.id.homeIcon);

        //perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (bottomNavigationView.getSelectedItemId()) {
                    case R.id.categoriesIcon:
                        startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.homeIcon:
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

