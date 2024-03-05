package com.demo.customexception;

public class PropFileNotFoundException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public PropFileNotFoundException(String mesage) {
		super(mesage);
	}
	

	public PropFileNotFoundException(String mesage, Throwable cause) {
		super(mesage, cause);
	}
}
