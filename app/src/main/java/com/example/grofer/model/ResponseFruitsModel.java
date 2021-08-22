package com.example.grofer.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
public class ResponseFruitsModel implements Serializable {

	@SerializedName("fruits")
	private List<FruitsModel> fruits;

	public List<FruitsModel> getFruits(){
		return fruits;
	}
}