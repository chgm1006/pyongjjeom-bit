package com.pyongjjeom.test.parsing.book;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;



public class AladinParsing extends ContentsParsing {

	// private Elements grade;
	// private Elements title;
	// private List<String> titleList;
	// private List<Double> gradeList;
	// private Document doc;

	public AladinParsing() {
		try {
			doc = Jsoup
					.connect(
							"http://www.aladin.co.kr/shop/common/wbest.aspx?BranchType=1")
					.get();
			title = doc.select("ul:has(img[src*=star]) b");
			grade = doc.select("img[src*=star]");
			this.addTitle();
			this.addGrade();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addTitle() {
		int i = 0;
		titleList = new ArrayList<>();
		for (Element tit : title) {
			if (i % 3 == 0) {
				titleList.add(tit.text());
			}
			i++;
		}
	}

	private void addGrade() {
		String str = "_s";
		gradeList = new ArrayList<>();
		for (Element gra : grade) {
			gradeList.add(Double.parseDouble(gra.toString().substring(
					gra.toString().lastIndexOf(str) + 2,
					gra.toString().lastIndexOf("."))));
		}
	}


	public static void main(String[] args) {
		AladinParsing parsing = new AladinParsing();
		System.out.println(parsing.getTitleList().size() + "/"
				+ parsing.getGradeList().size());
		System.out.println(parsing.titleList.toString());
		System.out.println(parsing.gradeList.toString());
	}
}
