package com.pyongjjeom.test.parsing.movie;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import com.pyongjjeom.test.parsing.contents.ContentsParsing;

public class DaumMovieParsing extends ContentsParsing {

	public DaumMovieParsing() {

		parsing("http://movie.daum.net/ranking/now_ranking/rankingPointNow.do?pointType=1");
		parsing("http://movie.daum.net/ranking/ranking_point/now_ranking/rankingPointNow.do?pointType=1&order=2");

	}

	public void parsing(String url) {
		try {
			doc = Jsoup.connect(url).get();
			title = doc.select("td[class^=td2");
			grade = doc.select("em");

			this.addTitle();
			this.addGrade();
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
		for (Element gra : grade) {
			gradeList.add(Double.parseDouble(gra.text()));
		}
	}

}
