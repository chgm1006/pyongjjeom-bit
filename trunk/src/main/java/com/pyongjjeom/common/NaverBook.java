package com.pyongjjeom.common;

/**
 * <pre>
 * 간략 : 
 * 상세 : 
 * com.pyongjjeom.common
 *   |_ NaverBook.java
 * </pre>
 * 
 * @author : Administrator
 * @version : 1.0
 */
public class NaverBook {
	@Override
	public String toString() {
		return "NaverBook [title=" + title + ", link=" + link + ", image=" + image
				+ ", author=" + author + ", price=" + price + ", discount=" + discount
				+ ", publisher=" + publisher + ", pubdate=" + pubdate + ", isbn="
				+ isbn + ", description=" + description + ", code=" + conCD + "]";
	}

	/**
	 * 
	 */
	private String title = ""; // 검색 제목
	private String link = ""; // 검색 link
	private String image = ""; // 썸네일 이미지
	private String author = ""; // 저자
	private String price = ""; // 정가
	private String discount = ""; // 할인 가격
	private String publisher = ""; // 출판사
	private String pubdate = ""; // 출간일
	private String isbn = ""; // ISBN
	private String description = ""; // 내용
	private String conCD = ""; 


	public String getConCD() {
		return conCD;
	}

	public void setConCD(String conCD) {
		this.conCD = conCD;
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 :
	 * </PRE>
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 :
	 * </PRE>
	 * 
	 * @param title
	 *          test
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 :
	 * </PRE>
	 * 
	 * @return link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 :
	 * </PRE>
	 * 
	 * 
	 * @param link
	 *          test
	 */
	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
