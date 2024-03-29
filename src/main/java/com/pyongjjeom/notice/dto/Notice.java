/**
 * 
 */

package com.pyongjjeom.notice.dto;

import java.util.Date;

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
	private String regidateStr = "";
	private Date regidate;
	private Date updatedate;
	private String formatUpdatedate;

	public String getFormatUpdatedate() {
		return formatUpdatedate;
	}

	public void setFormatUpdatedate(String formatUpdatedate) {
		this.formatUpdatedate = formatUpdatedate;
	}

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

	public String getRegidateStr() {
		return regidateStr;
	}

	public void setRegidateStr(String regidateStr) {
		this.regidateStr = regidateStr;
	}

	@Override
	public String toString() {
		return "Notice [notCD=" + notCD + ", writer=" + writer + ", title=" + title + ", issue=" + issue + ", category="
				+ category + ", permit=" + permit + ", notPasswd=" + notPasswd + ", deleteYN=" + deleteYN + ", regidate="
				+ regidate + ", updatedate=" + updatedate + "]";
	}

}