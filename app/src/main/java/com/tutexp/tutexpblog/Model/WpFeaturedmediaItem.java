package com.tutexp.tutexpblog.Model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class WpFeaturedmediaItem{

	@SerializedName("href")
	private String href;

	@SerializedName("embeddable")
	private boolean embeddable;

	public String getHref(){
		return href;
	}

	public boolean isEmbeddable(){
		return embeddable;
	}

	@Override
 	public String toString(){
		return 
			"WpFeaturedmediaItem{" + 
			"href = '" + href + '\'' + 
			",embeddable = '" + embeddable + '\'' + 
			"}";
		}
}