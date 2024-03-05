package com.demo.customexception;

public class FIFOException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FIFOException(String message) {
		super(message);
	}

	public FIFOException(String message, Throwable cause) {
		super(message, cause);
	}
}
