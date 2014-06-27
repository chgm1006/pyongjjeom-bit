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
				movie.setDirector(getContent(element, "director"));
				movie.setActor(getContent(element, "actor"));
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

	public List<?> bookParse(String uri) {
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
}
