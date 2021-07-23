package com.example.grofer;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
public class LowPriceStoreModel implements Serializable {

	@SerializedName("category")
	private String category;

	@SerializedName("price")
	private String price;

	@SerializedName("discount")
	private String discount;

	@SerializedName("ratings")
	private String ratings;

	@SerializedName("totalRatings")
	private String totalRatings;

	@SerializedName("quantity")
	private String quantity;

	@SerializedName("unlockPrice")
	private String unlockPrice;

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

	public String getDiscount(){
		return discount;
	}

	public String getRatings(){
		return ratings;
	}

	public String getTotalRatings(){
		return totalRatings;
	}

	public String getQuantity(){
		return quantity;
	}

	public String getUnlockPrice(){
		return unlockPrice;
	}

	public String getAvatar(){
		return avatar;
	}

	public String getDescription(){
		return description;
	}
}