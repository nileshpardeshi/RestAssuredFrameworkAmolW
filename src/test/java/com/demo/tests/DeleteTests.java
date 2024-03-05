package com.demo.tests;

import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.annotations.CustomAnnotation;
import com.demo.builder.RequestBuilder;
import com.demo.listener.Listener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Listeners(Listener.class)
public final class DeleteTests {

	private DeleteTests() {	
	}
	
	@CustomAnnotation(author = "Amol", category = "Smoke", TCID = 32323)
	@Test
	public void deleteEmployeeDetails() {
		
		Response response=RequestBuilder.builRequestForGetCalls()
				.contentType(ContentType.JSON)
				.pathParam("id", "43")
				.delete("/employee/{id}");
		response.prettyPrint();
		assertThat(response.getStatusCode()).isEqualTo(200);
	}
	
}
