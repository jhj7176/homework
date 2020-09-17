package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex01Action implements Action {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("스트럿츠로 화면을 출력하겠습니다.");
		return "success";
	}

	
}
