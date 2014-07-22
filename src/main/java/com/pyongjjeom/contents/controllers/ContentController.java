package com.pyongjjeom.contents.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.common.NaverMovie;
import com.pyongjjeom.contents.dto.ContentBookDetail;
import com.pyongjjeom.contents.dto.ContentMovieDetail;
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
import com.pyongjjeom.postandreply.dto.Comment;
import com.pyongjjeom.postandreply.service.PostAndReplyService;
import com.pyongjjeom.user.dto.Member;
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
	@Autowired
	private PostAndReplyService parService;
	private HttpSession httpSession;

	@RequestMapping(value = "movieIndex.do", method = RequestMethod.GET)
	private String movieInit(HttpServletRequest request) {
		httpSession = request.getSession();
		if (httpSession.getAttribute("movieList") == null) {
			NaverMovieParsing parsing = new NaverMovieParsing();
			List<String> movieTitleList = parsing.getTitleList();
			Iterator<String> iterator = movieTitleList.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().equals("그녀")) {
					iterator.remove();
				}
			}
			Iterator<String> iterator2 = movieTitleList.iterator();
			while (iterator2.hasNext()) {
				if (iterator2.next().contains("님포매니악")) {
					iterator2.remove();
				}
			}
			NaverParse parse = new NaverParse();
			String apiKey = "49c7c77a6538e00d4e35ffbccefb3e45";
			String uri, uri2;

			List<NaverMovie> movieList = new ArrayList<NaverMovie>();
			List<String> imageList = new ArrayList<String>();
			for (int i = 0; i < 21; i++) {
				try {
					uri = "http://openapi.naver.com/search?key=" + apiKey
							+ "&target=movie" + "&query="
							+ URLEncoder.encode(movieTitleList.get(i), "UTF-8")
							+ "&display=1&yearfrom=2014&yearto&2014";
					movieList.add(parse.currentMovieParse(uri));
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
			httpSession.setAttribute("movieList", movieList);
		}

		return "contents/movieIndex";
	}

	@RequestMapping(value = "bookIndex.do", method = RequestMethod.GET)
	public String bookInit(HttpServletRequest request) {
		httpSession = request.getSession();
		if (httpSession.getAttribute("bookList") == null) {
			NaverBookParsing parsing = new NaverBookParsing();
			List<String> bookTitleList = parsing.getTitleList();

			Iterator<String> iterator = bookTitleList.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().toUpperCase().contains("TOEIC")) {
					iterator.remove();
				}
			}
			Iterator<String> iterator2 = bookTitleList.iterator();
			while (iterator2.hasNext()) {
				if (iterator2.next().contains("토익")) {
					iterator2.remove();
				}
			}
			Iterator<String> iterator3 = bookTitleList.iterator();
			while (iterator3.hasNext()) {
				if (iterator3.next().contains("세트")) {
					iterator3.remove();
				}
			}
			NaverParse parse = new NaverParse();
			String apiKey = "49c7c77a6538e00d4e35ffbccefb3e45";
			String uri;
			List<NaverBook> bookList = new ArrayList<NaverBook>();
			for (int i = 0; i < bookTitleList.size(); i++) {
				try {
					uri = "http://openapi.naver.com/search?key="
							+ apiKey
							+ "&target=book"
							+ "&query="
							+ URLEncoder.encode(bookTitleList.get(i).replace(" ", ""),
									"UTF-8") + "&display=1";
					bookList.add(parse.currentBookParse(uri));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			httpSession.setAttribute("size", bookList.size() / 10 - 1);
			httpSession.setAttribute("bookList", bookList);
		}
		return "contents/bookIndex";
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
		updateGrade(bandinlunisParsing, bandinlunisValues, "b");
		updateGrade(aladinParsing, aladinValues, "a");

		return "contents/insertResult";
	}

	@RequestMapping(value = "ContentsSearch.do", method = RequestMethod.GET)
	public String ContentsSearch(Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		httpSession = request.getSession();
		httpSession.setAttribute("stat", request.getParameter("stat"));
		httpSession.setAttribute("category", request.getParameter("category")
				.trim());
		System.out.println(httpSession.getAttribute("category"));
		List<?> resultList = null;
		String apiKey = "49c7c77a6538e00d4e35ffbccefb3e45";
		String uri;

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

	@ResponseBody
	@RequestMapping(value = "movieContextJson.do", method = RequestMethod.POST)
	public Map<String, Object> movieContextJson(@RequestBody Map paramMap,
			HttpServletRequest request) throws IOException {

		System.out.println("name = " + paramMap.get("name"));
		System.out.println("data = " + paramMap.get("data"));

		int num = Integer.parseInt((String) paramMap.get("name"));
		httpSession = request.getSession();
		List<NaverMovie> list = (List<NaverMovie>) httpSession
				.getAttribute("resultList");
		NaverMovie movie = list.get(num);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whole", movieContextParsing2(movie, request));
		map.put("movie", movie);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "currentBookContextJson.do", method = RequestMethod.POST)
	public Map<String, Object> correntBookContextJson(@RequestBody Map paramMap,
			HttpServletRequest request) throws IOException {

		System.out.println("name = " + paramMap.get("name"));
		System.out.println("data = " + paramMap.get("data"));

		int num = Integer.parseInt((String) paramMap.get("name"));
		httpSession.setAttribute("category", "book");
		httpSession.setAttribute("stat", "search");

		httpSession = request.getSession();
		List<NaverBook> list = (List<NaverBook>) httpSession
				.getAttribute("bookList");
		NaverBook book = list.get(num);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("abc", "나와라아아아아아아아");
		map.put("whole", bookContextParsing2(book, request));
		map.put("book", book);
		System.out.println(map.toString());

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "currentMovieContextJson.do", method = RequestMethod.POST)
	public Map<String, Object> currentMovieContextJson(@RequestBody Map paramMap,
			HttpServletRequest request) throws IOException {

		System.out.println("까꾸우웅");

		System.out.println("name = " + paramMap.get("name"));
		System.out.println("data = " + paramMap.get("data"));

		httpSession.setAttribute("category", "movie");
		httpSession.setAttribute("stat", "search");

		int num = Integer.parseInt((String) paramMap.get("name"));
		httpSession = request.getSession();
		List<NaverMovie> list = (List<NaverMovie>) httpSession
				.getAttribute("movieList");
		NaverMovie movie = list.get(num);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whole", movieContextParsing2(movie, request));
		map.put("movie", movie);
		return map;
	}

	private Map<String, Object> movieContextParsing2(NaverMovie movie,
			HttpServletRequest request) throws IOException {

		// 리턴값 담을 Map 객체생성
		Map<String, Object> map = new HashMap<String, Object>();

		// movie 제목가져와서 정리하는 부분
		movie.setTitle(movie.getTitle().replace("<b>", "").replace("</b>", ""));
		if (movie.getTitle().contains("(")) {
			movie.setTitle(movie.getTitle().substring(0,
					movie.getTitle().indexOf("(")));
		}
		String code = null;
		// 썸네일 주소 가져와서 영화코드 6자리 받아오는거
		System.out.println(movie.getImage() + "??????????????");
		if (!movie.getImage().isEmpty()) {
			code = movie.getImage().replace("A", "1").replace("B", "2")
					.replace("C", "3").replace("D", "4").replace("E", "5")
					.replace("F", "6");
			if (code.contains("_")) {
				code = code.substring(code.lastIndexOf("/") + 1, code.indexOf("_"));
			} else
				code = code.substring(code.lastIndexOf("/") + 1, code.indexOf("-"));
		}
		movie.setConCD("M" + code);
		httpSession.setAttribute("movie", movie);

		// 검색결과에 대한 영화정보요청일 때 if문 실행 -> 각 사이트의 평점을 갖고 와서 평균을 구함.
		if (httpSession.getAttribute("stat").equals("search")) {
			Document doc;
			MovieGrades grades = new MovieGrades();
			grades = contentService.movieGradeSelect("M" + code);

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
					// request.setAttribute("avg", avg / count);
					map.put("avg", String.valueOf((avg / count)).substring(0, 3));
				}
			} else {
				grades = new MovieGrades();
				map.put("avg", movie.getUserRating().substring(0, 3));
			}

			System.out.println("평균점수 " + map.get("avg"));
			map.put("grades", grades);

			// 네이버영화상세페이지 주소로 xml파싱하여 contentMovieDetail에 담기.

			doc = Jsoup.connect(movie.getLink()).get();
			ContentMovieDetail contentMovieDetail = new ContentMovieDetail();
			contentMovieDetail.setGenre(doc
					.select("p[class=info_spec] a[href*=genre").text());
			System.out.println("hjddjdkdkdk" + contentMovieDetail.getGenre() + "===="
					+ doc.select("p[class=info_spec] a[href*=genre") + "/");
			contentMovieDetail.setNation(doc.select(
					"p[class=info_spec] a[href*=nation").text());
			contentMovieDetail.setOpen(doc.select("p[class=info_spec] a[href*=open")
					.text());
			contentMovieDetail.setGrade(doc
					.select("p[class=info_spec] a[href*=grade").text());
			contentMovieDetail.setCount(doc.select(
					"p[class=info_spec] span[class=count]").text());
			contentMovieDetail.setContext(doc.select("p[class=con_tx]").text());

			String video = doc.select("ul[class=photo_video] li a[href^=mediaView]")
					.attr("href");
			System.out.println(video);
			if (!video.isEmpty()) {
				doc = Jsoup.connect("http://movie.naver.com/movie/bi/mi/" + video)
						.get();
				contentMovieDetail.setVideo("http://movie.naver.com"
						+ doc.select("iframe[class=_videoPlayer]").attr("src"));
				httpSession.setAttribute("video", contentMovieDetail.getVideo());
			}

			if (code != null) {
				doc = Jsoup.connect(
						"http://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode="
								+ code).get();
				contentMovieDetail.setPoster(doc.select("img[src]").attr("src"));
			}

			if (contentMovieDetail.getGenre().equals("")) {
				contentMovieDetail.setGenre("");
			}
			if (contentMovieDetail.getNation() == null) {
				contentMovieDetail.setNation("");
			}
			if (contentMovieDetail.getOpen() == null) {
				contentMovieDetail.setOpen("");
			}
			if (contentMovieDetail.getGrade() == null) {
				contentMovieDetail.setGrade("");
			}
			if (contentMovieDetail.getCount() == null) {
				contentMovieDetail.setCount("");
			}
			if (contentMovieDetail.getContext() == null) {
				contentMovieDetail.setContext("");
			}
			if (contentMovieDetail.getVideo() == null) {
				contentMovieDetail.setVideo("");
			}
			if (contentMovieDetail.getPoster() == null) {
				contentMovieDetail.setPoster("");
			}
			map.put("contentMovieDetail", contentMovieDetail);
			String pjGrade = parService.getPjGrade(movie.getConCD());
			if (pjGrade == null) {
				pjGrade = "0";
			}
			System.out.println(pjGrade + "/" + pjGrade.length());
			if (pjGrade.length() > 4) {
				pjGrade = pjGrade.substring(0, 4);
			}
			System.out.println(pjGrade);
			map.put("pjGrade", pjGrade);
			List<Comment> commentList = parService.getComent(movie.getConCD());
			Comment myComment = new Comment();
			Member member = (Member) httpSession.getAttribute("member");
			if(member!=null)
			{
				myComment= parService.getMyComent(movie.getConCD(),member.getMemCD());
			}
			if(myComment==null)
			{
				myComment= new Comment();
			}
			System.out.println(myComment+"!!!!");
			
			
			SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int i = 0, index = -1;
			for (Comment comment : commentList) {
				comment.setFormatUpdateDate(df2.format(comment.getUpdateDate()));
				if (member != null) {
					if (comment.getMemCD().equals(member.getMemCD())) {
						index = i;
					}
					i++;
				}
			}
			if (member != null && !commentList.isEmpty() && index != -1) {
				commentList.remove(index);
				myComment.setComment(myComment.getComment().replaceAll("<br>", "\r\n")
						.replaceAll("&nbsp;", "\u0020"));
			}
			System.out.println("일반 유저 " + commentList);
			System.out.println("내 자신 " + myComment);
			map.put("commentList", commentList);
			map.put("myComment", myComment);
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "bookContextJson.do", method = RequestMethod.POST)
	public Map<String, Object> bookContextJson(@RequestBody Map paramMap,
			HttpServletRequest request) throws IOException {

		System.out.println("name = " + paramMap.get("name"));
		System.out.println("data = " + paramMap.get("data"));

		int num = Integer.parseInt((String) paramMap.get("name"));
		httpSession = request.getSession();
		List<NaverBook> list = (List<NaverBook>) httpSession
				.getAttribute("resultList");
		NaverBook book = list.get(num);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("abc", "나와라아아아아아아아");
		map.put("whole", bookContextParsing2(book, request));
		map.put("book", book);
		System.out.println(map.toString());

		return map;
	}

	private Map<String, Object> bookContextParsing2(NaverBook book,
			HttpServletRequest request) throws IOException {

		// 리턴값 담을 Map 객체생성
		Map<String, Object> map = new HashMap<String, Object>();

		// movie 제목가져와서 정리하는 부분
		book.setTitle(book.getTitle().replace("<b>", "").replace("</b>", ""));
		if (book.getTitle().contains("(")) {
			book.setTitle(book.getTitle().substring(0, book.getTitle().indexOf("(")));
		}
		String code = null;
		System.out.println(book.getImage() + "??????????????");
		if (!book.getImage().isEmpty()) {
			code = book.getImage().substring(book.getImage().lastIndexOf("/0") + 2,
					book.getImage().indexOf(".jpg"));
			if (code.startsWith("0")) {
				code = code.substring(1, 7);
			}
		}

		book.setConCD("B" + code);
		httpSession.setAttribute("book", book);

		// 검색결과에 대한 영화정보요청일 때 if문 실행 -> 각 사이트의 평점을 갖고 와서 평균을 구함.
		if (httpSession.getAttribute("stat").equals("search")) {
			Document doc;
			BookGrades grades = new BookGrades();

			// Book 코드의 자리수를 맞춰 줌

			grades = contentService.bookGradeSelect("B" + code);

			if (grades != null) {
				int count = 0;
				double avg = 0;
				double arr[] = { grades.getNaverBg(), grades.getYesBg(),
						grades.getAladinBg(), grades.getBandiBg(), grades.getKyoboBg() };
				for (double grade : arr) {
					if (grade != 0) {
						avg += grade;
						count++;
					}
					// request.setAttribute("avg", avg / count);
					map.put("avg", (String.valueOf(avg / count)).substring(0, 3));
				}
			} else {
				grades = new BookGrades();
				map.put("avg", 0);
			}
			map.put("grades", grades);

			// 네이버영화상세페이지 주소로 xml파싱하여 contentMovieDetail에 담기.

			doc = Jsoup.connect(book.getLink()).get();
			ContentBookDetail contentBookDetail = new ContentBookDetail();
			contentBookDetail.setBookIntroContent(doc.select(
					"div[id=bookIntroContent]").text());
			contentBookDetail.setAuthorIntroContent(doc.select(
					"div[id=authorIntroContent]").text());
			String poster = "";
			if (!book.getImage().isEmpty()) {
				poster = "http://bookthumb.phinf.naver.net/"
						+ book.getImage().substring(book.getImage().indexOf("cover/"),
								book.getImage().indexOf(".jpg")) + ".jpg";
				contentBookDetail.setPoster(poster);
			}

			if (contentBookDetail.getBookIntroContent().equals("")) {
				contentBookDetail.setBookIntroContent("");
			}
			if (contentBookDetail.getAuthorIntroContent() == null) {
				contentBookDetail.setAuthorIntroContent("");
			}
			if (contentBookDetail.getPoster() == null) {
				contentBookDetail.setPoster("");
			}
			map.put("contentBookDetail", contentBookDetail);

			String pjGrade = parService.getPjGrade(book.getConCD());

			if (pjGrade == null) {
				pjGrade = "0";
			}
			System.out.println(pjGrade + "/" + pjGrade.length());
			if (pjGrade.length() > 4) {
				pjGrade = pjGrade.substring(0, 4);
			}
			System.out.println(pjGrade);
			map.put("pjGrade", pjGrade);

			List<Comment> commentList = parService.getComent(book.getConCD());
			Comment myComment = new Comment();
			Member member = (Member) httpSession.getAttribute("member");
			if(member!=null)
			{
				myComment= parService.getMyComent(book.getConCD(),member.getMemCD());
			}
			
			if(myComment == null)
			{
				myComment=new Comment();
			}
			System.out.println(myComment+"!!!!");
			
			
			SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int i = 0, index = -1;
			for (Comment comment : commentList) {
				comment.setFormatUpdateDate(df2.format(comment.getUpdateDate()));
				if (member != null) {
					if (comment.getMemCD().equals(member.getMemCD())) {
						index = i;
					}
					i++;
				}
			}
			if (member != null && !commentList.isEmpty() && index != -1) {
				commentList.remove(index);
				myComment.setComment(myComment.getComment().replaceAll("<br>", "\r\n")
						.replaceAll("&nbsp;", "\u0020"));
			}
			
			map.put("commentList", commentList);
			map.put("myComment", myComment);
		}

		return map;

	}

	private void updateGrade(ContentsParsing Parsing, List<ContentsValue> values,
			String str) {
		if (str.equals("n")) {
			for (int i = 0; i < Parsing.getGradeList().size(); i++) {
				values.add(new ContentsValue(Parsing.getTitleList().get(i), Parsing
						.getGradeList().get(i), "M" + Parsing.getCodeList().get(i)));
			}
			contentService.movieTitleInsert(values);
		}
		if (str.equals("nb")) {
			for (int i = 0; i < Parsing.getGradeList().size(); i++) {
				values.add(new ContentsValue(Parsing.getTitleList().get(i), Parsing
						.getGradeList().get(i), "B" + Parsing.getCodeList().get(i)));
			}
			contentService.bookTitleInsert(values);
		} else
			for (int i = 0; i < Parsing.getGradeList().size(); i++) {
				values.add(new ContentsValue(Parsing.getTitleList().get(i), Parsing
						.getGradeList().get(i)));
			}
		contentService.gradeUpdate(values, str);
	}

	/*
	 * @RequestMapping(value = "currentMovieContext.do", method =
	 * RequestMethod.GET) public String getCurrentMovieContext(Model model,
	 * HttpServletRequest request) {
	 * 
	 * int num = Integer.parseInt(request.getParameter("num")); httpSession =
	 * request.getSession(); List<NaverMovie> list = (List<NaverMovie>)
	 * httpSession .getAttribute("movieList");
	 * httpSession.setAttribute("category", "movie");
	 * httpSession.setAttribute("stat", "search"); NaverMovie movie =
	 * list.get(num); return movieContextParsing(movie, request); }
	 * 
	 * @RequestMapping(value = "movieContext.do", method = RequestMethod.GET)
	 * public String getMovieContext(Model model, HttpServletRequest request) {
	 * 
	 * int num = Integer.parseInt(request.getParameter("num")); httpSession =
	 * request.getSession(); List<NaverMovie> list = (List<NaverMovie>)
	 * httpSession .getAttribute("resultList"); NaverMovie movie = list.get(num);
	 * return movieContextParsing(movie, request); }
	 */

	/*
	 * @RequestMapping(value = "bookContext.do", method = RequestMethod.GET)
	 * public String getBookContext(Model model, HttpServletRequest request) {
	 * System.out.println("????"); int num =
	 * Integer.parseInt(request.getParameter("num")); httpSession =
	 * request.getSession(); List<NaverBook> list = (List<NaverBook>) httpSession
	 * .getAttribute("resultList"); NaverBook book = list.get(num); return
	 * bookContextParsing(book, request); }
	 * 
	 * @RequestMapping(value = "currentBookContext.do", method =
	 * RequestMethod.GET) public String getcurrentBookContext(Model model,
	 * HttpServletRequest request) { System.out.println("????"); int num =
	 * Integer.parseInt(request.getParameter("num")); httpSession =
	 * request.getSession(); List<NaverBook> list = (List<NaverBook>) httpSession
	 * .getAttribute("bookList"); httpSession.setAttribute("category", "book");
	 * httpSession.setAttribute("stat", "search"); NaverBook book = list.get(num);
	 * return bookContextParsing(book, request); }
	 * 
	 * private String bookContextParsing(NaverBook book, HttpServletRequest
	 * request) { book.setTitle(book.getTitle().replace("<b>", "").replace("</b>",
	 * "")); if (book.getTitle().contains("(")) {
	 * book.setTitle(book.getTitle().substring(0, book.getTitle().indexOf("(")));
	 * }
	 * 
	 * httpSession.setAttribute("book", book);
	 * 
	 * if (httpSession.getAttribute("stat").equals("search")) {
	 * System.out.println("까꿍2~"); Document doc; BookGrades grades = new
	 * BookGrades(); System.out.println("???" + book.getTitle()); grades =
	 * contentService.bookGradeSelect(book.getTitle());
	 * 
	 * try { doc = Jsoup.connect(book.getLink()).get();
	 * request.setAttribute("bookIntroContent",
	 * doc.select("div[id=bookIntroContent]").text());
	 * request.setAttribute("authorIntroContent",
	 * doc.select("div[id=authorIntroContent]").text());
	 * request.setAttribute("grades", grades);
	 * 
	 * String poster = "http://bookthumb.phinf.naver.net/" +
	 * book.getImage().substring(book.getImage().indexOf("cover/"),
	 * book.getImage().indexOf(".jpg")) + ".jpg"; request.setAttribute("poster",
	 * poster); if (grades != null) { int count = 0; double avg = 0; double arr[]
	 * = { grades.getAladinBg(), grades.getBandiBg(), grades.getKyoboBg(),
	 * grades.getNaverBg(), grades.getYesBg() }; for (double grade : arr) { if
	 * (grade != 0) { avg += grade; count++; } } request.setAttribute("avg", avg /
	 * count); } } catch (IOException e) { e.printStackTrace(); } return
	 * "contents/contentsContext"; } return "postandreply/contentsPostingWrite"; }
	 */

	/*
	 * @RequestMapping(value = "postingInsert.do", method = RequestMethod.POST)
	 * public String postingInsert(Model model, HttpServletRequest request) {
	 * 
	 * String str = request.getParameter("postContext"); // DB에 추가 해야함 _
	 * request.setAttribute("posting", str); return
	 * "postandreply/contentsPostingResult"; }
	 */
	/*
	 * private String movieContextParsing(NaverMovie movie, HttpServletRequest
	 * request) {
	 * 
	 * movie.setTitle(movie.getTitle().replace("<b>", "").replace("</b>", "")); if
	 * (movie.getTitle().contains("(")) {
	 * movie.setTitle(movie.getTitle().substring(0,
	 * movie.getTitle().indexOf("("))); } String code =
	 * movie.getImage().replace("A", "1").replace("B", "2") .replace("C",
	 * "3").replace("D", "4").replace("E", "5") .replace("F", "6"); if
	 * (code.contains("_")) { code = code.substring(code.lastIndexOf("/") + 1,
	 * code.indexOf("_")); } else code = code.substring(code.lastIndexOf("/") + 1,
	 * code.indexOf("-"));
	 * 
	 * httpSession.setAttribute("movie", movie); if
	 * (httpSession.getAttribute("stat").equals("search")) { Document doc;
	 * MovieGrades grades = new MovieGrades(); grades =
	 * contentService.movieGradeSelect(movie.getTitle()); if (grades != null) {
	 * int count = 0; double avg = 0; double arr[] = { grades.getCgvMg(),
	 * grades.getDaumMg(), grades.getLotteMg(), grades.getMegaBoxMg(),
	 * grades.getNaverMg() }; for (double grade : arr) { if (grade != 0) { avg +=
	 * grade; count++; } } request.setAttribute("avg", avg / count); } try { doc =
	 * Jsoup.connect(movie.getLink()).get(); request.setAttribute("genre",
	 * doc.select("p[class=info_spec] a[href*=genre").text());
	 * request.setAttribute("nation",
	 * doc.select("p[class=info_spec] a[href*=nation").text());
	 * request.setAttribute("open",
	 * doc.select("p[class=info_spec] a[href*=open").text());
	 * request.setAttribute("grade",
	 * doc.select("p[class=info_spec] a[href*=grade").text());
	 * request.setAttribute("count",
	 * doc.select("p[class=info_spec] span[class=count]").text());
	 * request.setAttribute("context", doc.select("p[class=con_tx]").text());
	 * request.setAttribute("grades", grades); String video = doc
	 * .select("ul[class=photo_video] li a[href^=mediaView]").attr("href"); doc =
	 * Jsoup.connect("http://movie.naver.com/movie/bi/mi/" + video) .get();
	 * request.setAttribute("video", "http://movie.naver.com" +
	 * doc.select("iframe[class=_videoPlayer]").attr("src"));
	 * System.out.println("http://movie.naver.com" +
	 * doc.select("iframe[class=_videoPlayer]").attr("src")); doc = Jsoup.connect(
	 * "http://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=" +
	 * code).get(); request.setAttribute("poster",
	 * doc.select("img[src]").attr("src"));
	 * 
	 * return "contents/contentsContext"; } catch (IOException e) {
	 * e.getStackTrace();
	 * 
	 * return "contents/contentsContext"; } } return
	 * "contents/contentsPostingWrite"; }
	 */

	/*
	 * 위에거 전체 백업.
	 * 
	 * @RequestMapping(value = "movieIndex.do", method = RequestMethod.GET)
	 * private String movieInit(HttpServletRequest request) { httpSession =
	 * request.getSession(); httpSession.setMaxInactiveInterval(3600); if
	 * (httpSession.getAttribute("movieList") == null) { NaverMovieParsing parsing
	 * = new NaverMovieParsing(); List<String> movieTitleList =
	 * parsing.getTitleList(); Iterator<String> iterator =
	 * movieTitleList.iterator(); while (iterator.hasNext()) { if
	 * (iterator.next().equals("그녀")) { iterator.remove(); } } NaverParse parse =
	 * new NaverParse(); String apiKey = "49c7c77a6538e00d4e35ffbccefb3e45";
	 * String uri, uri2;
	 * 
	 * List<NaverMovie> movieList = new ArrayList<NaverMovie>(); List<String>
	 * imageList = new ArrayList<String>(); for (int i = 0; i < 30; i++) { try {
	 * uri = "http://openapi.naver.com/search?key=" + apiKey + "&target=movie" +
	 * "&query=" + URLEncoder.encode(movieTitleList.get(i), "UTF-8") +
	 * "&display=1&yearfrom=2014&yearto&2014";
	 * movieList.add(parse.currentMovieParse(uri)); uri2 =
	 * "http://openapi.naver.com/search?key=" + apiKey + "&target=image" +
	 * "&query=" + URLEncoder.encode(movieTitleList.get(i) + "포스터", "UTF-8") +
	 * "&display=1&filter=large"; imageList.add(parse.movieImageParse(uri2)); }
	 * catch (UnsupportedEncodingException e) { e.printStackTrace(); } } int i =
	 * 0; for (NaverMovie movie : movieList) { movie.setPoster(imageList.get(i));
	 * i++; } httpSession.setAttribute("movieList", movieList); }
	 * 
	 * return "contents/movieIndex"; }
	 * 
	 * @RequestMapping(value = "bookIndex.do", method = RequestMethod.GET) public
	 * String bookInit(HttpServletRequest request) { httpSession =
	 * request.getSession(); if (httpSession.getAttribute("bookList") == null) {
	 * NaverBookParsing parsing = new NaverBookParsing(); List<String>
	 * bookTitleList = parsing.getTitleList(); NaverParse parse = new
	 * NaverParse(); String apiKey = "49c7c77a6538e00d4e35ffbccefb3e45"; String
	 * uri; List<NaverBook> bookList = new ArrayList<NaverBook>(); for (int i = 0;
	 * i < 100; i++) { try { uri = "http://openapi.naver.com/search?key=" + apiKey
	 * + "&target=book" + "&query=" +
	 * URLEncoder.encode(bookTitleList.get(i).replace(" ", ""), "UTF-8") +
	 * "&display=1"; bookList.add(parse.currentBookParse(uri)); } catch
	 * (UnsupportedEncodingException e) { e.printStackTrace(); } }
	 * httpSession.setAttribute("bookList", bookList); } return
	 * "contents/bookIndex"; }
	 * 
	 * @RequestMapping(value = "MovieDataUpdate.do", method = RequestMethod.GET)
	 * public String movieDataUpdate() { NaverMovieParsing naverParsing = new
	 * NaverMovieParsing(); MegaBoxParsing megaBoxParsing = new MegaBoxParsing();
	 * LotteParsing lotteParsing = new LotteParsing(); CgvParsing cgvParsing = new
	 * CgvParsing(); DaumMovieParsing daumParsing = new DaumMovieParsing();
	 * 
	 * List<ContentsValue> naverValues = new ArrayList<ContentsValue>();
	 * List<ContentsValue> megaBoxValues = new ArrayList<ContentsValue>();
	 * List<ContentsValue> lotteValues = new ArrayList<ContentsValue>();
	 * List<ContentsValue> cgvValues = new ArrayList<ContentsValue>();
	 * List<ContentsValue> daumValues = new ArrayList<ContentsValue>();
	 * 
	 * updateGrade(naverParsing, naverValues, "n"); updateGrade(daumParsing,
	 * daumValues, "d"); updateGrade(cgvParsing, cgvValues, "c");
	 * updateGrade(lotteParsing, lotteValues, "l"); updateGrade(megaBoxParsing,
	 * megaBoxValues, "m");
	 * 
	 * return "contents/insertResult"; }
	 * 
	 * @RequestMapping(value = "BookDateUpdate.do", method = RequestMethod.GET)
	 * public String bookDataUpdate(Model model, HttpServletRequest request) {
	 * 
	 * Yes24Parsing yes24Parsing = new Yes24Parsing(); AladinParsing aladinParsing
	 * = new AladinParsing(); BandinlunisParsing bandinlunisParsing = new
	 * BandinlunisParsing(); KyoboParsing kyoboParsing = new KyoboParsing();
	 * NaverBookParsing naverParsing = new NaverBookParsing();
	 * 
	 * List<ContentsValue> yes24Values = new ArrayList<ContentsValue>();
	 * List<ContentsValue> aladinValues = new ArrayList<ContentsValue>();
	 * List<ContentsValue> bandinlunisValues = new ArrayList<ContentsValue>();
	 * List<ContentsValue> kyoboValues = new ArrayList<ContentsValue>();
	 * List<ContentsValue> naverValues = new ArrayList<ContentsValue>();
	 * 
	 * updateGrade(naverParsing, naverValues, "nb"); updateGrade(yes24Parsing,
	 * yes24Values, "y"); updateGrade(kyoboParsing, kyoboValues, "k");
	 * updateGrade(aladinParsing, aladinValues, "a");
	 * updateGrade(bandinlunisParsing, bandinlunisValues, "b");
	 * 
	 * return "contents/insertResult"; }
	 * 
	 * @RequestMapping(value = "ContentsSearch.do", method = RequestMethod.GET)
	 * public String ContentsSearch(Model model, HttpServletRequest request)
	 * throws UnsupportedEncodingException { httpSession = request.getSession();
	 * httpSession.setAttribute("stat", request.getParameter("stat"));
	 * httpSession.setAttribute("category", request.getParameter("category")
	 * .trim()); System.out.println(httpSession.getAttribute("category")); List<?>
	 * resultList = null; String apiKey = "49c7c77a6538e00d4e35ffbccefb3e45";
	 * String uri;
	 * 
	 * String category = request.getParameter("category"); String searchQuery =
	 * (String) request.getParameter("Search").trim();
	 * System.out.println(searchQuery); NaverParse naverParse = new NaverParse();
	 * switch (category) { case "book": resultList = new ArrayList<NaverBook>();
	 * 
	 * uri = "http://openapi.naver.com/search?key=" + apiKey + "&target=book" +
	 * "&query=" + URLEncoder.encode(searchQuery, "UTF-8") + "&display=100";
	 * resultList = naverParse.bookParse(uri); System.out.println(uri); break;
	 * case "movie": resultList = new ArrayList<NaverMovie>(); uri =
	 * "http://openapi.naver.com/search?key=" + apiKey + "&target=movie" +
	 * "&query=" + URLEncoder.encode(searchQuery, "UTF-8") + "&display=100";
	 * System.out.println(uri); resultList = naverParse.movieParse(uri); break;
	 * default: break; } httpSession.setAttribute("resultList", resultList);
	 * 
	 * return "contents/contentsSearchList"; }
	 * 
	 * @RequestMapping(value = "currentMovieContext.do", method =
	 * RequestMethod.GET) public String getCurrentMovieContext(Model model,
	 * HttpServletRequest request) {
	 * 
	 * int num = Integer.parseInt(request.getParameter("num")); httpSession =
	 * request.getSession(); List<NaverMovie> list = (List<NaverMovie>)
	 * httpSession .getAttribute("movieList");
	 * httpSession.setAttribute("category", "movie");
	 * httpSession.setAttribute("stat", "search"); NaverMovie movie =
	 * list.get(num); return movieContextParsing(movie, request); }
	 * 
	 * @RequestMapping(value = "movieContext.do", method = RequestMethod.GET)
	 * public String getMovieContext(Model model, HttpServletRequest request) {
	 * 
	 * int num = Integer.parseInt(request.getParameter("num")); httpSession =
	 * request.getSession(); List<NaverMovie> list = (List<NaverMovie>)
	 * httpSession .getAttribute("resultList"); NaverMovie movie = list.get(num);
	 * return movieContextParsing(movie, request); }
	 * 
	 * @RequestMapping(value = "bookContext.do", method = RequestMethod.GET)
	 * public String getBookContext(Model model, HttpServletRequest request) {
	 * System.out.println("????"); int num =
	 * Integer.parseInt(request.getParameter("num")); httpSession =
	 * request.getSession(); List<NaverBook> list = (List<NaverBook>) httpSession
	 * .getAttribute("resultList"); NaverBook book = list.get(num); return
	 * bookContextParsing(book,request); }
	 * 
	 * @RequestMapping(value = "currentBookContext.do", method =
	 * RequestMethod.GET) public String getcurrentBookContext(Model model,
	 * HttpServletRequest request) { System.out.println("????"); int num =
	 * Integer.parseInt(request.getParameter("num")); httpSession =
	 * request.getSession(); List<NaverBook> list = (List<NaverBook>) httpSession
	 * .getAttribute("bookList"); httpSession.setAttribute("category", "book");
	 * httpSession.setAttribute("stat", "search"); NaverBook book = list.get(num);
	 * return bookContextParsing(book,request); }
	 * 
	 * private String bookContextParsing(NaverBook book, HttpServletRequest
	 * request) { book.setTitle(book.getTitle().replace("<b>", "").replace("</b>",
	 * "")); if (book.getTitle().contains("(")) {
	 * book.setTitle(book.getTitle().substring(0, book.getTitle().indexOf("(")));
	 * }
	 * 
	 * httpSession.setAttribute("book", book);
	 * 
	 * if (httpSession.getAttribute("stat").equals("search")) {
	 * System.out.println("까꿍2~"); Document doc; BookGrades grades = new
	 * BookGrades(); System.out.println("???" + book.getTitle()); grades =
	 * contentService.bookGradeSelect(book.getTitle());
	 * 
	 * try { doc = Jsoup.connect(book.getLink()).get();
	 * request.setAttribute("bookIntroContent",
	 * doc.select("div[id=bookIntroContent]").text());
	 * request.setAttribute("authorIntroContent",
	 * doc.select("div[id=authorIntroContent]").text());
	 * request.setAttribute("grades", grades);
	 * 
	 * String poster = "http://bookthumb.phinf.naver.net/" +
	 * book.getImage().substring(book.getImage().indexOf("cover/"),
	 * book.getImage().indexOf(".jpg")) + ".jpg"; request.setAttribute("poster",
	 * poster); if (grades != null) { int count = 0; double avg = 0; double arr[]
	 * = { grades.getAladinBg(), grades.getBandiBg(), grades.getKyoboBg(),
	 * grades.getNaverBg(), grades.getYesBg() }; for (double grade : arr) { if
	 * (grade != 0) { avg += grade; count++; } } request.setAttribute("avg", avg /
	 * count); } } catch (IOException e) { e.printStackTrace(); } return
	 * "contents/contentsContext"; } return "contents/contentsPostingWrite"; }
	 * 
	 * @RequestMapping(value = "postingInsert.do", method = RequestMethod.POST)
	 * public String postingInsert(Model model, HttpServletRequest request) {
	 * 
	 * String str = request.getParameter("postContext"); // DB에 추가 해야함 _
	 * request.setAttribute("posting", str); return
	 * "postandreply/contentsPostingResult"; }
	 * 
	 * private String movieContextParsing(NaverMovie movie, HttpServletRequest
	 * request) {
	 * 
	 * movie.setTitle(movie.getTitle().replace("<b>", "").replace("</b>", "")); if
	 * (movie.getTitle().contains("(")) {
	 * movie.setTitle(movie.getTitle().substring(0,
	 * movie.getTitle().indexOf("("))); } String code =
	 * movie.getImage().replace("A", "1").replace("B", "2") .replace("C",
	 * "3").replace("D", "4").replace("E", "5") .replace("F", "6"); if
	 * (code.contains("_")) { code = code.substring(code.lastIndexOf("/") + 1,
	 * code.indexOf("_")); } else code = code.substring(code.lastIndexOf("/") + 1,
	 * code.indexOf("-"));
	 * 
	 * httpSession.setAttribute("movie", movie); if
	 * (httpSession.getAttribute("stat").equals("search")) { Document doc;
	 * MovieGrades grades = new MovieGrades(); grades =
	 * contentService.movieGradeSelect(movie.getTitle()); if (grades != null) {
	 * int count = 0; double avg = 0; double arr[] = { grades.getCgvMg(),
	 * grades.getDaumMg(), grades.getLotteMg(), grades.getMegaBoxMg(),
	 * grades.getNaverMg() }; for (double grade : arr) { if (grade != 0) { avg +=
	 * grade; count++; } } request.setAttribute("avg", avg / count); } try { doc =
	 * Jsoup.connect(movie.getLink()).get(); request.setAttribute("genre",
	 * doc.select("p[class=info_spec] a[href*=genre").text());
	 * request.setAttribute("nation",
	 * doc.select("p[class=info_spec] a[href*=nation").text());
	 * request.setAttribute("open",
	 * doc.select("p[class=info_spec] a[href*=open").text());
	 * request.setAttribute("grade",
	 * doc.select("p[class=info_spec] a[href*=grade").text());
	 * request.setAttribute("count",
	 * doc.select("p[class=info_spec] span[class=count]") .text());
	 * request.setAttribute("context", doc.select("p[class=con_tx]") .text());
	 * request.setAttribute("grades", grades); String video = doc.select(
	 * "ul[class=photo_video] li a[href^=mediaView]").attr( "href"); doc =
	 * Jsoup.connect( "http://movie.naver.com/movie/bi/mi/" + video).get();
	 * request.setAttribute("video", "http://movie.naver.com" +
	 * doc.select("iframe[class=_videoPlayer]").attr("src"));
	 * System.out.println("http://movie.naver.com" +
	 * doc.select("iframe[class=_videoPlayer]").attr("src")); doc = Jsoup.connect(
	 * "http://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=" +
	 * code).get(); request.setAttribute("poster",
	 * doc.select("img[src]").attr("src"));
	 * 
	 * return "contents/contentsContext"; } catch (IOException e) {
	 * e.getStackTrace();
	 * 
	 * return "contents/contentsContext"; } } return
	 * "postandreply/contentsPostingWrite"; }
	 * 
	 * private void updateGrade(ContentsParsing Parsing, List<ContentsValue>
	 * Values, String str) { if (str.equals("n")) { DBCode dbCode = new DBCode();
	 * for (int i = 0; i < Parsing.getGradeList().size(); i++) { Values.add(new
	 * ContentsValue(Parsing.getTitleList().get(i), Parsing
	 * .getGradeList().get(i), Parsing.getCodeList().get(i), dbCode
	 * .getContentCD("m"))); } contentService.movieTitleInsert(Values); } if
	 * (str.equals("nb")) { DBCode dbCode = new DBCode(); for (int i = 0; i <
	 * Parsing.getGradeList().size(); i++) { Values.add(new
	 * ContentsValue(Parsing.getTitleList().get(i), Parsing
	 * .getGradeList().get(i), Parsing.getCodeList().get(i), dbCode
	 * .getContentCD("b"))); } contentService.bookTitleInsert(Values); } else for
	 * (int i = 0; i < Parsing.getGradeList().size(); i++) { Values.add(new
	 * ContentsValue(Parsing.getTitleList().get(i), Parsing
	 * .getGradeList().get(i))); } contentService.gradeUpdate(Values, str); }
	 */

}// Class End
