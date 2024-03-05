package com.demo.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demo.annotations.CustomAnnotation;
import com.demo.extentreport.ExtentLogger;
import com.demo.extentreport.ExtentManager;
import com.demo.extentreport.ExtentReport;

public class Listener implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initExtentReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getName());
		ExtentLogger.setAuthor(
				result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).author());
		ExtentLogger.setCategory(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(CustomAnnotation.class).category());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName() + "is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(String.valueOf(result.getThrowable()));
	}
}
