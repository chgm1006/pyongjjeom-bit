package com.pyongjjeom.test.service;

import java.util.List;

import com.pyongjjeom.test.parsing.contents.ContentsValue;
import com.pyongjjeom.test.parsing.contents.MovieGrades;

public interface TestService {
	void movieTitleInsert(List<ContentsValue> Values);
	void bookTitleInsert(List<ContentsValue> values);
	void gradeUpdate(List<ContentsValue> Values,String str);
	MovieGrades movieGradeSelect(String title);
}
