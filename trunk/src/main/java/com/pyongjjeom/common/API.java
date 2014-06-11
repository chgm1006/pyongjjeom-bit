package com.pyongjjeom.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.pyongjjeom.test.openAPI.APIParse;

public class API {
	private static final String NAVER_KEY = "fa605843289b5518f6f08bc683a22cdf";
	private static final String DAUM_MOVIE_KEY = "2a5f97d141e63ae9f33f9e6e7cf6c69433e0f050";
	private static final String DAUM_BOOK_KEY = "086e5a07b87dd1a134815bc18632848720df8732";

	private String naverURI = "http://openapi.naver.com/search ";
	private String daumBookURI = "http://apis.daum.net/search/book";
	private String daumMovieURI = "http://apis.daum.net/contents/movie";

	public String getDaumBookURI(String query) {
		API api = new API();
		String daumUri = "";

		try {
			daumUri = api.daumBookURI + "?apikey=" + API.DAUM_BOOK_KEY + "&q="
					+ URLEncoder.encode(query, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("getDaumBookURI 에러 : ");
			e.printStackTrace();
		}

		return daumUri;
	}

	public String getDaumMovieURI(String query) {
		API api = new API();
		String daumUri = "";

		try {
			daumUri = api.daumMovieURI + "?apikey=" + API.DAUM_MOVIE_KEY + "&q="
					+ query;
			URLEncoder.encode(query, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("getDaumMovieURI 에러 : ");
			e.printStackTrace();
		}

		return daumUri;
	}

	public String getNaverMovieURI(String query) {
		API api = new API();
		String daumUri = "";

		try {
			daumUri = api.daumMovieURI + "?apikey=" + API.DAUM_MOVIE_KEY + "&q="
					+ query;
			URLEncoder.encode(query, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("getDaumMovieURI 에러 : ");
			e.printStackTrace();
		}

		return daumUri;
	}

	public static void main(String[] args) {
		API api = new API();
		String uri = api.getDaumMovieURI("xman");

		APIParse apiParse = new APIParse();
		// apiParse.parse(uri);

		uri = api.getDaumBookURI("엑스맨");
		System.out.println(uri);
		apiParse.parse(uri);

	}
}
