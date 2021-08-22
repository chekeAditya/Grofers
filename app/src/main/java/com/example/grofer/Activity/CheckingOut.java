package com.example.grofer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.grofer.R;

public class CheckingOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_out);
        Button mBtnContinueShopping = findViewById(R.id.tvBtnContinueShopping);
        mBtnContinueShopping.setOnClickListener(v -> {
            Intent intentContinue= new Intent(CheckingOut.this, HomeActivity.class);
            startActivity(intentContinue);
        });
    }
}