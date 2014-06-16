package com.pyongjjeom.test.parsing.book;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;


public class KyoboParsing extends ContentsParsing {

	public KyoboParsing() {

		try {
			doc = Jsoup
					.connect(
							"http://www.kyobobook.co.kr/bestseller/bestSellerKyoboKorList.laf?mallGb=KOR&linkClass=&range=1&kind=0")
					.get();
			title = doc.select("strong a[href]");
			grade = doc.select("img[alt*=만점]");
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
			gradeList
					.add(Double.parseDouble(gra.attr("alt").substring(7, 8)) * 2);
		}
	}

	public static void main(String[] args) {
		KyoboParsing parsing = new KyoboParsing();
		System.out.println(parsing.getTitleList().size() + "/"
				+ parsing.getGradeList().size());
		System.out.println(parsing.titleList.toString());
		System.out.println(parsing.gradeList.toString());
	}
}
