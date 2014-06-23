package com.pyongjjeom.test.parsing.movie;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;

public class MegaBoxParsing extends ContentsParsing {

	public MegaBoxParsing() {

		parsing("http://www.megabox.co.kr/Movie/moviePlayList.aspx?statuscode=50&ordtype=4");

	}

	public void parsing(String url) {
		try {
			doc = Jsoup.connect(url).get();
			title = doc.select("h3");
			grade = doc.select("li strong");
			this.addTitle();
			this.addGrade();
			;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addTitle() {
		for (Element tit : title) {
			titleList.add(tit.text());
		}
	}

	private void addGrade() {
		int i = 0;
		for (Element gra : grade) {
			i++;
			if (i % 2 == 0)
				gradeList.add(Double.parseDouble(gra.text()));
		}
	}
}
