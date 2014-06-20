package com.pyongjjeom.test.parsing.movie;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.book.AladinParsing;
import com.pyongjjeom.test.parsing.contents.ContentsParsing;

public class NaverMovieParsing extends ContentsParsing {

	public NaverMovieParsing() {

		try {
			doc = Jsoup
					.connect(
							"http://movie.naver.com/movie/running/current.nhn?view=list&tab=normal&order=reserve")
					.get();
			System.out.println(doc);
			
			grade = doc.select("div:has(a[href^=) span[class=num]");
			title = doc.select("p[class=tit]");
			
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
			gradeList.add(Double.parseDouble(gra.text().substring(0, 3)));
		}
	}

	public static void main(String[] args) {
		NaverMovieParsing parsing = new NaverMovieParsing();
		System.out.println(parsing.getTitleList().size() + "/"
				+ parsing.getGradeList().size());
		System.out.println(parsing.titleList.toString());
		System.out.println(parsing.gradeList.toString());
	}
}
