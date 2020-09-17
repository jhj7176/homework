package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex11Action implements Action {
	
	private int num;
	private String id;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("id = "+id+" num = "+num);
		return Action.SUCCESS;
	}

}
