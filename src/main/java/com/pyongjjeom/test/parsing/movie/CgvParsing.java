package com.pyongjjeom.test.parsing.movie;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;


public class CgvParsing extends ContentsParsing {


	public CgvParsing() {

		try {
			doc = Jsoup.connect(
					"http://www.cgv.co.kr/movie/running/Default.aspx").get();
			grade = doc.select("div[class$=stargrade]");
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


}
