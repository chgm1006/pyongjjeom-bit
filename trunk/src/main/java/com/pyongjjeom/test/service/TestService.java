package com.pyongjjeom.test.service;

import java.util.List;

import com.pyongjjeom.test.parsing.contents.ContentsValue;

public interface TestService {
	void movieTitleInsert(List<ContentsValue> Values);
	void bookTitleInsert(List<ContentsValue> values);
	
	void gradeUpdate(List<ContentsValue> Values,String str);
}
