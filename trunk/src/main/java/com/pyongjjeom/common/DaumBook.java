package com.pyongjjeom.common;

public class DaumBook {
	private String title = ""; // 검색 제목
	private String link = ""; // 책에 대한 페이지 link url
	private String cover_s_url = ""; // 표지 이미지(small)
	private String cover_l_url = ""; // 표지 이미지(large)
	private String description = ""; // 책에 대한 설명
	private String author = ""; // 저자
	private String translator = ""; // 역자
	private String pub_nm = ""; // 출판사
	private String pub_date = ""; // 출판일
	private String category = ""; // 카테고리 정보
	private String isbn = ""; // ISBN 번호 (10자리)
	private String isbn13 = ""; // ISBN 번호 (13자리)
	private String sale_yn = ""; // 판매 가능 여부
	private String list_price = ""; // 원가격
	private String sale_price = ""; // 판매가격
	private String status_des = ""; // 책의 현재 상태(정상,품절,절판 등)
	private String barcode = ""; // 교보문고 바코드 정보
	private String ebook_barcode = ""; // 교보문고 전자 책 바코드 정보

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

	public String getCover_s_url() {
		return cover_s_url;
	}

	public void setCover_s_url(String cover_s_url) {
		this.cover_s_url = cover_s_url;
	}

	public String getCover_l_url() {
		return cover_l_url;
	}

	public void setCover_l_url(String cover_l_url) {
		this.cover_l_url = cover_l_url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public String getPub_nm() {
		return pub_nm;
	}

	public void setPub_nm(String pub_nm) {
		this.pub_nm = pub_nm;
	}

	public String getPub_date() {
		return pub_date;
	}

	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getSale_yn() {
		return sale_yn;
	}

	public void setSale_yn(String sale_yn) {
		this.sale_yn = sale_yn;
	}

	public String getList_price() {
		return list_price;
	}

	public void setList_price(String list_price) {
		this.list_price = list_price;
	}

	public String getSale_price() {
		return sale_price;
	}

	public void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}

	public String getStatus_des() {
		return status_des;
	}

	public void setStatus_des(String status_des) {
		this.status_des = status_des;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getEbook_barcode() {
		return ebook_barcode;
	}

	public void setEbook_barcode(String ebook_barcode) {
		this.ebook_barcode = ebook_barcode;
	}

}
