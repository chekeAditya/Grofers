package com.example.grofer.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grofer.Adapter.CategoryAdapter;
import com.example.grofer.R;
import com.example.grofer.model.CategoryModel;
import com.example.grofer.model.ResponseModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    EditText mEtSearchProduct;
    private static final String TAG = CategoryActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<CategoryModel> categoryModelList = new ArrayList<>();
    private CategoryAdapter categoryAdapter;
    private final Runnable runnable = this::loadJsonFromAsset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        mEtSearchProduct = findViewById(R.id.etSearchProduct);
        startBackgroundThread();
        initViewsAndListeners();
        setRecyclerAdapter();
        mEtSearchProduct.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this,SearchActivity.class);
            startActivity(intent);
        });
    }

    private void setRecyclerAdapter() {
        categoryAdapter = new CategoryAdapter(categoryModelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(categoryAdapter);
    }
    @SuppressLint("NonConstantResourceId")
    private void initViewsAndListeners() {
        recyclerView = findViewById(R.id.recyclerView);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        bottomNavigationView.setSelectedItemId(R.id.categoriesIcon);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (bottomNavigationView.getSelectedItemId()) {
                case R.id.categoriesIcon:
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
                    startActivity(new Intent(getApplicationContext(), MembershipActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });
    }
    private void startBackgroundThread() {
        Thread thread = new Thread(runnable);
        thread.start();
    }
    private void loadJsonFromAsset() {
        try {
            InputStream inputStream = getAssets().open("category.json");
            int data = inputStream.read();
            StringBuilder stringBuilder = new StringBuilder();
            while (data != -1) {
                char ch = (char) data;
                stringBuilder.append(ch);
                data = inputStream.read();
            }
            buildDataFromJSON(stringBuilder.toString());

        } catch (Exception e) {
            Log.d(TAG, "Exception occurred with a message " +e.getLocalizedMessage());
        }
    }
    private void buildDataFromJSON(String json) {
        Type type = new TypeToken<ResponseModel>() {
        }.getType();
        ResponseModel responseModel = new Gson().fromJson(json, type);
        categoryModelList = responseModel.getCategories();
        updateRecyclerView();
    }
    private void updateRecyclerView() {
        runOnUiThread(() -> categoryAdapter.updateData(categoryModelList));
    }
}