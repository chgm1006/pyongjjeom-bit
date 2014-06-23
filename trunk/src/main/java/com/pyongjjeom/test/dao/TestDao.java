package com.pyongjjeom.test.dao;

import com.pyongjjeom.test.parsing.contents.ContentsValue;


public interface TestDao {

	void movieTitleInsert(ContentsValue value);
	void bookTitleInsert(ContentsValue value);
	
	
	void cgvGradeUpdate(ContentsValue contentsValue);
	void lotteGradeUpdate(ContentsValue contentsValue);
	void megaBoxGradeUpdate(ContentsValue contentsValue);
	void naverMovieGradeUpdate(ContentsValue value);
	void daumGradeUpdate(ContentsValue value);

	
	void yes24GradeUpdate(ContentsValue contentsValue);
	void aladinGradeUpdate(ContentsValue contentsValue);
	void kyoboGradeUpdate(ContentsValue contentsValue);
	void naverBookGradeUpdate(ContentsValue value);
	void bandinlunisGradeUpdate(ContentsValue value);

}
