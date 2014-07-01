package com.pyongjjeom.contents.parsing.common;

public class ContentsValue {

	private String title;
	private Double grade;
	private String concd;
	private String code;


	public String getConcd() {
		return concd;
	}

	public void setConcd(String concd) {
		this.concd = concd;
	}


	public ContentsValue(String title, Double grade, String code ,String concd) {
		this.title = title;
		this.grade = grade;
		this.code = code;
		this.concd = concd;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ContentsValue() {

	}

	public ContentsValue(String title, Double grade) {
		this.title = title;
		this.grade = grade;
		this.concd= " ";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "ContentsValue [title=" + title + ", grade=" + grade + ", concd="
				+ concd + ", code=" + code + "]";
	}

}
