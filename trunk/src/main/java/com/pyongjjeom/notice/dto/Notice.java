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


	private String title ="";
	private String person = "";
  private String password= "";
	private String issue = "";
	private Date regidate ;
	private Date updatedate;
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
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
}