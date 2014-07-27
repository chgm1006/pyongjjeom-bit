package com.pyongjjeom.contents.parsing.book;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import com.pyongjjeom.contents.parsing.common.ContentsParsing;

public class AladinParsing extends ContentsParsing {

	public AladinParsing() {
		parsing("http://www.aladin.co.kr/shop/common/wbest.aspx?BranchType=1");
		parsing("http://www.aladin.co.kr/shop/common/wbest.aspx?BestType=Bestseller&BranchType=1&CID=0&page=2&cnt=300&SortOrder=1");
		parsing("http://www.aladin.co.kr/shop/common/wbest.aspx?BestType=Bestseller&BranchType=1&CID=0&page=3&cnt=300&SortOrder=1");
		parsing("http://www.aladin.co.kr/shop/common/wbest.aspx?BestType=Bestseller&BranchType=1&CID=0&page=4&cnt=300&SortOrder=1");
		parsing("http://www.aladin.co.kr/shop/common/wbest.aspx?BestType=Bestseller&BranchType=1&CID=0&page=5&cnt=300&SortOrder=1");
		parsing("http://www.aladin.co.kr/shop/common/wbest.aspx?BestType=Bestseller&BranchType=1&CID=0&page=6&cnt=300&SortOrder=1");

	}

	@Override
	public void parsing(String url) {
		try {
			doc = Jsoup.connect(url).get();
			title = doc.select("ul:has(img[src*=star]) b");
			grade = doc.select("img[src*=star]");
			this.addTitle();
			this.addGrade();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addTitle() {
		int i = 0;
		for (Element tit : title) {
			if (i % 3 == 0) {
				titleList.add(tit.text());
			}
			i++;
		}
	}

	private void addGrade() {
		String str = "_s";
		for (Element gra : grade) {
			gradeList.add(Double.parseDouble(gra.toString().substring(gra.toString().lastIndexOf(str) + 2,
					gra.toString().lastIndexOf("."))));
		}
	}

	public static void main(String[] args) {
		AladinParsing parsing = new AladinParsing();
		System.out.println(parsing.getTitleList().size() + "/" + parsing.getGradeList().size());
		System.out.println(parsing.titleList.toString());
		System.out.println(parsing.gradeList.toString());
	}

}
