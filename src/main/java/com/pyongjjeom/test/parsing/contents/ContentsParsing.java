package com.pyongjjeom.test.parsing.contents;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class ContentsParsing {

	protected Elements grade;
	protected Elements title;
	protected List<String> titleList;
	protected List<Double> gradeList;
	protected Document doc;

	public ContentsParsing() {
	}

	public List<String> getTitleList() {
		return titleList;
	}

	public List<Double> getGradeList() {
		return gradeList;
	}

}
