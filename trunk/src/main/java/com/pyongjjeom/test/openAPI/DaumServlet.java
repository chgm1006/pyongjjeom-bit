package com.pyongjjeom.test.openAPI;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pyongjjeom.common.DaumBook;
import com.pyongjjeom.common.DaumMovie;


/**
 * Servlet implementation class DaumServlet
 */
public class DaumServlet extends HttpServlet {
	private List<?> resultList;
	private String apiKey = "DAUM_SEARCH_DEMO_APIKEY";
	private String uri;
	private String resultPage;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int category = Integer.parseInt(request.getParameter("category"));
		String searchQuery = (String) request.getParameter("Search").trim();
		DaumParse daumParse = new DaumParse();

		switch (category) {
		case 0:
			resultList = new ArrayList<DaumBook>();
			uri = "http://apis.daum.net/search/book?q="
					+ URLEncoder.encode(searchQuery, "UTF-8")
					+ "&apikey=0daf987df65056e8b60c4302124e1e6708d36ebb";
			resultList = daumParse.bookParse(uri);
			resultPage = "resultDaumBook.jsp";
			System.out.println(resultList.toString());
			break;
		case 1:
			resultList = new ArrayList<DaumMovie>();
			uri = " http://apis.daum.net/contents/movie?apikey=4035f324c992b0137de59acbd52aca1546a829f7"
					+ "&q=" + URLEncoder.encode(searchQuery, "UTF-8");
			System.out.println(uri);
			resultList = daumParse.movieParse(uri);
			System.out.println(resultList.toString());
			resultPage = "resultDaumMovie.jsp";
			break;
		default:
			break;
		}

		request.setAttribute("resultList", resultList);
		request.getRequestDispatcher(resultPage).forward(request, response);
	}
}
