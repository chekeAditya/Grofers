package com.example.grofer;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
public class ResponseModel implements Serializable {

	@SerializedName("categories")
	private List<CategoryModel> categories;

	public List<CategoryModel> getCategories(){
		return categories;
	}
}