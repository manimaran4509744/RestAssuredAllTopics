package org.requestChaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTouristDetails {
	@Test
	private void getTourist(ITestContext context) {
		Object id = context.getAttribute("id");
		int idNew=(Integer)id;
		RestAssured.baseURI = "http://restapi.adequateshop.com";
		RestAssured.basePath = "/api/Tourist";
		Response response = given().delete("/"+idNew);
		System.out.println(response.asPrettyString());
		}

}
