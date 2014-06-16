package com.pyongjjeom.test.parsing.movie;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;



public class MegaBoxParsing  extends ContentsParsing{

	public MegaBoxParsing() {

		try {
			doc = Jsoup
					.connect(
							"http://www.megabox.co.kr/Movie/moviePlayList.aspx?statuscode=50&ordtype=4")
					.get();
			title = doc.select("h3");
			grade = doc.select("li strong");
			this.addTitle();
			this.addGrade();;
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
		int i = 0;
		gradeList = new ArrayList<>();
		for (Element gra : grade) {
			i++;
			if (i % 2 == 0)
					gradeList.add(Double.parseDouble(gra.text()));
		}
	}
}
