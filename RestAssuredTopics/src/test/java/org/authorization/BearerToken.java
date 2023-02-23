package org.authorization;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BearerToken {
	@Test
	private void toValidateSuccessMessage() {
		String token = "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";
		RestAssured.baseURI = "https://api.github.com";
		RestAssured.basePath = "/user/repos";
		Response response = given().header("Authorization", "Bearer " + token).when().get();
		String statusMessage = response.getStatusLine();
		Assert.assertEquals(statusMessage, "HTTP/1.1 200 OK");
		String nameDetails = response.jsonPath().get("[0].full_name").toString();
		Assert.assertEquals(nameDetails, "manimaran290697/conditional");
		System.out.println(response.asPrettyString());

	}
}
