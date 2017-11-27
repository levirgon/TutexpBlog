package com.tutexp.tutexpblog.Model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ImageMeta{

	@SerializedName("aperture")
	private String aperture;

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("orientation")
	private String orientation;

	@SerializedName("focal_length")
	private String focalLength;

	@SerializedName("iso")
	private String iso;

	@SerializedName("keywords")
	private List<Object> keywords;

	@SerializedName("caption")
	private String caption;

	@SerializedName("created_timestamp")
	private String createdTimestamp;

	@SerializedName("credit")
	private String credit;

	@SerializedName("camera")
	private String camera;

	@SerializedName("title")
	private String title;

	@SerializedName("shutter_speed")
	private String shutterSpeed;

	public String getAperture(){
		return aperture;
	}

	public String getCopyright(){
		return copyright;
	}

	public String getOrientation(){
		return orientation;
	}

	public String getFocalLength(){
		return focalLength;
	}

	public String getIso(){
		return iso;
	}

	public List<Object> getKeywords(){
		return keywords;
	}

	public String getCaption(){
		return caption;
	}

	public String getCreatedTimestamp(){
		return createdTimestamp;
	}

	public String getCredit(){
		return credit;
	}

	public String getCamera(){
		return camera;
	}

	public String getTitle(){
		return title;
	}

	public String getShutterSpeed(){
		return shutterSpeed;
	}

	@Override
 	public String toString(){
		return 
			"ImageMeta{" + 
			"aperture = '" + aperture + '\'' + 
			",copyright = '" + copyright + '\'' + 
			",orientation = '" + orientation + '\'' + 
			",focal_length = '" + focalLength + '\'' + 
			",iso = '" + iso + '\'' + 
			",keywords = '" + keywords + '\'' + 
			",caption = '" + caption + '\'' + 
			",created_timestamp = '" + createdTimestamp + '\'' + 
			",credit = '" + credit + '\'' + 
			",camera = '" + camera + '\'' + 
			",title = '" + title + '\'' + 
			",shutter_speed = '" + shutterSpeed + '\'' + 
			"}";
		}
}