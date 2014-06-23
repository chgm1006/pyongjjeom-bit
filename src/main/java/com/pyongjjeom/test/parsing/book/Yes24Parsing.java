package com.pyongjjeom.test.parsing.book;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;

public class Yes24Parsing extends ContentsParsing {

	public Yes24Parsing() {

		parsing("http://www.yes24.com/24/category/bestseller?CategoryNumber=001&sumgb=06&FetchSize=100");
		
	}

	@Override
	public void parsing(String url) {
		try {
			doc = Jsoup.connect(url).get();
			grade = doc.select("p[class$=review]");
			title = doc.select("tr:has(p[class$=review]) img[src$=/s]");
			this.addTitle();
			this.addGrade();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addTitle() {
		for (Element tit : title) {
			titleList.add(tit.toString().substring(
					tit.toString().lastIndexOf("=") + 2, tit.toString().length() - 4));
		}
	}

	private void addGrade() {
		for (Element gra : grade) {
			int i = 0;
			int num = 0;
			String str = "On";
			for (i = 1; i <= 5; i++) {
				if (gra.child(i).toString()
						.substring(gra.child(i).toString().lastIndexOf("O"))
						.startsWith(str)) {
					num++;
				}
			}
			gradeList.add(num * 2.0);
		}
	}

	public static void main(String[] args) {
		Yes24Parsing parsing = new Yes24Parsing();
		System.out.println(parsing.getTitleList().size() + "/"
				+ parsing.getGradeList().size());
		System.out.println(parsing.titleList.toString());
		System.out.println(parsing.gradeList.toString());
	}

}
