package com.example.grofer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;

public class SearchActivity extends AppCompatActivity {
    private EditText mSearchCategory;
    private Button mBtnSearch;
    private View mBackInSearch;
    private String Category;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private FruitsAdapter fruitsAdapter;
    private LowPriceAdapter lowPriceAdapter;
    private VegetablesAdapter vegetablesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        progressBar = findViewById(R.id.shopProgressBar);
        recyclerView = findViewById(R.id.shopRecyclerView);
        mSearchCategory = findViewById(R.id.etSearchItem);
        mBtnSearch = findViewById(R.id.btnSearchItem);
        mBackInSearch = findViewById(R.id.backInSearch);

        mBackInSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSearchCategory.getText().toString().equals("fruits")) {
                    fetchDataFromAssets();
                } else if (mSearchCategory.getText().toString().equals("vegetables")){
                    fetchDataFromAssets3();
                }
                else {
                    fetchDataFromAssets2();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    private void fetchDataFromAssets() {
        try {
            InputStream inputStream = getAssets().open("fruits.json");
            int data = inputStream.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (data != -1) {
                char ch = (char) data;
                stringBuffer.append(ch);
                data = inputStream.read();
            }
            buildDataFromJson(stringBuffer.toString());

        } catch (Exception e) {
            Log.d("TAG", e.getMessage());
        }
    }

    private void buildDataFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ResponseFruitsModel>() {
        }.getType();
        ResponseFruitsModel responseFruitsModel = gson.fromJson(json, type);
         setRecyclerAdapter(responseFruitsModel);
        progressBar.setVisibility(View.GONE);
    }

    private void setRecyclerAdapter(ResponseFruitsModel responseFruitsModel) {
        fruitsAdapter = new FruitsAdapter(responseFruitsModel.getFruits());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fruitsAdapter);
    }



    private void fetchDataFromAssets2() {
        try {
            InputStream inputStream = getAssets().open("lowestprice.json");
            int data = inputStream.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (data != -1) {
                char ch = (char) data;
                stringBuffer.append(ch);
                data = inputStream.read();
            }
            buildDataFromJson2(stringBuffer.toString());

        } catch (Exception e) {
            Log.d("TAG", e.getMessage());
        }
    }

    private void buildDataFromJson2(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ResponseLowestPriceModel>() {
        }.getType();
        ResponseLowestPriceModel responseLowestPriceModel= gson.fromJson(json, type);
        setRecyclerAdapter2(responseLowestPriceModel);
        progressBar.setVisibility(View.GONE);
    }

    private void setRecyclerAdapter2(ResponseLowestPriceModel responseLowestPriceModel) {
        lowPriceAdapter = new LowPriceAdapter(responseLowestPriceModel.getLowPriceStore());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(lowPriceAdapter);
    }


    private void fetchDataFromAssets3() {
        try {
            InputStream inputStream = getAssets().open("vegetables.json");
            int data = inputStream.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (data != -1) {
                char ch = (char) data;
                stringBuffer.append(ch);
                data = inputStream.read();
            }
            buildDataFromJson3(stringBuffer.toString());

        } catch (Exception e) {
            Log.d("TAG", e.getMessage());
        }
    }

    private void buildDataFromJson3(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ResponseVegetablesModel>() {
        }.getType();
        ResponseVegetablesModel responseVegetablesModel = gson.fromJson(json, type);
        setRecyclerAdapter3(responseVegetablesModel);
        progressBar.setVisibility(View.GONE);
    }

    private void setRecyclerAdapter3(ResponseVegetablesModel responseVegetablesModel) {
        vegetablesAdapter = new VegetablesAdapter(responseVegetablesModel.getVegetable());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(vegetablesAdapter);
    }
}