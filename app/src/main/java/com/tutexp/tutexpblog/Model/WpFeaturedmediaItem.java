package com.tutexp.tutexpblog.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class WpFeaturedmediaItem{

	@SerializedName("date")
	private String date;

	@SerializedName("_links")
	private Links links;

	@SerializedName("author")
	private int author;

	@SerializedName("link")
	private String link;

	@SerializedName("caption")
	private Caption caption;

	@SerializedName("type")
	private String type;

	@SerializedName("title")
	private Title title;

	@SerializedName("media_details")
	private MediaDetails mediaDetails;

	@SerializedName("source_url")
	private String sourceUrl;

	@SerializedName("alt_text")
	private String altText;

	@SerializedName("media_type")
	private String mediaType;

	@SerializedName("mime_type")
	private String mimeType;

	@SerializedName("id")
	private int id;

	@SerializedName("slug")
	private String slug;

	public String getDate(){
		return date;
	}

	public Links getLinks(){
		return links;
	}

	public int getAuthor(){
		return author;
	}

	public String getLink(){
		return link;
	}

	public Caption getCaption(){
		return caption;
	}

	public String getType(){
		return type;
	}

	public Title getTitle(){
		return title;
	}

	public MediaDetails getMediaDetails(){
		return mediaDetails;
	}

	public String getSourceUrl(){
		return sourceUrl;
	}

	public String getAltText(){
		return altText;
	}

	public String getMediaType(){
		return mediaType;
	}

	public String getMimeType(){
		return mimeType;
	}

	public int getId(){
		return id;
	}

	public String getSlug(){
		return slug;
	}

	@Override
 	public String toString(){
		return 
			"WpFeaturedmediaItem{" + 
			"date = '" + date + '\'' + 
			",_links = '" + links + '\'' + 
			",author = '" + author + '\'' + 
			",link = '" + link + '\'' + 
			",caption = '" + caption + '\'' + 
			",type = '" + type + '\'' + 
			",title = '" + title + '\'' + 
			",media_details = '" + mediaDetails + '\'' + 
			",source_url = '" + sourceUrl + '\'' + 
			",alt_text = '" + altText + '\'' + 
			",media_type = '" + mediaType + '\'' + 
			",mime_type = '" + mimeType + '\'' + 
			",id = '" + id + '\'' + 
			",slug = '" + slug + '\'' + 
			"}";
		}
}