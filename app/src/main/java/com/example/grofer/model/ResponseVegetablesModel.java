package com.example.grofer.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
public class ResponseVegetablesModel implements Serializable {

	@SerializedName("vegetable")
	private List<VegetableModel> vegetable;

	public List<VegetableModel> getVegetable(){
		return vegetable;
	}
}