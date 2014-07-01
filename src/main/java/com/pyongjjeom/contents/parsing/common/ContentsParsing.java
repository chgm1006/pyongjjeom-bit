package com.pyongjjeom.contents.parsing.common;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public abstract class ContentsParsing {

	protected Elements grade;
	protected Elements title;
	protected List<String> titleList= new ArrayList<String>();
	protected List<Double> gradeList= new ArrayList<Double>();
	protected List<String> codeList= new ArrayList<String>();
	protected Document doc;

	public ContentsParsing() {
	}
	public List<String> getCodeList() {
		return codeList;
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
