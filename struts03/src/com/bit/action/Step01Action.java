package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Step01Action implements Action {
	
	private int sabun;
	private String name;

	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("sabun = "+sabun+" name= "+name);
		return Action.SUCCESS;
	}

}
