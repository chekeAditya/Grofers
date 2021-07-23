package com.example.grofer;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
public class ResponseLowestPriceModel implements Serializable {

	@SerializedName("lowPriceStore")
	private List<LowPriceStoreModel> lowPriceStore;

	public List<LowPriceStoreModel> getLowPriceStore(){
		return lowPriceStore;
	}
}