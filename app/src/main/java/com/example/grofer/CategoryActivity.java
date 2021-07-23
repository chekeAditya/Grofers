package com.example.grofer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.lang.reflect.Type;
import android.annotation.SuppressLint;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;
public class CategoryActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private static final String TAG = CategoryActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<CategoryModel> categoryModelList = new ArrayList<>();
    private CategoryAdapter categoryAdapter;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            loadJsonFromAsset();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        startBackgroundThread();
        initViewsAndListeners();
        setRecyclerAdapter();
    }

    private void setRecyclerAdapter() {
        categoryAdapter = new CategoryAdapter(categoryModelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(categoryAdapter);
    }
    private void initViewsAndListeners() {
        recyclerView = findViewById(R.id.recyclerView);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        bottomNavigationView.setSelectedItemId(R.id.categoriesIcon);
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
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                categoryAdapter.updateData(categoryModelList);
            }
        });
    }
}