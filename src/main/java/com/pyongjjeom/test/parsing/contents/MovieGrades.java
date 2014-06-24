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
package com.pyongjjeom.test.parsing.contents; 

import org.apache.log4j.Logger;

/**
 * <pre>
 * com.pyongjjeom.test.parsing.contents 
 *    |_ ContentsGrades.java
 * 
 * </pre>
 * @date : 2014. 6. 24. 오전 9:51:06
 * @version : 
 * @author : Administrator
 */
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

public class MovieGrades {

	private Logger log = Logger.getLogger(this.getClass());
	private String title;
	private double naverMg;
	private double daumMg;
	private double cgvMg;
	private double lotteMg;
	private double megaBoxMg;
	@Override
	public String toString() {
		return "MovieGrades [log=" + log + ", title=" + title + ", naverMg="
				+ naverMg + ", daumMg=" + daumMg + ", cgvMg=" + cgvMg + ", lotteMg="
				+ lotteMg + ", megaBoxMg=" + megaBoxMg + "]";
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
	public double getNaverMg() {
		return naverMg;
	}
	public void setNaverMg(double naverMg) {
		this.naverMg = naverMg;
	}
	public double getDaumMg() {
		return daumMg;
	}
	public void setDaumMg(double daumMg) {
		this.daumMg = daumMg;
	}
	public double getCgvMg() {
		return cgvMg;
	}
	public void setCgvMg(double cgvMg) {
		this.cgvMg = cgvMg;
	}
	public double getLotteMg() {
		return lotteMg;
	}
	public void setLotteMg(double lotteMg) {
		this.lotteMg = lotteMg;
	}
	public double getMegaBoxMg() {
		return megaBoxMg;
	}
	public void setMegaBoxMg(double megaBoxMg) {
		this.megaBoxMg = megaBoxMg;
	}
	
	
}
