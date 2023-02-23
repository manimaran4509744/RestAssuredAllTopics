package org.authorization;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ApiKey {
	@Test()
	private void toValidateApiKeyMessage() {
		Response response = given().baseUri("https://api.openweathermap.org").pathParam("Path", "/data/2.5/weather")
				.queryParam("q", "London").queryParam("appid", "128ed31a2d3457e6c97495b1f8bbc3a4").when().get("{Path}");
		int statusCode = response.getStatusCode();
		String statusMessage = response.getStatusLine();
		String nameOfPlace = response.jsonPath().get("name").toString();
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(statusMessage, "HTTP/1.1 200 OK");
		Assert.assertEquals(nameOfPlace, "London");
		String prettyPrint = response.prettyPrint();
		String prettyString = response.asPrettyString();
		System.out.println(prettyString);

	}
}
