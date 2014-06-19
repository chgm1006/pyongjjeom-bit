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
public class ContentConcert {

	private Logger log = Logger.getLogger(this.getClass());

	private String conCD = "";
	private float yesCg = 0.0f;
	private float interCg = 0.0f;
	private float auctCg = 0.0f;
	private float playCg = 0.0f;
	private float memCg = 0.0f;
	private String mainActor = "";
	private String subActor = "";
	private String startDate = "";
	private String endDate = "";
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

	public float getYesCg() {
		return yesCg;
	}

	public void setYesCg(float yesCg) {
		this.yesCg = yesCg;
	}

	public float getInterCg() {
		return interCg;
	}

	public void setInterCg(float interCg) {
		this.interCg = interCg;
	}

	public float getAuctCg() {
		return auctCg;
	}

	public void setAuctCg(float auctCg) {
		this.auctCg = auctCg;
	}

	public float getPlayCg() {
		return playCg;
	}

	public void setPlayCg(float playCg) {
		this.playCg = playCg;
	}

	public float getMemCg() {
		return memCg;
	}

	public void setMemCg(float memCg) {
		this.memCg = memCg;
	}

	public String getMainActor() {
		return mainActor;
	}

	public void setMainActor(String mainActor) {
		this.mainActor = mainActor;
	}

	public String getSubActor() {
		return subActor;
	}

	public void setSubActor(String subActor) {
		this.subActor = subActor;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
