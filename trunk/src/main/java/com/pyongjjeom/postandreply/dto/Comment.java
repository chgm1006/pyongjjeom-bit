/**
 * 0. Project  : XXXX 프로젝트
 *
 * 1. FileName : Comment.java
 * 2. Package : com.pyongjjeom.postandreply.dto
 * 3. Comment : 
 * 4. 작성자  : Administrator
 * 5. 작성일  : 2014. 7. 14. 
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    Administrator : 2014. 7. 14. :            : 신규 개발.
 */

/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.pyongjjeom.postandreply.dto; 

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * <pre>
 * com.pyongjjeom.postandreply.dto 
 *    |_ Comment.java
 * 
 * </pre>
 * @date : 2014. 7. 14. 오후 7:35:17
 * @version : 
 * @author : Administrator
 */
/**
 * <pre>
 * 간략 : 
 * 상세 : 
 * com.pyongjjeom.postandreply.dto
 *   |_ Comment.java
 * </pre>
 * 
 * @author  : Administrator
 * @version : 1.0
 */

public class Comment {

	private String Comment;
	private String memGrade;
	private Date updateDate;
	private String formatUpdateDate;
	public String getFormatUpdateDate() {
		return formatUpdateDate;
	}
	public void setFormatUpdateDate(String formatUpdateDate) {
		this.formatUpdateDate = formatUpdateDate;
	}
	private String memNm;
	private String imgPath;
	@Override
	public String toString() {
		return "Comment [Comment=" + Comment + ", memGrade=" + memGrade
				+ ", updateDate=" + updateDate + ", formatUpdateDate="
				+ formatUpdateDate + ", memNm=" + memNm + ", imgPath=" + imgPath + "]";
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public String getMemGrade() {
		return memGrade;
	}
	public void setMemGrade(String memGrade) {
		this.memGrade = memGrade;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getMemNm() {
		return memNm;
	}
	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
