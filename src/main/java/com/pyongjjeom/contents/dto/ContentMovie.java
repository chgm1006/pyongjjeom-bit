/**
 * 
 */

package com.pyongjjeom.contents.dto;

import java.util.Date;

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
public class ContentMovie {

	private String conCD = "";
	private float naverMg = 0.0f;
	private float daumMg = 0.0f;
	private float lotteMg = 0.0f;
	private float cgvMg = 0.0f;
	private float megaboxMg = 0.0f;
	private float memMg = 0.0f;
	private String mainActor = "";
	private String subActor = "";
	private String releaseDate = "";
	private Date regiDate = null;
	private Date updateDate = null;

	public String getConCD() {
		return conCD;
	}

	public void setConCD(String conCD) {
		this.conCD = conCD;
	}

	public float getNaverMg() {
		return naverMg;
	}

	public void setNaverMg(float naverMg) {
		this.naverMg = naverMg;
	}

	public float getDaumMg() {
		return daumMg;
	}

	public void setDaumMg(float daumMg) {
		this.daumMg = daumMg;
	}

	public float getLotteMg() {
		return lotteMg;
	}

	public void setLotteMg(float lotteMg) {
		this.lotteMg = lotteMg;
	}

	public float getCgvMg() {
		return cgvMg;
	}

	public void setCgvMg(float cgvMg) {
		this.cgvMg = cgvMg;
	}

	public float getMegaboxMg() {
		return megaboxMg;
	}

	public void setMegaboxMg(float megaboxMg) {
		this.megaboxMg = megaboxMg;
	}

	public float getMemMg() {
		return memMg;
	}

	public void setMemMg(float memMg) {
		this.memMg = memMg;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
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
