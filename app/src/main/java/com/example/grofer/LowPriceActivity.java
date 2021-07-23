package com.example.grofer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class LowPriceActivity extends AppCompatActivity {
    private static final String TAG = LowPriceActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<LowPriceStoreModel> lowPriceStoreModelList = new ArrayList<>();
    private LowPriceAdapter lowPriceAdapter;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            loadJsonFromAsset();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_price);
        startBackgroundThread();
        initViewsAndListeners();
        setRecyclerAdapter();
    }
    private void setRecyclerAdapter() {
        lowPriceAdapter = new LowPriceAdapter(lowPriceStoreModelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(lowPriceAdapter);
    }

    private void initViewsAndListeners() {
        recyclerView = findViewById(R.id.recyclerView);
    }
    private void startBackgroundThread() {
        Thread thread = new Thread(runnable);
        thread.start();
    }
    private void loadJsonFromAsset() {
        try {
            InputStream inputStream = getAssets().open("lowestprice.json");
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
        Type type = new TypeToken<ResponseLowestPriceModel>() {
        }.getType();
        ResponseLowestPriceModel responseLowestPriceModel = new Gson().fromJson(json, type);
        lowPriceStoreModelList = responseLowestPriceModel.getLowPriceStore();
        updateRecyclerView();
    }
    private void updateRecyclerView() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lowPriceAdapter.updateData(lowPriceStoreModelList);
            }
        });
    }
}