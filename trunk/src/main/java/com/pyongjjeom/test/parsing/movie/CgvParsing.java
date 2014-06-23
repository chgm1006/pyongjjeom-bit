package com.pyongjjeom.test.parsing.movie;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import com.pyongjjeom.test.parsing.contents.ContentsParsing;

public class CgvParsing extends ContentsParsing {

	public CgvParsing() {

		parsing("http://www.cgv.co.kr/movie/running/Default.aspx");
	}

	public void parsing(String url) {
		try {
			doc = Jsoup.connect(url)
					.get();
			grade = doc.select("div[class$=stargrade]");
			title = doc.select("p[class=tit]");
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
			gradeList.add(Double.parseDouble(gra.text().substring(0, 3)));
		}
	}

}
