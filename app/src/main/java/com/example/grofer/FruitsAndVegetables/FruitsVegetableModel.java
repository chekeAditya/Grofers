package com.example.grofer.FruitsAndVegetables;

public class FruitsVegetableModel {

    private int imageFruitsVegetables;
    private String titleFruitsVegetables;
    private String priceTagFruit;
    private String priceFruit;
    private int priceFruitsVegetables;

    public FruitsVegetableModel(int imageFruitsVegetables, String titleFruitsVegetables, String priceTagFruit, String priceFruit, int priceFruitsVegetables) {
        this.imageFruitsVegetables = imageFruitsVegetables;
        this.titleFruitsVegetables = titleFruitsVegetables;
        this.priceTagFruit = priceTagFruit;
        this.priceFruit = priceFruit;
        this.priceFruitsVegetables = priceFruitsVegetables;
    }

    public int getImageFruitsVegetables() {
        return imageFruitsVegetables;
    }

    public String getTitleFruitsVegetables() {
        return titleFruitsVegetables;
    }

    public String getPriceTagFruit() {
        return priceTagFruit;
    }

    public String getPriceFruit() {
        return priceFruit;
    }

    public int getPriceFruitsVegetables() {
        return priceFruitsVegetables;
    }
}
