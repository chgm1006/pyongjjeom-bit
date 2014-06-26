package com.pyongjjeom.test.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.common.DaumBook;
import com.pyongjjeom.common.DaumMovie;
import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.common.NaverMovie;
import com.pyongjjeom.common.code.DBCode;
import com.pyongjjeom.test.openAPI.DaumParse;
import com.pyongjjeom.test.openAPI.NaverParse;
import com.pyongjjeom.test.parsing.book.AladinParsing;
import com.pyongjjeom.test.parsing.book.BandinlunisParsing;
import com.pyongjjeom.test.parsing.book.KyoboParsing;
import com.pyongjjeom.test.parsing.book.NaverBookParsing;
import com.pyongjjeom.test.parsing.book.Yes24Parsing;
import com.pyongjjeom.test.parsing.contents.BookGrades;
import com.pyongjjeom.test.parsing.contents.ContentsParsing;
import com.pyongjjeom.test.parsing.contents.ContentsValue;
import com.pyongjjeom.test.parsing.contents.MovieGrades;
import com.pyongjjeom.test.parsing.movie.CgvParsing;
import com.pyongjjeom.test.parsing.movie.DaumMovieParsing;
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

	@RequestMapping(value = "MovieDBTest.do", method = RequestMethod.GET)
	public String updateMovieGrade(Model model, HttpServletRequest request) {

		NaverMovieParsing naverParsing = new NaverMovieParsing();
		MegaBoxParsing megaBoxParsing = new MegaBoxParsing();
		LotteParsing lotteParsing = new LotteParsing();
		CgvParsing cgvParsing = new CgvParsing();
		DaumMovieParsing daumParsing = new DaumMovieParsing();

		List<ContentsValue> naverValues = new ArrayList<ContentsValue>();
		List<ContentsValue> megaBoxValues = new ArrayList<ContentsValue>();
		List<ContentsValue> lotteValues = new ArrayList<ContentsValue>();
		List<ContentsValue> cgvValues = new ArrayList<ContentsValue>();
		List<ContentsValue> daumValues = new ArrayList<ContentsValue>();

		updateGrade(naverParsing, naverValues, "n");
		updateGrade(daumParsing, daumValues, "d");
		updateGrade(cgvParsing, cgvValues, "c");
		updateGrade(lotteParsing, lotteValues, "l");
		updateGrade(megaBoxParsing, megaBoxValues, "m");

		return "test/test";
	}

	@RequestMapping(value = "BookDBTest.do", method = RequestMethod.GET)
	public String updateBookGrade(Model model, HttpServletRequest request) {

		Yes24Parsing yes24Parsing = new Yes24Parsing();
		AladinParsing aladinParsing = new AladinParsing();
		BandinlunisParsing bandinlunisParsing = new BandinlunisParsing();
		KyoboParsing kyoboParsing = new KyoboParsing();
		NaverBookParsing naverParsing = new NaverBookParsing();

		List<ContentsValue> yes24Values = new ArrayList<ContentsValue>();
		List<ContentsValue> aladinValues = new ArrayList<ContentsValue>();
		List<ContentsValue> bandinlunisValues = new ArrayList<ContentsValue>();
		List<ContentsValue> kyoboValues = new ArrayList<ContentsValue>();
		List<ContentsValue> naverValues = new ArrayList<ContentsValue>();

		updateGrade(yes24Parsing, yes24Values, "y");
		updateGrade(kyoboParsing, kyoboValues, "k");
		updateGrade(aladinParsing, aladinValues, "a");
		updateGrade(bandinlunisParsing, bandinlunisValues, "b");
		updateGrade(naverParsing, naverValues, "nb");

		return "test/test";
	}

	private void updateGrade(ContentsParsing Parsing, List<ContentsValue> Values,
			String str) {
		if (str.equals("n")) {
			DBCode dbCode = new DBCode();
			for (int i = 0; i < Parsing.getGradeList().size(); i++) {
				Values.add(new ContentsValue(Parsing.getTitleList().get(i), Parsing
						.getGradeList().get(i), dbCode.getContentCD("m")));
			}
			testService.movieTitleInsert(Values);
		}
		if (str.equals("y") || str.equals("k")) {
			DBCode dbCode = new DBCode();
			for (int i = 0; i < Parsing.getGradeList().size(); i++) {
				Values.add(new ContentsValue(Parsing.getTitleList().get(i), Parsing
						.getGradeList().get(i), dbCode.getContentCD("b")));
			}
			testService.bookTitleInsert(Values);
		} else
			for (int i = 0; i < Parsing.getGradeList().size(); i++) {
				Values.add(new ContentsValue(Parsing.getTitleList().get(i), Parsing
						.getGradeList().get(i)));
			}
		testService.gradeUpdate(Values, str);
	}

	@RequestMapping(value = "search2", method = RequestMethod.GET)
	public String naverSearch(Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {

		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("stat", request.getParameter("stat"));
		System.out.println(httpSession.getAttribute("stat"));
		List<?> resultList = null;
		String apiKey = "49c7c77a6538e00d4e35ffbccefb3e45";
		String uri;
		String resultPage = null;

		int category = Integer.parseInt(request.getParameter("category"));
		String searchQuery = (String) request.getParameter("Search").trim();
		System.out.println(searchQuery);
		NaverParse naverParse = new NaverParse();
		switch (category) {
		case 0:
			resultList = new ArrayList<NaverBook>();

			uri = "http://openapi.naver.com/search?key=" + apiKey + "&target=book"
					+ "&query=" + URLEncoder.encode(searchQuery, "UTF-8")
					+ "&display=100";
			resultList = naverParse.bookParse(uri);
			System.out.println(uri);
			resultPage = "test/resultNaverBook";
			break;
		case 1:
			resultList = new ArrayList<NaverMovie>();
			uri = "http://openapi.naver.com/search?key=" + apiKey + "&target=movie"
					+ "&query=" + URLEncoder.encode(searchQuery, "UTF-8")
					+ "&display=100";
			System.out.println(uri);
			resultList = naverParse.movieParse(uri);
			resultPage = "test/resultNaverMovie";
			break;
		default:
			break;
		}
		httpSession.setAttribute("resultList", resultList);

		return resultPage;
	}

	@RequestMapping(value = "test2.do", method = RequestMethod.GET)
	public String test2(Model model, HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession httpSession = request.getSession();
		List<NaverMovie> list = (List<NaverMovie>) httpSession
				.getAttribute("resultList");
		NaverMovie movie = list.get(num);
		movie.setTitle(movie.getTitle().replace("<b>", "").replace("</b>", ""));
		if (movie.getTitle().contains("(")) {
			movie.setTitle(movie.getTitle().substring(0,
					movie.getTitle().indexOf("(")));
		}

		httpSession.setAttribute("movie", movie);
		if (httpSession.getAttribute("stat").equals("search")) {
			System.out.println("까꿍~");
			Document doc;
			Jsoup jsoup = null;
			MovieGrades grades = new MovieGrades();
			System.out.println("???" + movie.getTitle());
			grades = testService.movieGradeSelect(movie.getTitle());

			try {
				doc = Jsoup.connect(movie.getLink()).get();
				request.setAttribute("genre",
						doc.select("p[class=info_spec] a[href*=genre").text());
				request.setAttribute("nation",
						doc.select("p[class=info_spec] a[href*=nation").text());
				request.setAttribute("open",
						doc.select("p[class=info_spec] a[href*=open").text());
				request.setAttribute("grade",
						doc.select("p[class=info_spec] a[href*=grade").text());
				request.setAttribute("count",
						doc.select("p[class=info_spec] span[class=count]").text());
				request.setAttribute("context", doc.select("p[class=con_tx]").text());
				request.setAttribute("grades", grades);

				if (grades != null) {
					int count = 0;
					double avg = 0;
					double arr[] = { grades.getCgvMg(), grades.getDaumMg(),
							grades.getLotteMg(), grades.getMegaBoxMg(), grades.getNaverMg() };
					for (double grade : arr) {
						if (grade != 0) {
							avg += grade;
							count++;
						}
					}
					request.setAttribute("avg", avg / count);
				}
				return "test/searchTest";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "test/postingTest";
	}

	@RequestMapping(value = "test3.do", method = RequestMethod.GET)
	public String test22(Model model, HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession httpSession = request.getSession();
		List<NaverBook> list = (List<NaverBook>) httpSession
				.getAttribute("resultList");
		NaverBook book = list.get(num);
		book.setTitle(book.getTitle().replace("<b>", "").replace("</b>", ""));
		if (book.getTitle().contains("(")) {
			book.setTitle(book.getTitle().substring(0, book.getTitle().indexOf("(")));
		}

		httpSession.setAttribute("book", book);

		if (httpSession.getAttribute("stat").equals("search")) {
			System.out.println("까꿍2~");
			Document doc;
			Jsoup jsoup = null;
			BookGrades grades = new BookGrades();
			System.out.println("???" + book.getTitle());
			grades = testService.bookGradeSelect(book.getTitle());

			try {
				doc = Jsoup.connect(book.getLink()).get();
				request.setAttribute("bookIntroContent",
						doc.select("div[id=bookIntroContent]").text());
				request.setAttribute("authorIntroContent",
						doc.select("div[id=authorIntroContent]").text());
				request.setAttribute("grades", grades);

				if (grades != null) {
					int count = 0;
					double avg = 0;
					double arr[] = { grades.getAladinBg(), grades.getBandiBg(),
							grades.getKyoboBg(), grades.getNaverBg(), grades.getYesBg() };
					for (double grade : arr) {
						if (grade != 0) {
							avg += grade;
							count++;
						}
					}
					request.setAttribute("avg", avg / count);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "test/searchTest2";
		}
		return "test/bookPostingTest";
	}

	@RequestMapping(value = "postingWrite.do", method = RequestMethod.POST)
	public String test3(Model model, HttpServletRequest request) {

		String str = request.getParameter("postContext");
		// DB에 추가 해야함 _
		request.setAttribute("posting", str);
		return "test/postingTest2";
	}

	@RequestMapping(value = "postingWrite2.do", method = RequestMethod.POST)
	public String test33(Model model, HttpServletRequest request) {

		String str = request.getParameter("postContext");
		// DB에 추가 해야함 _
		request.setAttribute("posting", str);
		return "test/bookPostingTest2";
	}

}
