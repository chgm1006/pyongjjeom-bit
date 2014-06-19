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

	private Logger log = Logger.getLogger(this.getClass());

	private String postCD = "";
	private String pmemCD = "";
	private String conCD = "";
	private String review = "";
	private float memGrade = 0.0f;
	private String comment = "";
	private char deleteYn = 'n';
	private char spoilYn = 'n';
	private Date regiDate = null;
	private Date updateDate = null;

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

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

	public String getConCD() {
		return conCD;
	}

	public void setConCD(String conCD) {
		this.conCD = conCD;
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

}
