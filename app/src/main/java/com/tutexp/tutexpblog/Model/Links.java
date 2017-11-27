package com.tutexp.tutexpblog.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Links{

	@SerializedName("replies")
	private List<RepliesItem> replies;

	@SerializedName("author")
	private List<AuthorItem> author;

	@SerializedName("wp:featuredmedia")
	private List<WpFeaturedmediaItem> featuredmediaItems;

	@SerializedName("about")
	private List<AboutItem> about;

	@SerializedName("self")
	private List<SelfItem> self;

	@SerializedName("collection")
	private List<CollectionItem> collection;

	public List<RepliesItem> getReplies(){
		return replies;
	}

	public List<WpFeaturedmediaItem> getWpFeaturedMediaItem(){
		return featuredmediaItems;
	}



	public List<AuthorItem> getAuthor(){
		return author;
	}

	public List<AboutItem> getAbout(){
		return about;
	}

	public List<SelfItem> getSelf(){
		return self;
	}

	public List<CollectionItem> getCollection(){
		return collection;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"replies = '" + replies + '\'' + 
			",author = '" + author + '\'' + 
			",about = '" + about + '\'' + 
			",self = '" + self + '\'' + 
			",collection = '" + collection + '\'' + 
			"}";
		}
}