package com.demo.customexception;

public class InvalidKeyException extends FrameworkException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidKeyException(String message) {
		super(message);
	}
	
	public InvalidKeyException(String message, Throwable cause) {
		super(message, cause);
	}

}
