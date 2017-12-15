package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class AvatarUrls{

	@SerializedName("24")
	private String jsonMember24;

	@SerializedName("48")
	private String jsonMember48;

	@SerializedName("96")
	private String jsonMember96;

	public String getJsonMember24(){
		return jsonMember24;
	}

	public String getJsonMember48(){
		return jsonMember48;
	}

	public String getJsonMember96(){
		return jsonMember96;
	}

	@Override
 	public String toString(){
		return 
			"AvatarUrls{" + 
			"24 = '" + jsonMember24 + '\'' + 
			",48 = '" + jsonMember48 + '\'' + 
			",96 = '" + jsonMember96 + '\'' + 
			"}";
		}
}