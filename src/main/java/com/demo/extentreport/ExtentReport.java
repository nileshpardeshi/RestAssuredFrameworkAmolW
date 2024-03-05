package com.demo.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {

	private ExtentReport() {

	}

	private static ExtentReports extentReports;

	public static void initExtentReport() {
		extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("index.html");
		extentReports.attachReporter(sparkReporter);
	}

	public static void flushExtentReport() {
		extentReports.flush();
	}

	public static void createTest(String string) {
		ExtentTest extentTest = extentReports.createTest(string);
		ExtentManager.setExtentTest(extentTest);
	}
}
