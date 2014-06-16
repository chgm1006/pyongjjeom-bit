package com.pyongjjeom.test.parsing.main;

import com.pyongjjeom.test.parsing.contents.ContentsValue;
import com.pyongjjeom.test.parsing.movie.CgvParsing;
import com.pyongjjeom.test.parsing.movie.LotteParsing;
import com.pyongjjeom.test.parsing.movie.MegaBoxParsing;

public class MovieTest {

	static int TOTALNUMBER = 26;

	public static void main(String args[]) {

		CgvParsing cgvParsing = new CgvParsing();
		LotteParsing lotteParsing = new LotteParsing();
		MegaBoxParsing megaBoxParsing = new MegaBoxParsing();

		ContentsValue[] cgvValue = new ContentsValue[TOTALNUMBER];
		ContentsValue[] lotteValue = new ContentsValue[TOTALNUMBER];
		ContentsValue[] megaBoxValue = new ContentsValue[TOTALNUMBER];

		for (int i = 0; i < TOTALNUMBER; i++) {
			cgvValue[i] = new ContentsValue(cgvParsing.getTitleList().get(i),
					cgvParsing.getGradeList().get(i));
			lotteValue[i] = new ContentsValue(lotteParsing.getTitleList().get(i),
					lotteParsing.getGradeList().get(i));
			megaBoxValue[i] = new ContentsValue(megaBoxParsing.getTitleList().get(i),
					megaBoxParsing.getGradeList().get(i));
			System.out.printf("%02d", i + 1);
			System.out.println("  CGV : " + cgvValue[i].toString() + " // 롯데시네마 : "
					+ lotteValue[i].toString() + " // 메가박스 : "
					+ megaBoxValue[i].toString());

		}

	}
}
