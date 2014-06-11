package com.pyongjjeom.test.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Emp implements Serializable {

	private static final long serialVersionUID = 237654222L;
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private String hiredateStr; // 날짜 형식 변환을 위해 두었음
	private double sal;
	private double comm;
	private int deptno;
	private List<Dept> deptList; // formBacking때문에…
	private List<Integer> empnoList;// formBacking때문에…

	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getHiredateStr() {
		return hiredateStr;
	}

	public void setHiredateStr(String hiredateStr) {
		this.hiredateStr = hiredateStr;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public List<Integer> getEmpnoList() {
		return empnoList;
	}

	public void setEmpnoList(List<Integer> empnoList) {
		this.empnoList = empnoList;
	}

}
