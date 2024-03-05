package com.demo.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.annotations.CustomAnnotation;
import com.demo.basetest.BaseTest;
import com.demo.builder.RequestBuilder;
import com.demo.constants.EndPoints;
import com.demo.extentreport.ExtentLogger;
import com.demo.listener.Listener;

import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;

@Listeners(Listener.class)
public class GetTests extends BaseTest{
	
	@CustomAnnotation(author = "Amol", category = "Smoke", TCID = 2321)
	@Test(description = "To get employee data")
	public void getEmployees() {
			Response response=RequestBuilder
					.builRequestForGetCalls()
				    .get(EndPoints.EMPLOYEE.getEndPoint());
			response.prettyPrint();
			assertThat(response.getStatusCode()).as("Status code for get call").isEqualTo(200).isNotNull();
			ExtentLogger.pass(response.asPrettyString());
	}
	
	@CustomAnnotation(author = "Amol", category = "Smoke", TCID = 32323)
	@Test
	public void getEmployeeDetails() {
			Response response=RequestBuilder.builRequestForGetCalls()
					.pathParam("id", 2)
				    .get("/employee/{id}");
			response.prettyPrint();
			assertThat(response.getStatusCode()).as("Status code for get call").isEqualTo(200);
			assertThat(response.jsonPath().getString("lastName")).isEqualTo("Kuhlman");
	}
}
