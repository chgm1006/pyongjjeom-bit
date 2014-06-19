/**
 * 
 */

package com.pyongjjeom.contents.dto;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * <pre>
 * Content dto로 통합 하였습니다. <br>
 * 특별한 경우가 아니면 사용되지 않을 것입니다.
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class ContentBook {

	private Logger log = Logger.getLogger(this.getClass());

	private String conCD = "";
	private float gyoboBg = 0.0f;
	private float bandiBg = 0.0f;
	private float yesBg = 0.0f;
	private float aladinBg = 0.0f;
	private float naverBg = 0.0f;
	private float memBg = 0.0f;
	private String publisher = "";
	private String publishDate = "";
	private Date updateDate = null;

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public String getConCD() {
		return conCD;
	}

	public void setConCD(String conCD) {
		this.conCD = conCD;
	}

	public float getGyoboBg() {
		return gyoboBg;
	}

	public void setGyoboBg(float gyoboBg) {
		this.gyoboBg = gyoboBg;
	}

	public float getBandiBg() {
		return bandiBg;
	}

	public void setBandiBg(float bandiBg) {
		this.bandiBg = bandiBg;
	}

	public float getYesBg() {
		return yesBg;
	}

	public void setYesBg(float yesBg) {
		this.yesBg = yesBg;
	}

	public float getAladinBg() {
		return aladinBg;
	}

	public void setAladinBg(float aladinBg) {
		this.aladinBg = aladinBg;
	}

	public float getNaverBg() {
		return naverBg;
	}

	public void setNaverBg(float naverBg) {
		this.naverBg = naverBg;
	}

	public float getMemBg() {
		return memBg;
	}

	public void setMemBg(float memBg) {
		this.memBg = memBg;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
