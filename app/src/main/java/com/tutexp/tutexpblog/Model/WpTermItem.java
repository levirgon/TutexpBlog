package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class WpTermItem{

	@SerializedName("taxonomy")
	private String taxonomy;

	@SerializedName("href")
	private String href;

	@SerializedName("embeddable")
	private boolean embeddable;

	public String getTaxonomy(){
		return taxonomy;
	}

	public String getHref(){
		return href;
	}

	public boolean isEmbeddable(){
		return embeddable;
	}

	@Override
 	public String toString(){
		return 
			"WpTermItem{" + 
			"taxonomy = '" + taxonomy + '\'' + 
			",href = '" + href + '\'' + 
			",embeddable = '" + embeddable + '\'' + 
			"}";
		}
}