package com.example.grofer.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseOIlModel implements Serializable {

	@SerializedName("oil")
	private List<OilModel> oil;

	public List<OilModel> getOil(){
		return oil;
	}
}