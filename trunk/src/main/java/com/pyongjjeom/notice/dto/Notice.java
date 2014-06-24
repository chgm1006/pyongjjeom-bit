/**
 * 
 */

package com.pyongjjeom.notice.dto;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * <pre>
 * com.pyongjjeom.notice.dto 
 *    |_ Notice.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class Notice {

	private Logger log = Logger.getLogger(this.getClass());

	private String notCD = "";
	private String title ="";
	private String person = "";
  private String password= "";
	private String issue = "";
	private String category = "";
	private String permit = "";
	private char deleteYn = 'n';
	private Date regiDate = null;
	private Date updateDate = null;

	
	
	public String getNotCD() {
		return notCD;
	}
	public void setNotCD(String notCD) {
		this.notCD = notCD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public char getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(char deleteYn) {
		this.deleteYn = deleteYn;
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

