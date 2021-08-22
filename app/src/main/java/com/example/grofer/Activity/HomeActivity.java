package com.example.grofer.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.grofer.BrowseCategories.BrowseCategoriesAdapter;
import com.example.grofer.BrowseCategories.BrowseCategoriesModel;
import com.example.grofer.BrowseCategories.BrowseItemClickListener;
import com.example.grofer.FruitsAndVegetables.FruitVegetableAdapterOne;
import com.example.grofer.FruitsAndVegetables.FruitsVegetableOne;
import com.example.grofer.R;
import com.example.grofer.Adapter.SlideAdapter;
import com.example.grofer.Extras.browseCategories_itemClicked;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements BrowseItemClickListener {
    EditText mEtSearchProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acitivity);
        mEtSearchProduct = findViewById(R.id.etSearchProduct);
        BottomNavigation();
        slideView();
        browseRecyclerView();
        otherSupplies();
        fruitsVegetablesOne();
        multipleButtonClickListener();
        mEtSearchProduct.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,SearchActivity.class);
            startActivity(intent);
        });
    }

    private void multipleButtonClickListener() {
        Button mBtnAddByCategories = findViewById(R.id.btnAddByCategories);
        mBtnAddByCategories.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,CategoryActivity.class);
            startActivity(intent);
        });
        Button mBtnAddLowestPrice = findViewById(R.id.btnAddLowestPrice);
        mBtnAddLowestPrice.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,LowPriceActivity.class);
            startActivity(intent);
        });
        Button mBtnExploreCategories = findViewById(R.id.btnExploreCategories);
        mBtnExploreCategories.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,OfferActivity.class);
            startActivity(intent);
        });
        Button btnChaoticMotifShoppingBhi = findViewById(R.id.btnChotiMotiShoppingBhi);
        btnChaoticMotifShoppingBhi.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,MembershipActivity.class);
            startActivity(intent);
        });
        Button mBtnViewAllCategories = findViewById(R.id.btnViewAllCategories);
        mBtnViewAllCategories.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, browseCategories_itemClicked.class);
            startActivity(intent);
        });

    }

    private void fruitsVegetablesOne() {
        RecyclerView mRecyclerView = findViewById(R.id.fruitsVegetablesRecyclerViewOne);
        ArrayList<FruitsVegetableOne> fruitsVegetableOnes = new ArrayList<>();
        fruitsVegetableOnes.add(new FruitsVegetableOne("https://www.dole.com/-/media/project/dole/produce-images/headers/dole-produce-fruit-medley.png?h=540&w=720&rev=1416123f2d094cd1b7494365948214be&hash=09AD8D65F7B13901453125B22EE62C00","Fruits"));
        fruitsVegetableOnes.add(new FruitsVegetableOne("https://www.lalpathlabs.com/blog/wp-content/uploads/2019/01/Fruits-and-Vegetables.jpg","Vegetables"));
        fruitsVegetableOnes.add(new FruitsVegetableOne("https://plkhaire.com/images/2019/03/28/ratnagiri-alphonso-mangoes.png","Mangoes"));
        fruitsVegetableOnes.add(new FruitsVegetableOne("https://thumbor.thedailymeal.com/TcsLq8_wc9LgWfsMYWJpSLp_KEg=/870x565/https://www.thedailymeal.com/sites/default/files/slideshows/copy/dreamstime_m_2.jpg","All Fruits And Vegetables"));
        FruitVegetableAdapterOne fruitVegetableAdapterOne = new FruitVegetableAdapterOne(fruitsVegetableOnes);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        mRecyclerView.setAdapter(fruitVegetableAdapterOne);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    private void otherSupplies() {
        RecyclerView mRecyclerViewOtherSupplies  = findViewById(R.id.otherSuppliesRecycler);
        ArrayList<BrowseCategoriesModel> browseCategoriesModels = new ArrayList<>();
        browseCategoriesModels.add(new BrowseCategoriesModel("Up to 65 % off","Household Items","https://www.northfloridavision.com/uploads/images/assorted-household-cleaners.jpg"));
        browseCategoriesModels.add(new BrowseCategoriesModel("Up to 55 % off","Personal Care","https://5.imimg.com/data5/QS/TO/MY-44941618/personal-care-500x500.jpg"));
        browseCategoriesModels.add(new BrowseCategoriesModel("Up to 40 % off","Furnishing & Accessories","https://3.imimg.com/data3/GW/OI/GLADMIN-10691/home-furnishings-accessories-500x500.jpg"));
        browseCategoriesModels.add(new BrowseCategoriesModel("Up to 15 % off","Stationery & Games","https://e-ism.in/wp-content/uploads/2021/02/Brain-Box-Product-5-Resized-4-365x365.jpg"));
        browseCategoriesModels.add(new BrowseCategoriesModel("Up to 50 % off","Baby care","https://5.imimg.com/data5/UY/ZM/LG/SELLER-69650986/new-born-baby-kit-in-india-online-250x250.png"));
        browseCategoriesModels.add(new BrowseCategoriesModel("Up to 15 % off","kitchen and dining","https://www.mealime.com/images/kitchen.jpg"));
        browseCategoriesModels.add(new BrowseCategoriesModel("Up to 15 % off","Fashion & Lifestyle","https://thumbs.dreamstime.com/b/fashion-beautiful-young-woman-enjoying-shopping-holding-bags-lifestyle-concept-front-rusty-gate-presenting-item-clothing-182000179.jpg"));
        browseCategoriesModels.add(new BrowseCategoriesModel("Up to 15 % off","Pet Care","https://image.shutterstock.com/image-vector/dog-items-set-care-object-260nw-514218922.jpg"));
        BrowseCategoriesAdapter browseCategoriesAdapter = new BrowseCategoriesAdapter(browseCategoriesModels,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        mRecyclerViewOtherSupplies.setAdapter(browseCategoriesAdapter);
        mRecyclerViewOtherSupplies.setLayoutManager(gridLayoutManager);
    }

    private void browseRecyclerView() {
        RecyclerView mRecyclerViewBrowseCategories = findViewById(R.id.browseRecyclerView);
        ArrayList<BrowseCategoriesModel> browseCategoriesModels = new ArrayList<>();
            browseCategoriesModels.add(new BrowseCategoriesModel("Up to 55% off", "Grocery & Stables", "https://i.pinimg.com/originals/21/5e/31/215e31a98cb6fd49cf29b70d8af45d6c.png"));
            browseCategoriesModels.add(new BrowseCategoriesModel("Up to 10% off", "Fruits & Vegetables", "https://www.lalpathlabs.com/blog/wp-content/uploads/2019/01/Fruits-and-Vegetables.jpg"));
            browseCategoriesModels.add(new BrowseCategoriesModel("Up to 40% off", "Dairy & Breakfast", "https://media.foodnetwork.ca/uploadedimages/pages/guides/healthy_eating/galleries/dairy-free-breakfast-ideas.jpg"));
            browseCategoriesModels.add(new BrowseCategoriesModel("Up to 52% off", "Tea, Coffee & Drinks", "https://www.mercurynews.com/wp-content/uploads/2018/05/sjm-peets-0523-01.jpg"));
            browseCategoriesModels.add(new BrowseCategoriesModel("Up to 50% off", "Bakery & Snacks", "https://3.imimg.com/data3/RA/OB/MY-7364739/bakery-snacks-500x500.png"));
            browseCategoriesModels.add(new BrowseCategoriesModel("Up to 55% off", "Sauces & Instant Food & Snacks", "https://www.snapgreen.in/assets/images/category/small/cat_7.webp"));
            browseCategoriesModels.add(new BrowseCategoriesModel("Up to 10% off", "Chicken and meat food", "https://i.pinimg.com/originals/c3/80/f3/c380f33d3c5a019644c2b591993ab209.jpg"));
            browseCategoriesModels.add(new BrowseCategoriesModel("Up to 30% off", "Fresh & Frozen Food", "https://www.italian-feelings.com/wp-content/uploads/2018/11/surgelati-940x519.jpg"));
        BrowseCategoriesAdapter browseCategoriesAdapter = new BrowseCategoriesAdapter(browseCategoriesModels,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        mRecyclerViewBrowseCategories.setAdapter(browseCategoriesAdapter);
        mRecyclerViewBrowseCategories.setLayoutManager(gridLayoutManager);

    }

    private void slideView() {
        SliderView sliderView = findViewById(R.id.imageSlider);
        ArrayList<slideItemLayoutHomeActivity> sliderDataArrayList = new ArrayList<>();
        sliderDataArrayList.add(new slideItemLayoutHomeActivity("https://www.linkpicture.com/q/add1.png"));
        sliderDataArrayList.add(new slideItemLayoutHomeActivity("https://www.linkpicture.com/q/add2.png"));
        sliderDataArrayList.add(new slideItemLayoutHomeActivity("https://www.linkpicture.com/q/add3.png"));
        sliderDataArrayList.add(new slideItemLayoutHomeActivity("https://www.linkpicture.com/q/add4.png"));
        sliderDataArrayList.add(new slideItemLayoutHomeActivity("https://www.linkpicture.com/q/add5.png"));
        sliderDataArrayList.add(new slideItemLayoutHomeActivity("https://www.linkpicture.com/q/add6.png"));
        sliderDataArrayList.add(new slideItemLayoutHomeActivity("https://www.linkpicture.com/q/add7.png"));
        SlideAdapter adapter = new SlideAdapter(this, sliderDataArrayList);

        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);

        sliderView.startAutoCycle();
    }

    @SuppressLint("NonConstantResourceId")
    private void BottomNavigation() {
        //init and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);

        //set home Selected
        bottomNavigationView.setSelectedItemId(R.id.homeIcon);

        //perform itemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (bottomNavigationView.getSelectedItemId()) {
                case R.id.categoriesIcon:
                    startActivity(new Intent(getApplicationContext(), CategoryActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.homeIcon:
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

    @Override
    public void browseOnItemClicked(int position, BrowseCategoriesModel browseCategoriesModel) {
        Intent intent = new Intent(HomeActivity.this, browseCategories_itemClicked.class);
        startActivity(intent);
    }
}

