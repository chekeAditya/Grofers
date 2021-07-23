package com.example.grofer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FAQS extends AppCompatActivity {
    private ImageView mIvFaqBackIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        mIvFaqBackIcon=findViewById(R.id.ivFaqsBackIcon);
        mIvFaqBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOne = new Intent(FAQS.this, MembershipActivity.class);
                startActivity(intentOne);
            }
        });

    }
}