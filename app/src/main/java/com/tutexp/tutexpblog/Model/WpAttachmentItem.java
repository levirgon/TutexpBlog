package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class WpAttachmentItem{

	@SerializedName("href")
	private String href;

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"WpAttachmentItem{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}