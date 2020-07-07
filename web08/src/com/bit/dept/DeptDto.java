package com.bit.dept;

import java.sql.Date;

public class DeptDto {
	
	private int num;
	private String lev, id, name, pw;
	private Date dtime;
	private boolean result;
	
	public boolean isResult() {
		return result;
	}
	
	public void setResult(boolean result) {
		this.result = result;
	}
	
	public Date getDtime() {
		return dtime;
	}
	public void setDtime(Date dtime) {
		this.dtime = dtime;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	



}
