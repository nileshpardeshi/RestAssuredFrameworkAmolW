package com.demo.extentreport;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> tlLocal = new ThreadLocal<>();

	static ExtentTest getExtentTest() {
		return tlLocal.get();
	}

	static void setExtentTest(ExtentTest extentTest) {
		tlLocal.set(extentTest);
	}

}
