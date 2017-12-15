package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Sizes{

	@SerializedName("thumbnail")
	private Thumbnail thumbnail;

	@SerializedName("themonic-thumbnail")
	private ThemonicThumbnail themonicThumbnail;

	@SerializedName("excerpt-thumbnail")
	private ExcerptThumbnail excerptThumbnail;

	@SerializedName("full")
	private Full full;

	public Thumbnail getThumbnail(){
		return thumbnail;
	}

	public ThemonicThumbnail getThemonicThumbnail(){
		return themonicThumbnail;
	}

	public ExcerptThumbnail getExcerptThumbnail(){
		return excerptThumbnail;
	}

	public Full getFull(){
		return full;
	}

	@Override
 	public String toString(){
		return 
			"Sizes{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",themonic-thumbnail = '" + themonicThumbnail + '\'' + 
			",excerpt-thumbnail = '" + excerptThumbnail + '\'' + 
			",full = '" + full + '\'' + 
			"}";
		}
}