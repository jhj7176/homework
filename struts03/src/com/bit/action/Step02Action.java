package com.bit.action;

import com.bit.model.entity.EmpVo;
import com.opensymphony.xwork2.Action;

public class Step02Action implements Action {

	private EmpVo bean = new EmpVo();
	
	
	
	public EmpVo getBean() {
		return bean;
	}



	public void setBean(EmpVo bean) {
		this.bean = bean;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(bean.toString());
		return Action.SUCCESS;
	}

}
