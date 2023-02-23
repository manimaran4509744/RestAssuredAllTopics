package org.parsingXmlBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class NonBddStyle {
	@Test
	private void toValidateField() {

		RestAssured.baseURI = "http://restapi.adequateshop.com";
		RestAssured.basePath = "/api/Traveler";
		Response xmlResponse = given().queryParam("page", 1).get();
		String actualName = xmlResponse.xmlPath()
				.get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(actualName, "Developer");
	}
}
