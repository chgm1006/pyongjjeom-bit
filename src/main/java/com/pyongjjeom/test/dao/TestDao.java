package com.pyongjjeom.test.dao;

import com.pyongjjeom.test.parsing.contents.ContentsValue;


public interface TestDao {

	void cgvGradeUpdate(ContentsValue contentsValue);
	void lotteGradeUpdate(ContentsValue contentsValue);
	void megaBoxGradeUpdate(ContentsValue contentsValue);
	void titleInsert(ContentsValue value);
	void naverGradeUpdate(ContentsValue value);

}
