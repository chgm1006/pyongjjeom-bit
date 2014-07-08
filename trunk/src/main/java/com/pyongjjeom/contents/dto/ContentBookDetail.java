/**
 * 
 */

package com.pyongjjeom.contents.dto;



public class ContentBookDetail {


	private String bookIntroContent;
	private String authorIntroContent;
	private String poster;
	public String getBookIntroContent() {
		return bookIntroContent;
	}
	public void setBookIntroContent(String bookIntroContent) {
		this.bookIntroContent = bookIntroContent;
	}
	public String getAuthorIntroContent() {
		return authorIntroContent;
	}
	public void setAuthorIntroContent(String authorIntroContent) {
		this.authorIntroContent = authorIntroContent;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	@Override
	public String toString() {
		return "ContentBookDetail [bookIntroContent=" + bookIntroContent
				+ ", authorIntroContent=" + authorIntroContent + ", poster=" + poster
				+ "]";
	}

	
	
	
}
