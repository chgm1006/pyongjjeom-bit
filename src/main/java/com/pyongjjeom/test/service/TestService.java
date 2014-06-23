package com.pyongjjeom.test.service;

import java.util.List;

import com.pyongjjeom.test.parsing.contents.ContentsValue;

public interface TestService {
	void titleInsert(List<ContentsValue> Values);
	void gradeUpdate(List<ContentsValue> Values,String str);
}
