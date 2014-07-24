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
	private String memCD = "";
	private String memNm = "";
	private String imgPath = "";
	private String reply = "";
	private char spoilYn = 'n';
	private Date updateDate = null;
	private String formatUpdateDate = "";
	private String postCD = "";

	/**
	 * Comment :
	 * 
	 * @return the postCD
	 */
	public String getPostCD() {
		return postCD;
	}

	/**
	 * Comment :
	 * 
	 * @parameters postCD the postCD to set
	 */
	public void setPostCD(String postCD) {
		this.postCD = postCD;
	}

	public String getMemNm() {
		return memNm;
	}

	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}

	public String getReplyCD() {
		return replyCD;
	}

	public void setReplyCD(String replyCD) {
		this.replyCD = replyCD;
	}

	public String getMemCD() {
		return memCD;
	}

	public void setMemCD(String memCD) {
		this.memCD = memCD;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public char getSpoilYn() {
		return spoilYn;
	}

	public void setSpoilYn(char spoilYn) {
		this.spoilYn = spoilYn;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getFormatUpdateDate() {
		return formatUpdateDate;
	}

	public void setFormatUpdateDate(String formatUpdateDate) {
		this.formatUpdateDate = formatUpdateDate;
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 :
	 * </PRE>
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reply [postCD=" + postCD + ", replyCD=" + replyCD + ", memCD="
				+ memCD + ", memNm=" + memNm + ", imgPath=" + imgPath + ", reply="
				+ reply + ", spoilYn=" + spoilYn + ", updateDate=" + updateDate
				+ ", formatUpdateDate=" + formatUpdateDate + "]";
	}
}
