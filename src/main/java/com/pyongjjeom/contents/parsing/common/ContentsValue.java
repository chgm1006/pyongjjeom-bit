package com.pyongjjeom.contents.parsing.common;

import org.apache.ibatis.type.Alias;

@Alias(value="ContentsValue")
public class ContentsValue {

	private String title;
	private Double grade;
	private String concd;

	public String getConcd() {
		return concd;
	}

	public void setConcd(String concd) {
		this.concd = concd;
	}

	public ContentsValue(String title, Double grade, String concd) {
		this.title = title;
		this.grade = grade;
		this.concd = concd;
	}

	public ContentsValue() {

	}

	public ContentsValue(String title, Double grade) {
		this.title = title;
		this.grade = grade;
		this.concd = " ";
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
		return "ContentsValue [title=" + title + ", grade=" + grade + ", concd=" + concd;
	}

}
