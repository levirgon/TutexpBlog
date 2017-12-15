package com.tutexp.tutexpblog.Model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Embedded{

	@SerializedName("author")
	private List<AuthorItem> author;

	@SerializedName("wp:term")
	private List<List<WpTermItemItem>> wpTerm;

	@SerializedName("wp:featuredmedia")
	private List<WpFeaturedmediaItem> wpFeaturedmedia;

	public List<AuthorItem> getAuthor(){
		return author;
	}

	public List<List<WpTermItemItem>> getWpTerm(){
		return wpTerm;
	}

	public List<WpFeaturedmediaItem> getWpFeaturedmedia(){
		return wpFeaturedmedia;
	}

	@Override
 	public String toString(){
		return 
			"Embedded{" + 
			"author = '" + author + '\'' + 
			",wp:term = '" + wpTerm + '\'' + 
			",wp:featuredmedia = '" + wpFeaturedmedia + '\'' + 
			"}";
		}
}