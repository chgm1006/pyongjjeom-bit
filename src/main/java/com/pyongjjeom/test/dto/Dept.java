package com.pyongjjeom.test.dto;

import java.io.Serializable;

public class Dept implements Serializable {
	private static final long serialVersionUID = 121321321;

	private int deptno;
	private String dname;
	private String loc;

	public Dept() {
		// TODO Auto-generated constructor stub
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
