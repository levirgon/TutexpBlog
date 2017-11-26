package com.tutexp.tutexpblog.Model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class JetpackRelatedPostsItem{

	@SerializedName("date")
	private String date;

	@SerializedName("img")
	private Img img;

	@SerializedName("classes")
	private List<Object> classes;

	@SerializedName("format")
	private boolean format;

	@SerializedName("rel")
	private String rel;

	@SerializedName("context")
	private String context;

	@SerializedName("id")
	private int id;

	@SerializedName("url_meta")
	private UrlMeta urlMeta;

	@SerializedName("title")
	private String title;

	@SerializedName("excerpt")
	private String excerpt;

	@SerializedName("url")
	private String url;

	public String getDate(){
		return date;
	}

	public Img getImg(){
		return img;
	}

	public List<Object> getClasses(){
		return classes;
	}

	public boolean isFormat(){
		return format;
	}

	public String getRel(){
		return rel;
	}

	public String getContext(){
		return context;
	}

	public int getId(){
		return id;
	}

	public UrlMeta getUrlMeta(){
		return urlMeta;
	}

	public String getTitle(){
		return title;
	}

	public String getExcerpt(){
		return excerpt;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"JetpackRelatedPostsItem{" + 
			"date = '" + date + '\'' + 
			",img = '" + img + '\'' + 
			",classes = '" + classes + '\'' + 
			",format = '" + format + '\'' + 
			",rel = '" + rel + '\'' + 
			",context = '" + context + '\'' + 
			",id = '" + id + '\'' + 
			",url_meta = '" + urlMeta + '\'' + 
			",title = '" + title + '\'' + 
			",excerpt = '" + excerpt + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}