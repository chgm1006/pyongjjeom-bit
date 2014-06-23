package com.pyongjjeom.test.parsing.book;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;

public class BandinlunisParsing extends ContentsParsing {

	public BandinlunisParsing() {

		parsing("http://www.bandinlunis.com/front/display/listBest.do");
		parsing("http://www.bandinlunis.com/front/display/listBest.do?page=2");
		parsing("http://www.bandinlunis.com/front/display/listBest.do?page=3");
		parsing("http://www.bandinlunis.com/front/display/listBest.do?page=4");
		parsing("http://www.bandinlunis.com/front/display/listBest.do?page=5");

	}

	@Override
	public void parsing(String url) {
		try {
			doc = Jsoup.connect(url).get();
			title = doc.select("div[class=bookView]:has(span[class=ml5]) li[class=v_title] a");
			grade = doc.select("div[class=boxB] span[class=ml5]");
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
		String str;

		for (Element gra : grade) {
			str = gra.child(0).attr("alt") + "." + gra.child(2).attr("alt")
					+ gra.child(3).attr("alt");
			if (str.equals("1.0"))
				str = "10.0";
			gradeList.add(Double.parseDouble(str));
		}
	}

	public static void main(String[] args) {
		BandinlunisParsing parsing = new BandinlunisParsing();
		System.out.println(parsing.getTitleList().size() + "/"
				+ parsing.getGradeList().size());
		System.out.println(parsing.titleList.toString());
		System.out.println(parsing.gradeList.toString());
	}
}
