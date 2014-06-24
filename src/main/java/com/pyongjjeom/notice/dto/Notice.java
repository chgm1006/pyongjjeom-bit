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
	public String getRegidate() {
		return regidate;
	}
	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	private String regidate ;
	private String updatedate;


}