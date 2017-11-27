package com.tutexp.tutexpblog.Model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ImageContainerObject{

	@SerializedName("date")
	private String date;

	@SerializedName("template")
	private String template;

	@SerializedName("_links")
	private Links links;

	@SerializedName("link")
	private String link;

	@SerializedName("description")
	private Description description;

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

	@SerializedName("post")
	private int post;

	@SerializedName("alt_text")
	private String altText;

	@SerializedName("media_type")
	private String mediaType;

	@SerializedName("modified")
	private String modified;

	@SerializedName("id")
	private int id;

	@SerializedName("date_gmt")
	private String dateGmt;

	@SerializedName("slug")
	private String slug;

	@SerializedName("modified_gmt")
	private String modifiedGmt;

	@SerializedName("author")
	private int author;

	@SerializedName("comment_status")
	private String commentStatus;

	@SerializedName("ping_status")
	private String pingStatus;

	@SerializedName("mime_type")
	private String mimeType;

	@SerializedName("meta")
	private List<Object> meta;

	@SerializedName("guid")
	private Guid guid;

	@SerializedName("status")
	private String status;

	public String getDate(){
		return date;
	}

	public String getTemplate(){
		return template;
	}

	public Links getLinks(){
		return links;
	}

	public String getLink(){
		return link;
	}

	public Description getDescription(){
		return description;
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

	public int getPost(){
		return post;
	}

	public String getAltText(){
		return altText;
	}

	public String getMediaType(){
		return mediaType;
	}

	public String getModified(){
		return modified;
	}

	public int getId(){
		return id;
	}

	public String getDateGmt(){
		return dateGmt;
	}

	public String getSlug(){
		return slug;
	}

	public String getModifiedGmt(){
		return modifiedGmt;
	}

	public int getAuthor(){
		return author;
	}

	public String getCommentStatus(){
		return commentStatus;
	}

	public String getPingStatus(){
		return pingStatus;
	}

	public String getMimeType(){
		return mimeType;
	}

	public List<Object> getMeta(){
		return meta;
	}

	public Guid getGuid(){
		return guid;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ImageContainerObject{" + 
			"date = '" + date + '\'' + 
			",template = '" + template + '\'' + 
			",_links = '" + links + '\'' + 
			",link = '" + link + '\'' + 
			",description = '" + description + '\'' + 
			",caption = '" + caption + '\'' + 
			",type = '" + type + '\'' + 
			",title = '" + title + '\'' + 
			",media_details = '" + mediaDetails + '\'' + 
			",source_url = '" + sourceUrl + '\'' + 
			",post = '" + post + '\'' + 
			",alt_text = '" + altText + '\'' + 
			",media_type = '" + mediaType + '\'' + 
			",modified = '" + modified + '\'' + 
			",id = '" + id + '\'' + 
			",date_gmt = '" + dateGmt + '\'' + 
			",slug = '" + slug + '\'' + 
			",modified_gmt = '" + modifiedGmt + '\'' + 
			",author = '" + author + '\'' + 
			",comment_status = '" + commentStatus + '\'' + 
			",ping_status = '" + pingStatus + '\'' + 
			",mime_type = '" + mimeType + '\'' + 
			",meta = '" + meta + '\'' + 
			",guid = '" + guid + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}