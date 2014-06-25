package com.pyongjjeom.test.parsing.movie;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;

public class NaverMovieParsing extends ContentsParsing {

	public NaverMovieParsing() {

		parsing("http://movie.naver.com/movie/running/current.nhn?view=list&tab=normal&order=reserve");

	}

	public void parsing(String url) {
		try {
			doc = Jsoup.connect(url).get();

			grade = doc.select("span[class=num]");
			title = doc.select("dt[class=tit");

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
		int i = 0;
		for (Element gra : grade) {
			if (i % 2 == 0) {
				gradeList.add(Double.parseDouble(gra.text()));
			}
			i++;
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
