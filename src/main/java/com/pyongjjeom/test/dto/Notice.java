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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((issue == null) ? 0 : issue.hashCode());
		result = prime * result + ((notcd == null) ? 0 : notcd.hashCode());
		result = prime * result + password;
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notice other = (Notice) obj;
		if (issue == null) {
			if (other.issue != null)
				return false;
		} else if (!issue.equals(other.issue))
			return false;
		if (notcd == null) {
			if (other.notcd != null)
				return false;
		} else if (!notcd.equals(other.notcd))
			return false;
		if (password != other.password)
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Notice [notcd=" + notcd + ", title=" + title + ", person=" + person
				+ ", password=" + password + ", issue=" + issue + "]";
	}
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
	private String title;
	private String person;
	private int password;
	private String issue;

	

}
