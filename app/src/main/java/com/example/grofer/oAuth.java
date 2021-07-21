package com.example.grofer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class oAuth extends AppCompatActivity {

    private EditText mEtPhoneNumber;
    FirebaseAuth mAuth;
    private Button mBtnNextLoginPage, mBtnTrueCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_screen);
        initViews();
        mBtnNextLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optGenerate();
            }
        });
    }

    private void optGenerate() {
        if (validPhoneNumber()) {
            Intent intent = new Intent(getApplicationContext(), VerifyPhoneNumber.class);
            intent.putExtra("phoneNumber", mEtPhoneNumber.getText().toString());
            startActivity(intent);
        }
    }

    private void initViews() {
        mEtPhoneNumber = findViewById(R.id.etOtp);
        mBtnNextLoginPage = findViewById(R.id.btnNextLoginPage);
        mBtnTrueCaller = findViewById(R.id.btnTrueCaller);
    }

    private boolean validPhoneNumber() {
        if (mEtPhoneNumber.getText().toString().length() == 10) {
            return true;
        }else {
            mEtPhoneNumber.setError("Enter Valid PhoneNumber");
        }
        return false;
    }
}