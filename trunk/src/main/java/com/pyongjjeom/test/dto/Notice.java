/**
 * 0. Project  : XXXX 프로젝트
 *
 * 1. FileName : Notice.java
 * 2. Package : com.pyongjjeom.test.dto
 * 3. Comment : 
 * 4. 작성자  : Kimyt
 * 5. 작성일  : 2014. 6. 20. 
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    Kimyt : 2014. 6. 20. :            : 신규 개발.
 */

/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.pyongjjeom.test.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class Notice implements Serializable {

	private Logger log = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 237654222L;

	private String notcd;
	private String title;
	private String person;
	private int password;
	private String issue;

	public String getNotcd() {
		return notcd;
	}

	public void setNotcd(String notcd) {
		this.notcd = notcd;
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

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

}
