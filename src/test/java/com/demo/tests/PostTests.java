package com.demo.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.annotations.CustomAnnotation;
import com.demo.builder.RequestBuilder;
import com.demo.constants.FrameworkConstants;
import com.demo.extentreport.ExtentLogger;
import com.demo.listener.Listener;
import com.demo.pojo.Employee;
import com.demo.utils.ApiUtils;
import com.demo.utils.RandomUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(Listener.class)
public class PostTests {

	@CustomAnnotation(author = "Amol", category = "Smoke", TCID = 32323)
	@Test
	public void postEmployeeData() {
		Employee employee = Employee.builder()
				.setFirstName(RandomUtils.getRandomFirstName())
				.setLastName(RandomUtils.getRandomLastName())
				.setEmail(RandomUtils.getRandomEmailID())
				.setProfession(RandomUtils.getRandomProfessionTitle())
				.setId(RandomUtils.getID())
				.build();
		
		RequestSpecification requestSpecification=RequestBuilder.builRequestForPostCalls()
				.body(employee);

		ExtentLogger.logResponse(requestSpecification);
		Response response =requestSpecification.post("/employee");
		response.prettyPrint();
		ApiUtils.storeJsonAndGetAsString(FrameworkConstants.getFCInstance().getOutputJsonResponsePath(), response);
		assertThat(response.getStatusCode()).isEqualTo(201);

	}
	
	@CustomAnnotation(author = "Amol", category = "Smoke", TCID = 32323)
	@Test
	public void postEmployeeDataFromExternalFile() {
		String resource= ApiUtils.readJsonAndGetAsString(FrameworkConstants.getFCInstance().getRequestJsonPath());
		Response response=RequestBuilder.builRequestForPostCalls()
				.body(resource)
				.post("/employee");
		response.prettyPrint();
		assertThat(response.getStatusCode()).isEqualTo(201);
		
		
	}

}
