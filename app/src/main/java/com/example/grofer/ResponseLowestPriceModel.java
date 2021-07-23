package com.example.grofer;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class ResponseLowestPriceModel implements Serializable {

	@SerializedName("lowPriceStore")
	private List<LowPriceStoreModel> lowPriceStore;

	public List<LowPriceStoreModel> getLowPriceStore(){
		return lowPriceStore;
	}
}