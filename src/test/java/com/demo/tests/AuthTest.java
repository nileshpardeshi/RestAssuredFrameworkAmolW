package com.demo.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public final class AuthTest {
	
	private AuthTest() {
		
	}

	@Test
	public void basicAuth() {
		Response response=given()
				.header("Authorization","Basic cG9zdG1hbjpwYXNzd29yZA==")
				.config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))
//				.auth()
//				.basic("postman", "password")
				.log()
				.all()
				.get("https://postman-echo.com/basic-auth");
		response.prettyPrint();
		assertThat(response.getStatusCode()).isEqualTo(200);
	}
}
