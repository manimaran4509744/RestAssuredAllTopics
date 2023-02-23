package org.restAssuredTopics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class NonBddStyle {
	public static String idOfPost;
	public static String first_name;
	public static String first_name2;

	@Test(priority = 0)
	private void getEmployees() {

		RequestSpecification requestSpecification = RestAssured.given().basePath("/employees")
				.baseUri("http://localhost:3000");
		Response response = RestAssured.given().spec(requestSpecification).get();
		int statusCode = response.getStatusCode();
		String statusMessage = response.getStatusLine();
		String contentType = response.getContentType();
		String firstName = response.jsonPath().get("[0].first_name").toString();
		Assert.assertEquals(firstName, "Sebastian");
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(statusMessage, "HTTP/1.1 200 OK");
		Assert.assertEquals(contentType, "application/json; charset=utf-8");

	}

	@Test(priority = 1)
	private void createEmployees() throws FileNotFoundException {
		File jsonBody = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\CreateJson.json");
		FileInputStream fis = new FileInputStream(jsonBody);
		Response response = RestAssured.given().basePath("/employees").baseUri("http://localhost:3000")
				.contentType(ContentType.JSON).body(fis).post();

		int statusCode = response.getStatusCode();

		// String allBody = response.asPrettyString().toString();
		idOfPost = response.jsonPath().get("id").toString();
		first_name = response.jsonPath().get("first_Name").toString();
		System.out.println(response.asPrettyString());
		System.out.println(first_name);
		System.out.println(statusCode);

	}

	@Test(priority = 2)
	private void updateEmployees() throws FileNotFoundException {
		File jsonBody = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\UpdateJson.json");
		FileInputStream fis = new FileInputStream(jsonBody);
		Response response = RestAssured.given().basePath("/employees").baseUri("http://localhost:3000")
				.contentType(ContentType.JSON).body(fis).put("/" + idOfPost);
		String first_name2 = response.jsonPath().get("first_Name").toString();
		System.out.println(response.asPrettyString());
		Assert.assertNotEquals(first_name, first_name2);

	}

	@Test(priority = 3)
	private void deleteEmployees() {

		Response response = RestAssured.given().basePath("/employees").baseUri("http://localhost:3000")
				.delete("/" + idOfPost);
		String overAllResponse = response.asPrettyString();
		System.out.println(overAllResponse);
		

	}
}
