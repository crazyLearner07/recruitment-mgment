package com.hr.recruitment.api.exception;

public class BusinessValidationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public BusinessValidationException(String msg){
		super(msg);
		this.setMsg(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
