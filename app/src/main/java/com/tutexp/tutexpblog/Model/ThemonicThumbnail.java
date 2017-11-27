package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ThemonicThumbnail{

	@SerializedName("file")
	private String file;

	@SerializedName("mime_type")
	private String mimeType;

	@SerializedName("width")
	private int width;

	@SerializedName("source_url")
	private String sourceUrl;

	@SerializedName("height")
	private int height;

	public String getFile(){
		return file;
	}

	public String getMimeType(){
		return mimeType;
	}

	public int getWidth(){
		return width;
	}

	public String getSourceUrl(){
		return sourceUrl;
	}

	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"ThemonicThumbnail{" + 
			"file = '" + file + '\'' + 
			",mime_type = '" + mimeType + '\'' + 
			",width = '" + width + '\'' + 
			",source_url = '" + sourceUrl + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}