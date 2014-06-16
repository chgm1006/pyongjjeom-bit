package com.pyongjjeom.test.parsing.contents;

public class ContentsValue {

	private String title;
	private Double grade;

	public ContentsValue(String title, Double grade) {
		this.title = title;
		this.grade=grade;
	}
public ContentsValue() {

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
		return  title + "_" + grade;
	}
	

}
