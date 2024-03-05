package com.demo.builder;

import static io.restassured.RestAssured.*;

import com.demo.constants.EnvEnums;
import com.demo.utils.PropertyUtils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestBuilder {

	private RequestBuilder() {

	}

	public static RequestSpecification builRequestForGetCalls() {
		return given()
				.baseUri(PropertyUtils.getPropertyUtilInstance().getPropertyValue(EnvEnums.BASEURI))
				.log()
				.all();

	}

	public static RequestSpecification builRequestForPostCalls() {
		return builRequestForGetCalls()
				.contentType(ContentType.JSON);
		
	}
}
