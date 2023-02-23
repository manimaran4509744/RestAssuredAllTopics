package org.authorization;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

public class DigestAuth {

	@Test()
	private void toValidateBasicAuth() {

		Response response = given().baseUri("https://postman-echo.com").basePath("/basic-auth").auth()
				.digest("postman", "password").when().get();
		String authBodyMessage = response.jsonPath().get("authenticated").toString();
		System.out.println(response.asPrettyString());
		Assert.assertEquals(authBodyMessage, "true");

	}
}
