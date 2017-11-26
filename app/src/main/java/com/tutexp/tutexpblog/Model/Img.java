package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Img{

	@SerializedName("src")
	private String src;

	@SerializedName("width")
	private int width;

	@SerializedName("height")
	private int height;

	public String getSrc(){
		return src;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"Img{" + 
			"src = '" + src + '\'' + 
			",width = '" + width + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}