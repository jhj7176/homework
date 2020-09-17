package com.bit.dept.action;

import com.bit.dept.model.DeptDao;
import com.bit.dept.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;

public class DeptOneAction implements Action {

	private DeptVo bean;
	private int deptno;
	
	public DeptVo getBean() {
		return bean;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		DeptDao dao = new DeptDao();
		bean = dao.selectOne(deptno);
		return Action.SUCCESS;
	}

}
