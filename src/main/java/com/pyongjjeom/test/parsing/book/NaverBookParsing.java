package com.pyongjjeom.test.parsing.book;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;


public class NaverBookParsing extends ContentsParsing {

	public NaverBookParsing() {

		try {
			doc = Jsoup.connect("http://book.naver.com/bestsell/bestseller_list.nhn?cp=kyobo").get();
			title = doc.select("dt[id^=book] a");
			grade = doc.select("dd[class=txt_desc]");
			this.addTitle();
			this.addGrade();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	
	private void addTitle() {
		titleList = new ArrayList<>();
		for (Element tit : title) {
			titleList.add(tit.text());
		}
	}

	private void addGrade() {
		gradeList = new ArrayList<>();
		for (Element gra : grade) {
			gradeList.add((Double.parseDouble(gra.childNode(2).toString()
					.substring(0, 4))));
		}
	}

	public static void main(String[] args) {
		NaverBookParsing parsing = new NaverBookParsing();
		System.out.println(parsing.getTitleList().size() + "/"
				+ parsing.getGradeList().size());
		System.out.println(parsing.titleList.toString());
		System.out.println(parsing.gradeList.toString());
	}
}
