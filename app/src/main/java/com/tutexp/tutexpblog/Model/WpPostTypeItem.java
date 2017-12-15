package com.tutexp.tutexpblog.Model;

public class WpPostTypeItem{
	private String href;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"WpPostTypeItem{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}
