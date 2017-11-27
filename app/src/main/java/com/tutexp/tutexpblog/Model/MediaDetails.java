package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class MediaDetails{

	@SerializedName("file")
	private String file;

	@SerializedName("sizes")
	private Sizes sizes;

	@SerializedName("image_meta")
	private ImageMeta imageMeta;

	@SerializedName("width")
	private int width;

	@SerializedName("height")
	private int height;

	public String getFile(){
		return file;
	}

	public Sizes getSizes(){
		return sizes;
	}

	public ImageMeta getImageMeta(){
		return imageMeta;
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
			"MediaDetails{" + 
			"file = '" + file + '\'' + 
			",sizes = '" + sizes + '\'' + 
			",image_meta = '" + imageMeta + '\'' + 
			",width = '" + width + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}