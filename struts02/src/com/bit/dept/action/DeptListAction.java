package com.bit.dept.action;

import java.util.ArrayList;

import com.bit.dept.model.DeptDao;
import com.bit.dept.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;

public class DeptListAction implements Action {

	ArrayList<DeptVo> list_;
	
	public ArrayList<DeptVo> getList() {
		return list_;
	}

	public void setList(ArrayList<DeptVo> list) {
		this.list_ = list;
	}

	@Override
	public String execute() throws Exception {

		DeptDao dao = new DeptDao();
		list_ = dao.selectAll();
		
		return Action.SUCCESS;
	}

}
