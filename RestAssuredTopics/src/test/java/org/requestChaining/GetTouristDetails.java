package org.requestChaining;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTouristDetails {

	@Test
	private void getTourist(ITestContext context) {

		RestAssured.baseURI = "http://restapi.adequateshop.com";
		RestAssured.basePath = "/api/Tourist";
		Object id = context.getAttribute("id");
		int idNew=(Integer)id;
		Response response = given().get("/"+idNew);
		String tourist_name=response.jsonPath().get("tourist_name").toString();
		String tourist_email=response.jsonPath().get("tourist_email").toString();
		String tourist_location=response.jsonPath().get("tourist_location").toString();
		String createdat=response.jsonPath().get("createdat").toString();
		Assert.assertEquals(tourist_name, "Manimaran");
		Assert.assertEquals(tourist_email, "Akash213%Mani@Yahoo.com");
		Assert.assertEquals(tourist_location, "India");
		Assert.assertEquals(createdat, "2023-02-21T05:08:23.926Z");
		

	}

}
