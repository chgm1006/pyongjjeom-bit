package com.pyongjjeom.test.openAPI;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.pyongjjeom.common.ItemArr;

public class APIParse {

	public static String getContent(Element element, String tagName) {
		NodeList list = element.getElementsByTagName(tagName);
		Element cElement = (Element) list.item(0);

		String result = "";
		if (cElement.getFirstChild() != null) {
			result = cElement.getFirstChild().getNodeValue();
		} else {
			result = "";
		}

		return result;
	}

	public void parse(String uri) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("item");

			System.out.println("ItemArr.DAUM_B_DESC_ARR.length = "
					+ ItemArr.DAUM_M_DESC_ARR.length);
			System.out.println("ItemArr.DAUM_B_DESC_ARR.length = "
					+ ItemArr.DAUM_M_TAG_ARR.length);
			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);

				System.out.println("1111");
				for (int j = 0; j < ItemArr.DAUM_B_DESC_ARR.length; j++) {
					// if (getContent(element, ItemArr.DAUM_B_TAG_ARR[j]) != null) {
					System.out.println(ItemArr.DAUM_B_DESC_ARR[j] + " : "
							+ getContent(element, ItemArr.DAUM_B_TAG_ARR[j]));
					// }

				}
				System.out.println();
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.print("APIParse.parse : ");
			e.printStackTrace();
		}
	}
}
