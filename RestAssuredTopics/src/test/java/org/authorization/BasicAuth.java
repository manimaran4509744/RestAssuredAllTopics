package org.authorization;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class BasicAuth {

	@Test()
	private void toValidateBasicAuth() {

		Response response = given().baseUri("https://postman-echo.com").basePath("/basic-auth").auth()
				.basic("postman", "password").when().get();
		String authBodyMessage = response.jsonPath().get("authenticated").toString();
		System.out.println(response.asPrettyString());
		Assert.assertEquals(authBodyMessage, "true");

	}
}
