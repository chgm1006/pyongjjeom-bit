/**
 * 0. Project  : XXXX 프로젝트
 *
 * 1. FileName : ContentsGrades.java
 * 2. Package : com.pyongjjeom.test.parsing.contents
 * 3. Comment : 
 * 4. 작성자  : Administrator
 * 5. 작성일  : 2014. 6. 24. 
 * 6. 변경이력 : 
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    Administrator : 2014. 6. 24. :            : 신규 개발.
 */

/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.pyongjjeom.contents.parsing.common; 

import org.apache.log4j.Logger;

/**
 * <pre>
 * 간략 : DB에서 받아온 평점들을 저장하는 DTO
 * 상세 : 
 * com.pyongjjeom.test.parsing.contents
 *   |_ ContentsGrades.java
 * </pre>
 * 
 * @author  : Administrator
 * @version : 1.0
 */

public class BookGrades {

	private Logger log = Logger.getLogger(this.getClass());
	private String title;
	private double naverBg;
	private double aladinBg;
	private double bandiBg;
	private double kyoboBg;
	private double yesBg;
	private String bookCode;
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	@Override
	public String toString() {
		return "BookGrades [log=" + log + ", title=" + title + ", naverBg="
				+ naverBg + ", aladinBg=" + aladinBg + ", bandiBg=" + bandiBg
				+ ", kyoboBg=" + kyoboBg + ", yesBg=" + yesBg + "]";
	}
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getNaverBg() {
		return naverBg;
	}
	public void setNaverBg(double naverBg) {
		this.naverBg = naverBg;
	}
	public double getAladinBg() {
		return aladinBg;
	}
	public void setAladinBg(double aladinBg) {
		this.aladinBg = aladinBg;
	}
	public double getBandiBg() {
		return bandiBg;
	}
	public void setBandiBg(double bandiBg) {
		this.bandiBg = bandiBg;
	}
	public double getKyoboBg() {
		return kyoboBg;
	}
	public void setKyoboBg(double kyoboBg) {
		this.kyoboBg = kyoboBg;
	}
	public double getYesBg() {
		return yesBg;
	}
	public void setYesBg(double yesBg) {
		this.yesBg = yesBg;
	}
	
}