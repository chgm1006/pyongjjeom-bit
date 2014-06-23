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
	public void titleInsert(List<ContentsValue> Values) {
		for (ContentsValue value : Values)
			testDao.titleInsert(value);
	}
	@Override
	public void gradeUpdate(List<ContentsValue> values, String str) {
		// switch (str) {
		// case "n":
		// for (ContentsValue value : values) {
		// testDao.naverGradeUpdate(value);
		// }
		// break;
		// case "d":
		// for (ContentsValue value : values) {
		// testDao.daumGradeUpdate(value);
		// }
		// break;
		// case "c":
		// for (ContentsValue value : values) {
		// testDao.cgvGradeUpdate(value);
		// }
		// break;
		// case "l":
		// for (ContentsValue value : values) {
		// testDao.lotteGradeUpdate(value);
		// }
		// break;
		// case "m":
		// for (ContentsValue value : values) {
		// testDao.megaBoxGradeUpdate(value);
		// }
		// break;
		//
		// default:
		// break;
		// }
		//
		for (ContentsValue value : values) {
			switch (str) {
			case "n":
				testDao.naverGradeUpdate(value);
				break;
			case "d":
				testDao.daumGradeUpdate(value);
				break;
			case "c":
				testDao.cgvGradeUpdate(value);
				break;
			case "m":
				testDao.megaBoxGradeUpdate(value);
				break;
			case "l":
				testDao.lotteGradeUpdate(value);
				break;
			default:
				break;
			}
		}
	}
}// end EmpServiceImpl
