package org.restAssuredTopics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BddStyle {
	public int id;

	@Test(priority = 0)
	private void getEmployees() {
		given().baseUri("http://localhost:3000").basePath("/employees").when().get().then().statusCode(200)
				.body("[0].first_name", equalTo("Sebastian")).log().headers();

	}

	@Test(priority = 1)
	private void createEmployee() {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\CreateJson.json");
		Response response = given().basePath("/employees").baseUri("http://localhost:3000")
				.contentType(ContentType.JSON).body(file).when().post();
		id = response.jsonPath().getInt("id");
		System.out.println(response.asPrettyString());

	}

	@Test(priority = 2)
	private void updateEmployee() {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\UpdateJson.json");
		given().basePath("/employees").baseUri("http://localhost:3000").contentType(ContentType.JSON).body(file).when()
				.put("/" + id).then().statusCode(200).statusLine("HTTP/1.1 200 OK").log().body();

	}

	@Test(priority = 3)
	private void deleteEmployee() {
		given().basePath("/employees").baseUri("http://localhost:3000").when().delete("/" + id).then().statusCode(200)
				.statusLine("HTTP/1.1 200 OK").log().body();

	}

}
