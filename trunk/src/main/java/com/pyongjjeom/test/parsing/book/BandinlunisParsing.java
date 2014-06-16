package com.pyongjjeom.test.parsing.book;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.test.parsing.contents.ContentsParsing;


public class BandinlunisParsing  extends ContentsParsing{

	public BandinlunisParsing() {
		try {
			doc = Jsoup
					.connect(
							"http://www.bandinlunis.com/front/display/listBest.do").get();
			title = doc.select("div[class=bookView]:has(span[class=ml5]) li[class=v_title] a");
			grade = doc.select("div[class=boxB] span[class=ml5]");
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
		String str;
		gradeList = new ArrayList<>();
		for (Element gra : grade) {
			str=gra.child(0).attr("alt")+"."+gra.child(2).attr("alt")+gra.child(3).attr("alt");
			if(str.equals("1.0"))
				str="10.0";
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
