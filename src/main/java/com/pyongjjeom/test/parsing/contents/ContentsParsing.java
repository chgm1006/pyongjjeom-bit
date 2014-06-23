package com.pyongjjeom.test.parsing.contents;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public abstract class ContentsParsing {

	protected Elements grade;
	protected Elements title;
	protected List<String> titleList= new ArrayList<String>();
	protected List<Double> gradeList= new ArrayList<Double>();
	protected Document doc;

	public ContentsParsing() {
	}
	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 : 
	 * </PRE>
	 * @see com.pyongjjeom.test.parsing.contents.ContentsParsing#parsing(java.lang.String)
	 */
	public abstract void parsing (String url);

	public List<String> getTitleList() {
		return titleList;
	}

	public List<Double> getGradeList() {
		return gradeList;
	}

}
