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


	@Override
	public void gradeUpdate(List<ContentsValue> cgvValues,
			List<ContentsValue> lotteValues, List<ContentsValue> megaBoxValues) {

		for(int i=0 ; i<32; i++)
		{
			testDao.cgvGradeUpdate(cgvValues.get(i));
			testDao.lotteGradeUpdate(lotteValues.get(i));
			testDao.megaBoxGradeUpdate(megaBoxValues.get(i));
		}

	}

	@Override
	public void titleInsert(List<ContentsValue> Values) {
		for(ContentsValue value:Values)
		testDao.titleInsert(value);
	}

	@Override
	public void gradeUpdate(List<ContentsValue> naverValues) {
		for(ContentsValue value:naverValues)
		{
			testDao.naverGradeUpdate(value);
		}
	}

}// end EmpServiceImpl
