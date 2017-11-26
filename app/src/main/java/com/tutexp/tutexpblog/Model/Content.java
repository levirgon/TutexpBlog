package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Content{

	@SerializedName("rendered")
	private String rendered;

	@SerializedName("protected")
	private boolean jsonMemberProtected;

	public String getRendered(){
		return rendered;
	}

	public boolean isJsonMemberProtected(){
		return jsonMemberProtected;
	}

	@Override
 	public String toString(){
		return 
			"Content{" + 
			"rendered = '" + rendered + '\'' + 
			",protected = '" + jsonMemberProtected + '\'' + 
			"}";
		}
}