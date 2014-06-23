package com.pyongjjeom.test.parsing.book;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import com.pyongjjeom.test.parsing.contents.ContentsParsing;

public class KyoboParsing extends ContentsParsing {

	public KyoboParsing() {

		parsing("http://www.kyobobook.co.kr/bestseller/bestSellerKyoboKorList.laf?mallGb=KOR&perPage=100");
	}

	public void parsing(String url) {
		try {
			doc = Jsoup.connect(url).get();
			title = doc.select("strong a[href]");
			grade = doc.select("img[alt*=만점]");
			this.addTitle();
			this.addGrade();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addTitle() {
		for (Element tit : title) {
			if (tit.text().indexOf("(") > 0) {
				titleList.add(tit.text().substring(0, tit.text().indexOf("(")));
			} else
				titleList.add(tit.text());
		}
	}

	private void addGrade() {
		for (Element gra : grade) {
			gradeList.add(Double.parseDouble(gra.attr("alt").substring(7, 8)) * 2);
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
