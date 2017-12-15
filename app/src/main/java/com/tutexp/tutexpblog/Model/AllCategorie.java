package com.tutexp.tutexpblog.Model;

import java.util.List;

public class AllCategorie{
	private int parent;
	private Links links;
	private List<Object> meta;
	private int count;
	private String link;
	private String name;
	private String description;
	private int id;
	private String taxonomy;
	private String slug;

	public void setParent(int parent){
		this.parent = parent;
	}

	public int getParent(){
		return parent;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setMeta(List<Object> meta){
		this.meta = meta;
	}

	public List<Object> getMeta(){
		return meta;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTaxonomy(String taxonomy){
		this.taxonomy = taxonomy;
	}

	public String getTaxonomy(){
		return taxonomy;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	@Override
 	public String toString(){
		return 
			"AllCategorie{" + 
			"parent = '" + parent + '\'' + 
			",_links = '" + links + '\'' + 
			",meta = '" + meta + '\'' + 
			",count = '" + count + '\'' + 
			",link = '" + link + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",taxonomy = '" + taxonomy + '\'' + 
			",slug = '" + slug + '\'' + 
			"}";
		}
}