package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class WpTermItemItem{

	@SerializedName("_links")
	private Links links;

	@SerializedName("link")
	private String link;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("taxonomy")
	private String taxonomy;

	@SerializedName("slug")
	private String slug;

	public Links getLinks(){
		return links;
	}

	public String getLink(){
		return link;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getTaxonomy(){
		return taxonomy;
	}

	public String getSlug(){
		return slug;
	}

	@Override
 	public String toString(){
		return 
			"WpTermItemItem{" + 
			"_links = '" + links + '\'' + 
			",link = '" + link + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",taxonomy = '" + taxonomy + '\'' + 
			",slug = '" + slug + '\'' + 
			"}";
		}
}