/**
 * 
 */

package com.pyongjjeom.contents.dto;

import java.util.Date;


/**
 * <pre>
 * com.pyongjjeom.contents.dto 
 *    |_ Contents.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class Content {


	// Content 공통 필드
	private String conCD = "";
	private String title = "";
	private String subTitle = "";
	private String director = "";
	private String synopsis = "";
	private String genre = "";

	// Book 관련 필드
	private float gyoboBg = 0.0f;
	private float bandiBg = 0.0f;
	private float yesBg = 0.0f;
	private float aladinBg = 0.0f;
	private float naverBg = 0.0f;
	private float memBg = 0.0f;
	private String publisher = "";
	private String publishDate = "";

	// Concert 관련 필드
	private float yesCg = 0.0f;
	private float interCg = 0.0f;
	private float auctCg = 0.0f;
	private float playCg = 0.0f;
	private float memCg = 0.0f;
	private String startDate = "";
	private String endDate = "";

	// Movie 관련 필드
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
