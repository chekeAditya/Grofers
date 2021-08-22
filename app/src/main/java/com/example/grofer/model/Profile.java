package com.example.grofer.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.grofer.Activity.HomeActivity;
import com.example.grofer.R;

public class Profile extends AppCompatActivity {
    private ImageView mIvBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mIvBack = findViewById(R.id.ivBack);
        ;
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Profile.this, HomeActivity.class);
             startActivity(intent);
            }
        });

    }

}