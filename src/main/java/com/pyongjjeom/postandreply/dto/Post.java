/**'
 * 
 */

package com.pyongjjeom.postandreply.dto;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * <pre>
 * com.pyongjjeom.postandreply.dto 
 *    |_ Posting.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class Post {


	private String postCD = "";
	private String pmemCD = "";
	private String review = "";
	private float memGrade = 0.0f;
	private String comment = "";
	private char deleteYn = 'N';
	private char spoilYn = 'N';
	private Date regiDate ;
	private Date updateDate;
	private String conCD = "";
	
	private String title = ""; // 검색 제목
	private String link = ""; // 검색 link
	private String image = ""; // 썸네일 이미지
	private String director = ""; // 저자
	private String actor = ""; // 배우
	public String getPostCD() {
		return postCD;
	}
	public void setPostCD(String postCD) {
		this.postCD = postCD;
	}
	public String getPmemCD() {
		return pmemCD;
	}
	public void setPmemCD(String pmemCD) {
		this.pmemCD = pmemCD;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public float getMemGrade() {
		return memGrade;
	}
	public void setMemGrade(float memGrade) {
		this.memGrade = memGrade;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public char getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(char deleteYn) {
		this.deleteYn = deleteYn;
	}
	public char getSpoilYn() {
		return spoilYn;
	}
	public void setSpoilYn(char spoilYn) {
		this.spoilYn = spoilYn;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	
	
}

