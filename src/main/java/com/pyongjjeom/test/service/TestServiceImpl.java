package com.pyongjjeom.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyongjjeom.test.dao.TestDao;
import com.pyongjjeom.test.parsing.contents.ContentsValue;


@Service("TestService")
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao testDao;

	public TestServiceImpl() {

	}

	 @Override
	 public void gradeUpdate(List<ContentsValue> values) {
	 ContentsValue contentsValue = values.get(0);
	 System.out.println(contentsValue.toString());
	 testDao.gradeUpdate(contentsValue);
	
	 }
}// end EmpServiceImpl
