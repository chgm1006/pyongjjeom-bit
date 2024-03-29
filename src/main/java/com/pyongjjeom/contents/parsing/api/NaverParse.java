package com.pyongjjeom.contents.parsing.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.pyongjjeom.common.NaverBook;
import com.pyongjjeom.common.NaverMovie;

public class NaverParse {

	public static String getContent(Element element, String tagName) {

		NodeList list = element.getElementsByTagName(tagName);
		Element cElement = (Element) list.item(0);

		if (cElement.getFirstChild() != null) {
			return cElement.getFirstChild().getNodeValue();
		} else {
			return "";
		}
	}

	public List<NaverMovie> movieParse(String uri) {
		List<NaverMovie> test = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("item");

			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				NaverMovie movie = new NaverMovie();
				movie.setTitle(getContent(element, "title"));
				movie.setSubtitle(getContent(element, "subtitle"));
				movie.setLink(getContent(element, "link"));
				movie.setImage(getContent(element, "image"));
				movie.setDirector(getContent(element, "director").replace("|", " "));
				movie.setActor(getContent(element, "actor").replace("|", " "));
				movie.setPubDate(getContent(element, "pubDate"));
				movie.setUserRating(getContent(element, "userRating"));

				test.add(movie);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return test;
	}

	public List<NaverBook> bookParse(String uri) {
		List<NaverBook> test = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("item");

			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				NaverBook book = new NaverBook();
				book.setTitle(getContent(element, "title"));
				book.setLink(getContent(element, "link"));
				book.setImage(getContent(element, "image"));
				book.setAuthor(getContent(element, "author"));
				book.setPrice(getContent(element, "price"));
				book.setDiscount(getContent(element, "discount"));
				book.setPublisher(getContent(element, "publisher"));
				book.setPubdate(getContent(element, "pubdate"));
				book.setIsbn(getContent(element, "isbn"));
				book.setDescription(getContent(element, "description"));

				test.add(book);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return test;
	}

	public NaverMovie currentMovieParse(String uri) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		NaverMovie movie = new NaverMovie();
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("item");

			Element element = (Element) list.item(0);

			movie.setTitle(getContent(element, "title"));
			movie.setSubtitle(getContent(element, "subtitle"));
			movie.setLink(getContent(element, "link"));
			movie.setImage(getContent(element, "image"));
			movie.setDirector(getContent(element, "director").replace("|", " "));
			movie.setActor(getContent(element, "actor").replace("|", " "));
			movie.setPubDate(getContent(element, "pubDate"));
			movie.setUserRating(getContent(element, "userRating"));

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movie;
	}

	public NaverBook currentBookParse(String uri) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		NaverBook book = new NaverBook();
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("item");

			Element element = (Element) list.item(0);

			book.setTitle(getContent(element, "title"));
			book.setLink(getContent(element, "link"));
			book.setImage(getContent(element, "image"));
			book.setAuthor(getContent(element, "author"));
			book.setPrice(getContent(element, "price"));
			book.setDiscount(getContent(element, "discount"));
			book.setPublisher(getContent(element, "publisher"));
			book.setPubdate(getContent(element, "pubdate"));
			book.setIsbn(getContent(element, "isbn"));
			book.setDescription(getContent(element, "description"));

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return book;
	}

	public String movieImageParse(String uri) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		String link = null;
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("item");

			Element element = (Element) list.item(0);
			link = getContent(element, "link");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			link = "";
		}
		return link;
	}

}
