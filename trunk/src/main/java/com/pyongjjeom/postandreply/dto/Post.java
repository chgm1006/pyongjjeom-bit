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
public class Post {

	@Override
	public String toString() {
		return "Post [postCD=" + postCD + ", conCD=" + conCD + ", pmemCD=" + pmemCD + ", memGrade=" + memGrade
				+ ", comment=" + comment + ", deleteYn=" + deleteYn + ", spoilYn=" + spoilYn + ", regiDate=" + regiDate
				+ ", updateDate=" + updateDate + "]";
	}

	public void setMemGrade(Double memGrade) {
		this.memGrade = memGrade;
	}

	private String postCD = "";
	private String conCD = "";
	private String pmemCD = "";
	private Double memGrade = 0.0;
	private String comment = "";

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
