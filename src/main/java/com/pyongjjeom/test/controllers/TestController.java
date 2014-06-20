package com.pyongjjeom.test.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.common.DaumBook;
import com.pyongjjeom.common.DaumMovie;
import com.pyongjjeom.common.code.DBCode;
import com.pyongjjeom.test.openAPI.DaumParse;
import com.pyongjjeom.test.parsing.contents.ContentsValue;
import com.pyongjjeom.test.parsing.movie.CgvParsing;
import com.pyongjjeom.test.parsing.movie.LotteParsing;
import com.pyongjjeom.test.parsing.movie.MegaBoxParsing;
import com.pyongjjeom.test.parsing.movie.NaverMovieParsing;
import com.pyongjjeom.test.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;

	private static final Logger logger = LoggerFactory
			.getLogger(TestController.class);

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String getEmpCount(Model model, HttpServletRequest request) {
		logger.info("EmpController getEmpCount");

		NaverMovieParsing naverParsing = new NaverMovieParsing();
		CgvParsing cgvParsing = new CgvParsing();
		LotteParsing lotteParsing = new LotteParsing();
		MegaBoxParsing megaBoxParsing = new MegaBoxParsing();

		List<ContentsValue> naverValues = new ArrayList<ContentsValue>();

		DBCode dbCode = new DBCode();

		for (int i = 0; i < 75; i++) {
			naverValues.add(new ContentsValue(naverParsing.getTitleList().get(i),
					naverParsing.getGradeList().get(i), dbCode.getContentCD("m")));
		}

		List<ContentsValue> cgvValues = new ArrayList<ContentsValue>();
		List<ContentsValue> lotteValues = new ArrayList<ContentsValue>();
		List<ContentsValue> megaBoxValues = new ArrayList<ContentsValue>();

		for (int i = 0; i < 32; i++) {
			cgvValues.add(new ContentsValue(cgvParsing.getTitleList().get(i),
					cgvParsing.getGradeList().get(i), "test"));
			lotteValues.add(new ContentsValue(lotteParsing.getTitleList().get(i),
					lotteParsing.getGradeList().get(i), "test"));
			megaBoxValues.add(new ContentsValue(megaBoxParsing.getTitleList().get(i),
					megaBoxParsing.getGradeList().get(i), "test"));
		}

		testService.titleInsert(naverValues);
		testService.gradeUpdate(naverValues);
		testService.gradeUpdate(cgvValues, lotteValues, megaBoxValues);

		return "emp/count";
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String getSearch(Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		logger.info("EmpController getSearch");

		List<?> resultList = null;
		String bookApiKey = "0daf987df65056e8b60c4302124e1e6708d36ebb";
		String movieApiKey = "4035f324c992b0137de59acbd52aca1546a829f7";
		String uri;
		String resultPage = null;

		int category = Integer.parseInt(request.getParameter("category"));
		String searchQuery = (String) request.getParameter("Search").trim();
		System.out.println(searchQuery);
		DaumParse daumParse = new DaumParse();

		switch (category) {
		case 0:
			resultList = new ArrayList<DaumBook>();
			uri = "http://apis.daum.net/search/book?q="
					+ URLEncoder.encode(searchQuery, "UTF-8") + "&apikey=" + bookApiKey;
			resultList = daumParse.bookParse(uri);
			System.out.println(uri);
			resultPage = "test/resultDaumBook";
			break;
		case 1:
			resultList = new ArrayList<DaumMovie>();
			uri = " http://apis.daum.net/contents/movie?apikey=" + movieApiKey
					+ "&q=" + URLEncoder.encode(searchQuery, "UTF-8");
			resultList = daumParse.movieParse(uri);
			resultPage = "test/resultDaumMovie";
			break;
		default:
			break;
		}

		request.setAttribute("resultList", resultList);

		return resultPage;
	}
}