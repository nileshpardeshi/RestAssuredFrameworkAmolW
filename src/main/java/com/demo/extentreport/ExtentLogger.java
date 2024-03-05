package com.demo.extentreport;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import static io.restassured.RestAssured.*;

import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(MarkupHelper.createCodeBlock(message,CodeLanguage.JSON));
//		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void logResponse(String message) {
		ExtentManager.getExtentTest().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
	}

	public static void setAuthor(String[] authorNames) {
		for (String author : authorNames) {
			ExtentManager.getExtentTest().assignAuthor(author);
		}

	}

	public static void setCategory(String[] tCCategory) {
		for (String category : tCCategory) {
			ExtentManager.getExtentTest().assignCategory(category);
		}

	}

	public static void logResponse(RequestSpecification requestSpecification) {
		QueryableRequestSpecification specification = SpecificationQuerier.query(requestSpecification);
		ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(specification.getBody(),CodeLanguage.JSON));
		for (Header header : specification.getHeaders()) {
			info(header.getName() + ":" + header.getValue());
		}
	}
}
