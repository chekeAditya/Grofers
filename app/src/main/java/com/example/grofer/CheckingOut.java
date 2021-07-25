package com.example.grofer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckingOut extends AppCompatActivity {
    private Button mBtnContinueShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_out);
        mBtnContinueShopping=findViewById(R.id.tvBtnContinueShopping);
        mBtnContinueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentContinue= new Intent(CheckingOut.this,HomeAcitivity.class);
                startActivity(intentContinue);
            }
        });
    }
}