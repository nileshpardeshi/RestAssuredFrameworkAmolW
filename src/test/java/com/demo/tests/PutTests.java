package com.demo.tests;

import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.Test;

import com.demo.annotations.CustomAnnotation;
import com.demo.builder.RequestBuilder;
import com.demo.pojo.Employee;
import com.demo.utils.RandomUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutTests {
	
	@CustomAnnotation(author = "Amol", category = "Smoke", TCID = 32323)
	@Test
	public void updateEmployeeDetails() {
		
		Employee employee = Employee.builder()
				.setFirstName(RandomUtils.getRandomFirstName())
				.setLastName(RandomUtils.getRandomLastName())
				.setEmail(RandomUtils.getRandomEmailID())
				.setProfession(RandomUtils.getRandomProfessionTitle())
				.build();
		
		Response response=RequestBuilder.builRequestForGetCalls()
				.contentType(ContentType.JSON)
				.pathParam("id","2")
				.body(employee)
				.put("/employee/{id}");
		response.prettyPrint();
		assertThat(response.getStatusCode()).isEqualTo(200);
	}

}
