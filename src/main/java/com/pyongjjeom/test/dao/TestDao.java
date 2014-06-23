package com.pyongjjeom.test.dao;

import com.pyongjjeom.test.parsing.contents.ContentsValue;


public interface TestDao {

	void titleInsert(ContentsValue value);
	void cgvGradeUpdate(ContentsValue contentsValue);
	void lotteGradeUpdate(ContentsValue contentsValue);
	void megaBoxGradeUpdate(ContentsValue contentsValue);
	void naverGradeUpdate(ContentsValue value);
	void daumGradeUpdate(ContentsValue value);

}
