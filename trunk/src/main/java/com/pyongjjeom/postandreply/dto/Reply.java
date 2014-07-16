/**
 * 
 */

package com.pyongjjeom.postandreply.dto;

import java.util.Date;


/**
 * <pre>
 * com.pyongjjeom.postandreply.dto 
 *    |_ Reply.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class Reply {

	private String replyCD = "";
	private String postCD = "";
	private String conCD = "";
	private String memCD = "";
	private char deleteYn = 'n';
	private char spoilYn = 'n';
	private Date regiDate = null;
	private Date updateDate = null;



	public String getReplyCD() {
		return replyCD;
	}

	public void setReplyCD(String replyCD) {
		this.replyCD = replyCD;
	}

	public String getPostCD() {
		return postCD;
	}

	public void setPostCD(String postCD) {
		this.postCD = postCD;
	}

	public String getConCD() {
		return conCD;
	}

	public void setConCD(String conCD) {
		this.conCD = conCD;
	}

	public String getMemCD() {
		return memCD;
	}

	public void setMemCD(String memCD) {
		this.memCD = memCD;
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
