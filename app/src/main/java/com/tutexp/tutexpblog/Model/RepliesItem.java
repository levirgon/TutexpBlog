package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class RepliesItem{

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
			"RepliesItem{" + 
			"href = '" + href + '\'' + 
			",embeddable = '" + embeddable + '\'' + 
			"}";
		}
}