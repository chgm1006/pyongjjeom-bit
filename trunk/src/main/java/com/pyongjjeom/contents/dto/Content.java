/**
 * 
 */

package com.pyongjjeom.contents.dto;

import java.util.Date;


/**
 * <pre>
 * com.pyongjjeom.contents.dto 
 *    |_ Contents.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class Content {


	// Content 공통 필드
	private String conCD = "";
	private String title = "";
	private String director = "";
	private String image= "";
	private String link = "";
	public String getConCD() {
		return conCD;
	}
	public void setConCD(String conCD) {
		this.conCD = conCD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	@Override
	public String toString() {
		return "Content [conCD=" + conCD + ", title=" + title + ", director="
				+ director + ", image=" + image + ", link=" + link + ", actor=" + actor
				+ "]";
	}
	private String actor = "";


}
