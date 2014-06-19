/**
 * 
 */

package com.pyongjjeom.friends.dto;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * <pre>
 * com.pyongjjeom.friends.dto 
 *    |_ Friends.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class Friends {

	private Logger log = Logger.getLogger(this.getClass());

	private String friendSEQ = "";
	private String memCD = "";
	private String friendCD = "";
	private String friendType = "";
	private Date regiDate = null;
	private Date updateDate = null;

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public String getFriendSEQ() {
		return friendSEQ;
	}

	public void setFriendSEQ(String friendSEQ) {
		this.friendSEQ = friendSEQ;
	}

	public String getMemCD() {
		return memCD;
	}

	public void setMemCD(String memCD) {
		this.memCD = memCD;
	}

	public String getFriendCD() {
		return friendCD;
	}

	public void setFriendCD(String friendCD) {
		this.friendCD = friendCD;
	}

	public String getFriendType() {
		return friendType;
	}

	public void setFriendType(String friendType) {
		this.friendType = friendType;
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
