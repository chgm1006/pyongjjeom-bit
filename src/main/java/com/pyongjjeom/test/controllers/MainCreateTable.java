package com.pyongjjeom.test.controllers;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainCreateTable {
	public static void main(String[] args) {

		@SuppressWarnings("deprecation")
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
				"DataTable.xml"));

		CreateTable myBean = (CreateTable) beanFactory.getBean("CreateTable");
		myBean.doExecute();
		myBean.doInsert();
	}
}
