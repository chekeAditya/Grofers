package com.example.grofer.model;

import com.google.gson.annotations.SerializedName;

public class FruitsItem{

	@SerializedName("quantity")
	private String quantity;

	@SerializedName("price")
	private String price;

	@SerializedName("description")
	private String description;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("category")
	private String category;

	public String getQuantity(){
		return quantity;
	}

	public String getPrice(){
		return price;
	}

	public String getDescription(){
		return description;
	}

	public String getAvatar(){
		return avatar;
	}

	public String getCategory(){
		return category;
	}

}