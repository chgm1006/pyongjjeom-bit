package com.pyongjjeom.test.service;

import java.util.List;

import com.pyongjjeom.test.parsing.contents.ContentsValue;

public interface TestService {

	void gradeUpdate(List<ContentsValue> cgvValues,
			List<ContentsValue> lotteValues, List<ContentsValue> megaBoxValues);

	void titleInsert(List<ContentsValue> Values);


	void gradeUpdate(List<ContentsValue> Values);
	/**
	 * <PRE>
	 * 간략 : 
	 * 상세 :
	 * </PRE>
	 * 
	 * @param naverValues
	 */
	void gradeUpdate(List<ContentsValue> naverValues);


}
