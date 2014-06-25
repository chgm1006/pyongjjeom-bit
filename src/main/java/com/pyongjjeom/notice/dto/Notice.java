/**
 * 
 */

package com.pyongjjeom.notice.dto;

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

	private String notCD = "";
	private String writer = "";
	private String title = "";
	private String issue = "";
	private String category = "";
	private String permit = "";
	private String notPasswd = "";
	private String deleteYN = "";
	private String regidate;
	private String updatedate;

	public String getNotCD() {
		return notCD;
	}

	public void setNotCD(String notCD) {
		this.notCD = notCD;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getNotPasswd() {
		return notPasswd;
	}

	public void setNotPasswd(String notPasswd) {
		this.notPasswd = notPasswd;
	}

	public String getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(String deleteYN) {
		this.deleteYN = deleteYN;
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

}