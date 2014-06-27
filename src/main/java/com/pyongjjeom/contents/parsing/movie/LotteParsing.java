package com.pyongjjeom.contents.parsing.movie;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.contents.parsing.common.ContentsParsing;


public class LotteParsing extends ContentsParsing {

	public LotteParsing() {

		parsing("http://www.lottecinema.co.kr/LHS/LHFS/Contents/MovieInfo/NowMovieShortComment.aspx");

	}

	public void parsing(String url) {

		try {
			doc = Jsoup.connect(url).get();
			title = doc.select("strong");
			grade = doc.select("strong");
			this.addTitle();
			this.addGrade();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addTitle() {
		int i = 0;
		for (Element tit : title) {
			i++;
			if (i % 2 == 0)
				titleList.add(tit.text());
		}
	}

	private void addGrade() {
		int i = 0;
		for (Element gra : grade) {
			i++;
			if (i % 2 == 1 && i != 1)
				gradeList.add(Double.parseDouble(gra.text()));
		}
	}
}
