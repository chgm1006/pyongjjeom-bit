package com.pyongjjeom.test.parsing.movie;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.book.AladinParsing;
import com.pyongjjeom.test.parsing.contents.ContentsParsing;

public class DaumMovieParsing extends ContentsParsing {

	public DaumMovieParsing() {

		try {
			doc = Jsoup
					.connect(
							"http://movie.daum.net/ranking/now_ranking/rankingPointNow.do?pointType=1")
					.get();
			title = doc.select("td[class^=td2");
			grade = doc.select("em");

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
				gradeList.add(Double.parseDouble(gra.text()));	
		}
	}
	
}
