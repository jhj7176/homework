package com.bit.action;

import com.bit.model.entity.EmpVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class Step04Action implements Action, ModelDriven<EmpVo>, Preparable {

	EmpVo bean;

	public EmpVo getBean() {
		return bean;
	}
	public void setBean(EmpVo bean) {
		this.bean = bean;
	}
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		bean = new EmpVo();
		System.out.println("prepare() : "+bean);
	}

	@Override
	public EmpVo getModel() {
		// TODO Auto-generated method stub
		System.out.println("getMethod()");
		return bean;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("execute() : "+bean);
		return Action.SUCCESS;
	}
}
