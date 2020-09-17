package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex02Action implements Action {

	
//	Action 인터페이스에서 기본적으로 가지고 있는 상수들.
//	  public static final java.lang.String SUCCESS = "success";
//	  
//	  public static final java.lang.String NONE = "none";
//	  
//	  public static final java.lang.String ERROR = "error";
//	  
//	  public static final java.lang.String INPUT = "input";
//	  
//	  public static final java.lang.String LOGIN = "login";
	
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Ex02 action");
		//return SUCCESS;
		return Action.SUCCESS;
	}

}
