/**
 * 
 */

package com.pyongjjeom.contents.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.common.NaverMovie;
import com.pyongjjeom.common.code.DBCode;
import com.pyongjjeom.contents.parsing.api.NaverParse;
import com.pyongjjeom.contents.parsing.book.AladinParsing;
import com.pyongjjeom.contents.parsing.book.BandinlunisParsing;
import com.pyongjjeom.contents.parsing.book.KyoboParsing;
import com.pyongjjeom.contents.parsing.book.NaverBookParsing;
import com.pyongjjeom.contents.parsing.book.Yes24Parsing;
import com.pyongjjeom.contents.parsing.common.BookGrades;
import com.pyongjjeom.contents.parsing.common.ContentsParsing;
import com.pyongjjeom.contents.parsing.common.ContentsValue;
import com.pyongjjeom.contents.parsing.common.MovieGrades;
import com.pyongjjeom.contents.parsing.movie.CgvParsing;
import com.pyongjjeom.contents.parsing.movie.DaumMovieParsing;
import com.pyongjjeom.contents.parsing.movie.LotteParsing;
import com.pyongjjeom.contents.parsing.movie.MegaBoxParsing;
import com.pyongjjeom.contents.parsing.movie.NaverMovieParsing;
import com.pyongjjeom.contents.service.ContentService;

/**
 * <pre>
 * com.pyongjjeom.contents.controllers 
 *    |_ ContentController.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */

@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;

	/**
	 * <pre>
	 * 1. 개요 : 맨 처음 호출 되는 Controller
	 * 2. 처리내용 : index 화면에서 보여줄 상영작의 정보 수집
	 * </pre>
	 * 
	 * @Method Name:
	 * @date : 2014.6.
	 * @author : ileaf
	 * @history :
	 * 
	 * @param
	 * 
	 * @return index file 의 경로
	 */

	@RequestMapping(value = "preIndex.do", method = RequestMethod.GET)
	private String preIndex(HttpServletRequest request) {
		System.out.println("컴온요");

		NaverMovieParsing parsing = new NaverMovieParsing();
		List<String> movieTitleList = parsing.getTitleList();
		Iterator<String> iterator = movieTitleList.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals("그녀")) {
				iterator.remove();
			}
		}
		NaverParse parse = new NaverParse();
		String apiKey = "49c7c77a6538e00d4e35ffbccefb3e45";
		String uri, uri2;

		List<NaverMovie> movieList = new ArrayList<NaverMovie>();
		List<String> imageList = new ArrayList<String>();
		for (int i = 0; i < 30; i++) {
			try {
				uri = "http://openapi.naver.com/search?key=" + apiKey + "&target=movie"
						+ "&query=" + URLEncoder.encode(movieTitleList.get(i), "UTF-8")
						+ "&display=1&yearfrom=2014&yearto&2014";
				movieList.add(parse.currentMovieParse(uri));
				System.out.println(uri);
				uri2 = "http://openapi.naver.com/search?key=" + apiKey
						+ "&target=image" + "&query="
						+ URLEncoder.encode(movieTitleList.get(i) + "포스터", "UTF-8")
						+ "&display=1&filter=large";
				imageList.add(parse.movieImageParse(uri2));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		int i = 0;
		for (NaverMovie movie : movieList) {
			movie.setPoster(imageList.get(i));
			i++;
		}
		HttpSession httpSession = request.getSession();
		httpSession.setMaxInactiveInterval(3600);
		httpSession.setAttribute("movieList", movieList);
		return "../../index";
	}

	@RequestMapping(value = "MovieDataUpdate.do", method = RequestMethod.GET)
	public String movieDataUpdate() {
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

		return "contents/insertResult";
	}

	@RequestMapping(value = "BookDateUpdate.do", method = RequestMethod.GET)
	public String bookDataUpdate(Model model, HttpServletRequest request) {

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

		updateGrade(naverParsing, naverValues, "nb");
		updateGrade(yes24Parsing, yes24Values, "y");
		updateGrade(kyoboParsing, kyoboValues, "k");
		updateGrade(aladinParsing, aladinValues, "a");
		updateGrade(bandinlunisParsing, bandinlunisValues, "b");

		return "contents/insertResult";
	}

	@RequestMapping(value = "ContentsSearch.do", method = RequestMethod.GET)
	public String ContentsSearch(Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("stat", request.getParameter("stat"));
		httpSession.setAttribute("category", request.getParameter("category")
				.trim());
		System.out.println(httpSession.getAttribute("category"));
		List<?> resultList = null;
		String apiKey = "49c7c77a6538e00d4e35ffbccefb3e45";
		String uri;
		String resultPage = null;

		String category = request.getParameter("category");
		String searchQuery = (String) request.getParameter("Search").trim();
		System.out.println(searchQuery);
		NaverParse naverParse = new NaverParse();
		switch (category) {
		case "book":
			resultList = new ArrayList<NaverBook>();

			uri = "http://openapi.naver.com/search?key=" + apiKey + "&target=book"
					+ "&query=" + URLEncoder.encode(searchQuery, "UTF-8")
					+ "&display=100";
			resultList = naverParse.bookParse(uri);
			System.out.println(uri);
			break;
		case "movie":
			resultList = new ArrayList<NaverMovie>();
			uri = "http://openapi.naver.com/search?key=" + apiKey + "&target=movie"
					+ "&query=" + URLEncoder.encode(searchQuery, "UTF-8")
					+ "&display=100";
			System.out.println(uri);
			resultList = naverParse.movieParse(uri);
			break;
		default:
			break;
		}
		httpSession.setAttribute("resultList", resultList);

		return "contents/contentsSearchList";
	}

	@RequestMapping(value = "currentMovieContext.do", method = RequestMethod.GET)
	public String getCurrentMovieContext(Model model, HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession httpSession = request.getSession();
		List<NaverMovie> list = (List<NaverMovie>) httpSession
				.getAttribute("movieList");
		httpSession.setAttribute("category", "movie");
		httpSession.setAttribute("stat", "search");
		NaverMovie movie = list.get(num);
		return contextParsing(movie, httpSession, request);
	}

	@RequestMapping(value = "movieContext.do", method = RequestMethod.GET)
	public String getMovieContext(Model model, HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession httpSession = request.getSession();
		List<NaverMovie> list = (List<NaverMovie>) httpSession
				.getAttribute("resultList");
		NaverMovie movie = list.get(num);
		return contextParsing(movie, httpSession, request);
	}

	@RequestMapping(value = "bookContext.do", method = RequestMethod.GET)
	public String getBookContext(Model model, HttpServletRequest request) {

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
			BookGrades grades = new BookGrades();
			System.out.println("???" + book.getTitle());
			grades = contentService.bookGradeSelect(book.getTitle());

			try {
				doc = Jsoup.connect(book.getLink()).get();
				request.setAttribute("bookIntroContent",
						doc.select("div[id=bookIntroContent]").text());
				request.setAttribute("authorIntroContent",
						doc.select("div[id=authorIntroContent]").text());
				request.setAttribute("grades", grades);

				String poster = "http://bookthumb.phinf.naver.net/"
						+ book.getImage().substring(book.getImage().indexOf("cover/"),
								book.getImage().indexOf(".jpg")) + ".jpg";
				System.out.println(poster);
				request.setAttribute("poster", poster);
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
			return "contents/contentsContext";
		}
		return "contents/contentsPostingWrite";
	}

	@RequestMapping(value = "postingInsert.do", method = RequestMethod.POST)
	public String postingInsert(Model model, HttpServletRequest request) {

		String str = request.getParameter("postContext");
		// DB에 추가 해야함 _
		request.setAttribute("posting", str);
		return "contents/contentsPostingResult";
	}

	private String contextParsing(NaverMovie movie, HttpSession httpSession,
			HttpServletRequest request) {

		movie.setTitle(movie.getTitle().replace("<b>", "").replace("</b>", ""));
		if (movie.getTitle().contains("(")) {
			movie.setTitle(movie.getTitle().substring(0,
					movie.getTitle().indexOf("(")));
		}
		String code = movie.getImage().replace("A", "1").replace("B", "2")
				.replace("C", "3");
		if (code.contains("_")) {
			code = code.substring(code.lastIndexOf("/") + 1, code.indexOf("_"));
		} else
			code = code.substring(code.lastIndexOf("/") + 1, code.indexOf("-"));

		httpSession.setAttribute("movie", movie);
		if (httpSession.getAttribute("stat").equals("search")) {
			Document doc;
			MovieGrades grades = new MovieGrades();
			grades = contentService.movieGradeSelect(movie.getTitle());
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
				String video = doc
						.select("ul[class=photo_video] li a[href^=mediaView]").attr("href");
				doc = Jsoup.connect("http://movie.naver.com/movie/bi/mi/" + video)
						.get();
				request.setAttribute("video", "http://movie.naver.com"+doc.select("iframe[class=_videoPlayer]")
						.attr("src"));
				doc = Jsoup.connect(
						"http://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode="
								+ code).get();
				request.setAttribute("poster", doc.select("img[src]").attr("src"));
				return "contents/contentsContext";
			} catch (IOException e) {
				request.setAttribute("video", " ");
				return "contents/contentsContext";
			}
		}
		return "contents/contentsPostingWrite";
	}

	private void updateGrade(ContentsParsing Parsing, List<ContentsValue> Values,
			String str) {
		if (str.equals("n")) {
			DBCode dbCode = new DBCode();
			for (int i = 0; i < Parsing.getGradeList().size(); i++) {
				Values.add(new ContentsValue(Parsing.getTitleList().get(i), Parsing
						.getGradeList().get(i), Parsing.getCodeList().get(i), dbCode
						.getContentCD("m")));
			}
			contentService.movieTitleInsert(Values);
		}
		if (str.equals("nb")) {
			DBCode dbCode = new DBCode();
			for (int i = 0; i < Parsing.getGradeList().size(); i++) {
				Values.add(new ContentsValue(Parsing.getTitleList().get(i), Parsing
						.getGradeList().get(i), Parsing.getCodeList().get(i), dbCode
						.getContentCD("b")));
			}
			contentService.bookTitleInsert(Values);
		} else
			for (int i = 0; i < Parsing.getGradeList().size(); i++) {
				Values.add(new ContentsValue(Parsing.getTitleList().get(i), Parsing
						.getGradeList().get(i)));
			}
		contentService.gradeUpdate(Values, str);
	}
}
