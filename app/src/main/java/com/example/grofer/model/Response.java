package com.example.grofer.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("fruits")
	private List<FruitsItem> fruits;

	public List<FruitsItem> getFruits(){
		return fruits;
	}
}