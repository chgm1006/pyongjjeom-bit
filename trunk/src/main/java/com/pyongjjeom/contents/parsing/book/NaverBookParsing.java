package com.pyongjjeom.contents.parsing.book;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.contents.parsing.common.ContentsParsing;


public class NaverBookParsing extends ContentsParsing {

	public NaverBookParsing() {

		parsing("http://book.naver.com/bestsell/bestseller_body.nhn?cp=kyobo&cate=total&indexCount=&type=list&page=1");
		parsing("http://book.naver.com/bestsell/bestseller_body.nhn?cp=kyobo&cate=total&indexCount=&type=list&page=2");
		parsing("http://book.naver.com/bestsell/bestseller_body.nhn?cp=kyobo&cate=total&indexCount=&type=list&page=3");
	}

	/**
	 * <PRE>
	 * 간략 : URL을 매개변수로 주면 parsing 한 후 list에 넣어줌 
	 * 상세 :
	 * </PRE>
	 * 
	 * @param string
	 */
	public void parsing(String url) {
		try {
			doc = Jsoup.connect(url).get();
			title = doc.select("dt[id^=book] a");
			grade = doc.select("dd[class=txt_desc]");
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
			gradeList.add((Double.parseDouble(gra.childNode(2).toString()
					.substring(0, 4))));
		}
	}

	public static void main(String[] args) {
		NaverBookParsing parsing = new NaverBookParsing();
		System.out.println(parsing.getTitleList().size() + "/"
				+ parsing.getGradeList().size());
		System.out.println(parsing.titleList.toString());
		System.out.println(parsing.gradeList.toString());
	}
}
