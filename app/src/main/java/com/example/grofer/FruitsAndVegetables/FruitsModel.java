package com.example.grofer.FruitsAndVegetables;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class FruitsModel implements Serializable {

	public FruitsModel(String category, String price, String quantity, String avatar, String description) {
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.avatar = avatar;
		this.description = description;
	}

	@SerializedName("category")
	private String category;

	@SerializedName("price")
	private String price;

	@SerializedName("quantity")
	private String quantity;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("description")
	private String description;

	public String getCategory(){
		return category;
	}

	public String getPrice(){
		return price;
	}

	public String getQuantity(){
		return quantity;
	}

	public String getAvatar(){
		return avatar;
	}

	public String getDescription(){
		return description;
	}
}