package com.example.grofer.BrowseCategories;

public class BrowseCategoriesModel {
    private String TvOfferCategories;
    private String TvCategoriesName;
    private String url;

    public BrowseCategoriesModel(String tvOfferCategories, String tvCategoriesName, String url) {
        TvOfferCategories = tvOfferCategories;
        TvCategoriesName = tvCategoriesName;
        this.url = url;
    }

    public String getTvOfferCategories() {
        return TvOfferCategories;
    }

    public String getTvCategoriesName() {
        return TvCategoriesName;
    }

    public String getUrl() {
        return url;
    }
}
