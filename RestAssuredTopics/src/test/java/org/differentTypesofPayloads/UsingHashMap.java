package org.differentTypesofPayloads;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsingHashMap {

	@Test
	private void sendingPayloadUsingHashmap() {
		Map<String, String> map = new HashMap();
		map.put("first_Name", "Mr.perfect");
		map.put("last_name", "Kumar");
		map.put("email", "Mr.perfect@gmail.com");

		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/employees";
		Response response = given().contentType(ContentType.JSON).body(map).when().post();
		System.out.println(response.asPrettyString());

		String actualFirstName = response.jsonPath().get("first_Name").toString();
		String actualLastName = response.jsonPath().get("last_name").toString();
		String actualEmail = response.jsonPath().get("email").toString();
		
		Assert.assertEquals("Mr.perfect", actualFirstName);
		Assert.assertEquals("Kumar", actualLastName);
		Assert.assertEquals("Mr.perfect@gmail.com", actualEmail);

	}

}
