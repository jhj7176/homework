package com.bit.action;

import com.bit.model.entity.EmpVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class Step03Action implements Action, ModelDriven<EmpVo> {

	private EmpVo bean = new EmpVo();//파라미터가 넘어올 때 마다 객체 생성. 이전 값이 남을 일이 없다.
	
	
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


	@Override
	public EmpVo getModel() { 
		// TODO Auto-generated method stub
		System.out.println("get Method");
		
		return bean;
	}

}
