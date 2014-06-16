package com.pyongjjeom.test.openAPI;

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

import com.pyongjjeom.common.DaumBook;
import com.pyongjjeom.common.DaumMovie;


public class DaumParse {

	public static String getBookContent(Element element, String tagName) {

		NodeList list = element.getElementsByTagName(tagName);
		Element cElement = (Element) list.item(0);
		if (cElement.getFirstChild() != null) {
			return cElement.getFirstChild().getNodeValue();
		} else {
			return "";
		}
	}

	public static String getMovieContent(Element element, String tagName) {

		NodeList list = element.getElementsByTagName(tagName);
		Element cElement = (Element) list.item(0);
		NodeList innerList = cElement.getElementsByTagName("content");
		Element cElement2 = (Element) innerList.item(0);
		if (cElement2.getFirstChild() != null) {
			return cElement2.getFirstChild().getNodeValue();
		} else {
			return "";
		}
	}

	public List<DaumBook> bookParse(String uri) {
		List<DaumBook> resultList = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("item");

			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				DaumBook contents = new DaumBook();

				contents.setTitle(getBookContent(element, "title"));
				contents.setLink(getBookContent(element, "link"));
				contents.setCover_l_url(getBookContent(element, "cover_s_url"));
				contents.setCover_s_url(getBookContent(element, "cover_l_url"));
				contents.setDescription(getBookContent(element, "description"));
				contents.setAuthor(getBookContent(element, "author"));
				contents.setTranslator(getBookContent(element, "translator"));
				contents.setPub_nm(getBookContent(element, "pub_nm"));
				contents.setPub_date(getBookContent(element, "pub_date"));
				contents.setCategory(getBookContent(element, "category"));
				contents.setIsbn(getBookContent(element, "isbn"));
				contents.setIsbn13(getBookContent(element, "isbn13"));
				contents.setSale_yn(getBookContent(element, "sale_yn"));
				contents.setList_price(getBookContent(element, "list_price"));
				contents.setSale_price(getBookContent(element, "sale_price"));
				contents.setStatus_des(getBookContent(element, "status_des"));
				contents.setBarcode(getBookContent(element, "barcode"));
				contents.setEbook_barcode(getBookContent(element,
						"ebook_barcode"));
				resultList.add(contents);

			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultList;

	}

	public List<DaumMovie> movieParse(String uri) {
		List<DaumMovie> resultList = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("item");

			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				DaumMovie contents = new DaumMovie();

				contents.setThumbnail(getMovieContent(element, "thumbnail"));
				contents.setTitle(getMovieContent(element, "title"));
				contents.setEng_title(getMovieContent(element, "eng_title"));
				contents.setOgr_title(getMovieContent(element, "ogr_title"));
				contents.setKword(getMovieContent(element, "kword"));
				contents.setYear(getMovieContent(element, "year"));
				contents.setTrailer(getMovieContent(element, "trailer"));
				contents.setCgv_res(getMovieContent(element, "cgv_res"));
				contents.setRes(getMovieContent(element, "res"));
				contents.setDirector(getMovieContent(element, "director"));
				contents.setActor(getMovieContent(element, "actor"));
				contents.setMore_actor(getMovieContent(element, "more_actor"));
				contents.setNation(getMovieContent(element, "nation"));
				contents.setGenre(getMovieContent(element, "genre"));
				contents.setOpen_info(getMovieContent(element, "open_info"));
				contents.setHomepage(getMovieContent(element, "homepage"));
				contents.setVideo_info(getMovieContent(element, "video_info"));
				contents.setVideo(getMovieContent(element, "video"));
				contents.setPhoto_info(getMovieContent(element, "photo_info"));
				contents.setPhoto1(getMovieContent(element, "photo1"));
				contents.setPhoto2(getMovieContent(element, "photo2"));
				contents.setPhoto3(getMovieContent(element, "photo3"));
				contents.setPhoto4(getMovieContent(element, "photo4"));
				contents.setPhoto5(getMovieContent(element, "photo5"));
				contents.setGrades(getMovieContent(element, "grades"));
				contents.setWrite_grades(getMovieContent(element,
						"write_grades"));
				contents.setExpect_grades(getMovieContent(element,
						"expect_grades"));
				contents.setGrade1(getMovieContent(element, "grade1"));
				contents.setGrade2(getMovieContent(element, "grade2"));
				contents.setGrade3(getMovieContent(element, "grade3"));
				contents.setCategory(getMovieContent(element, "category"));
				contents.setNews_info(getMovieContent(element, "news_info"));
				contents.setNews1(getMovieContent(element, "news1"));
				contents.setNews2(getMovieContent(element, "news2"));
				contents.setNews3(getMovieContent(element, "news3"));
				contents.setEvent(getMovieContent(element, "event"));
				contents.setAge_grades(getMovieContent(element, "age_grades"));
				contents.setReview_cnt(getMovieContent(element, "review_cnt"));
				contents.setStory(getMovieContent(element, "story"));
				contents.setWiki_name(getMovieContent(element, "wiki_name"));
				contents.setWiki_info(getMovieContent(element, "wiki_info"));
				contents.setWiki_url(getMovieContent(element, "wiki_url"));
				contents.setReview(getMovieContent(element, "review"));

				resultList.add(contents);

			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultList;

	}
}
