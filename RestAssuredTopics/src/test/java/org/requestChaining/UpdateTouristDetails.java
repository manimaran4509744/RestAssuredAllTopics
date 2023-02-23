package org.requestChaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateTouristDetails {
	@Test
	public void CreateTourist(ITestContext context) {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\UpdateRestApiTraveler.json");
		RestAssured.baseURI = "http://restapi.adequateshop.com";
		RestAssured.basePath = "/api/Tourist";
		Object id = context.getAttribute("id");
		int idNew=(Integer)id;
		Response response = given().contentType(ContentType.JSON).body(file).when()
				.put("/" + idNew);
		System.out.println(response.asPrettyString());
		String tourist_name = response.jsonPath().get("tourist_name").toString();
		String tourist_email = response.jsonPath().get("tourist_email").toString();
		String tourist_location = response.jsonPath().get("tourist_location").toString();
		String createdat = response.jsonPath().get("createdat").toString();
		Assert.assertEquals(tourist_name, "Kumar");
		Assert.assertEquals(tourist_email, "Kumar233@Yahoo.com");
		Assert.assertEquals(tourist_location, "India");
		Assert.assertEquals(createdat, "2023-02-21T05:08:23.926Z");

	}
}
