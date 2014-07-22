/**'
 * 
 */

package com.pyongjjeom.postandreply.dto;

import java.util.Date;


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
public class PostAndContents {


	private String postCD = "";
	private String conCD = "";
	private String pmemCD = "";
	private String review = "";
	private Double memGrade = 0.0;
	private int memGradeInt ;

	/**
	 * Comment   : 
	 * @return the memGradeInt
	 */
	public int getMemGradeInt() {
		return memGradeInt;
	}

	/**
	 * Comment   : 
	 * @parameters memGradeInt the memGradeInt to set
	 */
	public void setMemGradeInt(int memGradeInt) {
		this.memGradeInt = memGradeInt;
	}

	public void setMemGrade(Double memGrade) {
		this.memGrade = memGrade;
	}

	private String comment = "";
	private String title = "";
	private String image = "";
	private String link = "";
	private String director = "";
	private String actor = "";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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


	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PostAndContents [postCD=" + postCD + ", conCD=" + conCD
				+ ", pmemCD=" + pmemCD + ", review=" + review + ", memGrade="
				+ memGrade + ", memGradeInt=" + memGradeInt + ", comment=" + comment
				+ ", title=" + title + ", image=" + image + ", link=" + link
				+ ", director=" + director + ", actor=" + actor + ", deleteYn="
				+ deleteYn + ", spoilYn=" + spoilYn + ", regiDate=" + regiDate
				+ ", updateDate=" + updateDate + "]";
	}

	public void setLink(String link) {
		this.link = link;
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

	public String getConCD() {
		return conCD;
	}

	public void setConCD(String conCD) {
		this.conCD = conCD;
	}

	private char deleteYn = 'N';
	private char spoilYn = 'N';
	private Date regiDate;
	private Date updateDate;

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

	public double getMemGrade() {
		return memGrade;
	}

	public void setMemGrade(double memGrade) {
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
}
