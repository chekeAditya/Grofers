package com.example.grofer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.grofer.R;

public class FAQS extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        ImageView mIvFaqBackIcon = findViewById(R.id.ivFaqsBackIcon);
        mIvFaqBackIcon.setOnClickListener(v -> {
            Intent intentOne = new Intent(FAQS.this, MembershipActivity.class);
            startActivity(intentOne);
        });
    }
}