package com.bit.dept.model;

import com.bit.dept.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;

public class DeptTest implements Action {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		DeptDao dao = new DeptDao();
		System.out.println("connected"+dao.conn);
		for (DeptVo bean : dao.selectAll()) {
			System.out.println(bean);
		}
		
		return Action.SUCCESS;
	}

}
