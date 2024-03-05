package com.demo.constants;

public enum EndPoints {

	EMPLOYEE("/employee");

	private String endpoint;

	EndPoints(String string) {
		endpoint = string;
	}

	public String getEndPoint() {
		return endpoint;
	}

}
