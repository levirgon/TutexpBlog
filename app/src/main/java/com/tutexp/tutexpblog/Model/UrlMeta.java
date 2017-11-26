package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class UrlMeta{

	@SerializedName("origin")
	private int origin;

	@SerializedName("position")
	private int position;

	public int getOrigin(){
		return origin;
	}

	public int getPosition(){
		return position;
	}

	@Override
 	public String toString(){
		return 
			"UrlMeta{" + 
			"origin = '" + origin + '\'' + 
			",position = '" + position + '\'' + 
			"}";
		}
}