package com.pyongjjeom.common;

public class NaverMovie {
	private String title = ""; // 영화 제목
	private String link = ""; // link
	private String image = ""; // 썸네일 이미지
	private String poster = ""; // 포스터 이미지
	private String subtitle = ""; // 영문 제목
	private String pubDate = ""; // 제작년도
	private String director = ""; // 감독
	private String conCD = ""; 
	private String actor = ""; // 출연 배우
	private String userRating = ""; // 유저 평점


	public String getConCD() {
		return conCD;
	}

	public void setConCD(String conCD) {
		this.conCD = conCD;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getUserRating() {
		return userRating;
	}

	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}

	@Override
	public String toString() {
		return "NaverMovie [title=" + title + ", link=" + link + ", image=" + image
				+ ", poster=" + poster + ", subtitle=" + subtitle + ", pubDate="
				+ pubDate + ", director=" + director + ", code=" + conCD + ", actor="
				+ actor + ", userRating=" + userRating + "]";
	}

}
