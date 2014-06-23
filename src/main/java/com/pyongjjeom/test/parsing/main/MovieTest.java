package com.pyongjjeom.test.parsing.main;

import java.util.ArrayList;
import java.util.List;

import com.pyongjjeom.test.parsing.contents.ContentsValue;
import com.pyongjjeom.test.parsing.movie.CgvParsing;
import com.pyongjjeom.test.parsing.movie.LotteParsing;
import com.pyongjjeom.test.parsing.movie.MegaBoxParsing;

public class MovieTest {

	static int TOTALNUMBER = 20;

	public static void main(String args[]) {

		CgvParsing cgvParsing = new CgvParsing();
		LotteParsing lotteParsing = new LotteParsing();
		MegaBoxParsing megaBoxParsing = new MegaBoxParsing();

		List<ContentsValue> cgvValues = new ArrayList<ContentsValue>();
		List<ContentsValue> lotteValues = new ArrayList<ContentsValue>();
		List<ContentsValue> megaBoxValues = new ArrayList<ContentsValue>();

		// ContentsValue[] cgvValue = new ContentsValue[TOTALNUMBER];
		// ContentsValue[] lotteValue = new ContentsValue[TOTALNUMBER];
		// ContentsValue[] megaBoxValue = new ContentsValue[TOTALNUMBER];

		for (int i = 0; i < TOTALNUMBER; i++) {
			// cgvValue[i] = new ContentsValue(cgvParsing.getTitleList().get(i),
			// cgvParsing.getGradeList().get(i));
			// lotteValue[i] = new ContentsValue(lotteParsing.getTitleList().get(i),
			// lotteParsing.getGradeList().get(i));
			// megaBoxValue[i] = new
			// ContentsValue(megaBoxParsing.getTitleList().get(i),
			// megaBoxParsing.getGradeList().get(i));
			// cgvValues.add(new ContentsValue(cgvParsing.getTitleList().get(i),
			// cgvParsing.getGradeList().get(i)));
			// lotteValues.add(new ContentsValue(lotteParsing.getTitleList().get(i),
			// lotteParsing.getGradeList().get(i)));
			// megaBoxValues.add(new
			// ContentsValue(megaBoxParsing.getTitleList().get(i),
			// megaBoxParsing.getGradeList().get(i)));
			// System.out.printf("%02d", i + 1);
			// System.out.println("  CGV : " + cgvValue[i].toString() + " // 롯데시네마 : "
			// + lotteValue[i].toString() + " // 메가박스 : "
			// + megaBoxValue[i].toString());
		}
		System.out.println(cgvValues.toString());
		System.out.println(lotteValues.toString());
		System.out.println(megaBoxValues.toString());

	}
}
