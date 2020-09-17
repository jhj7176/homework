package com.bit.dept.action;

import com.bit.dept.model.DeptDao;
import com.opensymphony.xwork2.Action;

public class DeptInsertAction implements Action {

	private String dname, loc;

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		DeptDao dao = new DeptDao();
		dao.insertOne(dname, loc);
		return Action.SUCCESS;
	}

}
