package com.pyongjjeom.contents.parsing.movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pyongjjeom.contents.parsing.common.ContentsParsing;


public class NaverMovieParsing extends ContentsParsing {


	public NaverMovieParsing() {

		parsing("http://movie.naver.com/movie/running/current.nhn?view=list&tab=normal&order=reserve");
//parsing("http://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=94133");
	}

	public void parsing(String url) {
		try {
			doc = Jsoup.connect(url).get();
			grade = doc.select("span[class=num]");
			title = doc.select("dt[class=tit] a");
			this.addTitle();
			this.addGrade();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addTitle() {
		for (Element tit : title) {
			titleList.add(tit.text());
	System.out.println(tit.attr("href").substring(tit.attr("href").lastIndexOf("=")+1));
			codeList.add(tit.attr("href").substring(tit.attr("href").lastIndexOf("=")+1));
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
		System.out.println(parsing.codeList.toString());
	}
}
