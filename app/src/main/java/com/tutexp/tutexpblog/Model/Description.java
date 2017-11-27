package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Description{

	@SerializedName("rendered")
	private String rendered;

	public String getRendered(){
		return rendered;
	}

	@Override
 	public String toString(){
		return 
			"Description{" + 
			"rendered = '" + rendered + '\'' + 
			"}";
		}
}