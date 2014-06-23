package com.pyongjjeom.test.parsing.main;

import com.pyongjjeom.test.parsing.book.AladinParsing;
import com.pyongjjeom.test.parsing.book.BandinlunisParsing;
import com.pyongjjeom.test.parsing.book.KyoboParsing;
import com.pyongjjeom.test.parsing.book.NaverBookParsing;
import com.pyongjjeom.test.parsing.book.Yes24Parsing;
import com.pyongjjeom.test.parsing.contents.ContentsValue;

public class BookTest {

	static int TOTALNUMBER = 18;

	public static void main(String args[]) {

		Yes24Parsing yes24Parsing = new Yes24Parsing();
		AladinParsing aladinParsing = new AladinParsing();
		BandinlunisParsing bandinlunisParsing = new BandinlunisParsing();
		KyoboParsing kyoboParsing = new KyoboParsing();
		NaverBookParsing naverParsing = new NaverBookParsing();

		ContentsValue[] yes24Value = new ContentsValue[TOTALNUMBER];
		ContentsValue[] aladinValue = new ContentsValue[TOTALNUMBER];
		ContentsValue[] bandiValue = new ContentsValue[TOTALNUMBER];
		ContentsValue[] kyoboValue = new ContentsValue[TOTALNUMBER];
		ContentsValue[] naverValue = new ContentsValue[TOTALNUMBER];

		 for (int i = 0; i < TOTALNUMBER; i++) {
		 yes24Value[i] = new ContentsValue(yes24Parsing.getTitleList()
		 .get(i), yes24Parsing.getGradeList().get(i));
	 
		 aladinValue[i] = new ContentsValue(aladinParsing.getTitleList()
		 .get(i), aladinParsing.getGradeList().get(i));
	 
		 bandiValue[i] = new ContentsValue(bandinlunisParsing.getTitleList()
		 .get(i), bandinlunisParsing.getGradeList().get(i));
	 
		 kyoboValue[i] = new ContentsValue(kyoboParsing.getTitleList()
		 .get(i), kyoboParsing.getGradeList().get(i));
	 
		 naverValue[i] = new ContentsValue(naverParsing.getTitleList()
		 .get(i), naverParsing.getGradeList().get(i));
	 
		 System.out.printf("%02d", i + 1);
		 System.out.println("  Yes24 : " + yes24Value[i].toString()
		 + "  Aladin : " + aladinValue[i].toString() + "  Bandi : "
		 + bandiValue[i].toString() + "  Kyobo : "
		 + kyoboValue[i].toString()+ "  Naver : "
		 + naverValue[i].toString());

		 }
	}
}
