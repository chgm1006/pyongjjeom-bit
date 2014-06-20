package com.pyongjjeom.test.service;

import java.util.List;

import com.pyongjjeom.test.parsing.contents.ContentsValue;


public interface TestService {

	void gradeUpdate(List<ContentsValue> cgvValues,List<ContentsValue> lotteValues,List<ContentsValue> megaBoxValues);

	void titleInsert(List<ContentsValue> cgvValues);

}
