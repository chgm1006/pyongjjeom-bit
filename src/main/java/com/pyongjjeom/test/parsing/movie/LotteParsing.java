package com.pyongjjeom.test.parsing.movie;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;


public class LotteParsing extends ContentsParsing {

	public LotteParsing() {

		try {
			doc = Jsoup
					.connect(
							"http://www.lottecinema.co.kr/LHS/LHFS/Contents/MovieInfo/NowMovieShortComment.aspx")
					.get();
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
		titleList = new ArrayList<>();
		for (Element tit : title) {
			i++;
			if (i % 2 == 0)
				titleList.add(tit.text());
		}
	}
	private void addGrade() {
		int i = 0;
		gradeList = new ArrayList<>();
		for (Element gra : grade) {
			i++;
			if (i % 2 == 1 && i != 1)
				gradeList.add(Double.parseDouble(gra.text()));
		}
	}
}
