package com.tutexp.tutexpblog.Model;

import java.util.List;

public class Links{
	private List<WpPostTypeItem> wpPostType;
	private List<CuriesItem> curies;
	private List<AboutItem> about;
	private List<SelfItem> self;
	private List<CollectionItem> collection;

	public void setWpPostType(List<WpPostTypeItem> wpPostType){
		this.wpPostType = wpPostType;
	}

	public List<WpPostTypeItem> getWpPostType(){
		return wpPostType;
	}

	public void setCuries(List<CuriesItem> curies){
		this.curies = curies;
	}

	public List<CuriesItem> getCuries(){
		return curies;
	}

	public void setAbout(List<AboutItem> about){
		this.about = about;
	}

	public List<AboutItem> getAbout(){
		return about;
	}

	public void setSelf(List<SelfItem> self){
		this.self = self;
	}

	public List<SelfItem> getSelf(){
		return self;
	}

	public void setCollection(List<CollectionItem> collection){
		this.collection = collection;
	}

	public List<CollectionItem> getCollection(){
		return collection;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"wp:post_type = '" + wpPostType + '\'' + 
			",curies = '" + curies + '\'' + 
			",about = '" + about + '\'' + 
			",self = '" + self + '\'' + 
			",collection = '" + collection + '\'' + 
			"}";
		}
}