package com.example.grofer.model;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
public class VegetableModel implements Serializable {

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