package com.paypal.bfs.test.employeeserv.exception;

public class EmployeeServiceException extends  RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EmployeeServiceException(String message) {
		super();
		this.message = message;
	}
	
	
}
