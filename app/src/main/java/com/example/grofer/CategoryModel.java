package com.example.grofer;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
public class CategoryModel implements Serializable {

	@SerializedName("discount")
	private String discount;

	@SerializedName("type")
	private String type;

	@SerializedName("desc")
	private String desc;

	@SerializedName("avatar")
	private String avatar;

	public String getDiscount(){
		return discount;
	}

	public String getType(){
		return type;
	}

	public String getDesc(){
		return desc;
	}

	public String getAvatar(){
		return avatar;
	}
}