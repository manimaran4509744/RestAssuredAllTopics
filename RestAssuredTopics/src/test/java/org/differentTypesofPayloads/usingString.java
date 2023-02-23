package org.differentTypesofPayloads;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class usingString {

	
	@Test
	private void sendingPayloadUsingStringVariable() {
        String payload="{\r\n"
        		+ "    \r\n"
        		+ "    \"first_Name\": \"Saraswathi\",\r\n"
        		+ "    \"last_name\": \"Kumar\",\r\n"
        		+ "    \"email\": \"Saraswathi@gmail.com\"\r\n"
        		+ "    \r\n"
        		+ "  }";
		
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/employees";
		Response response = given().contentType(ContentType.JSON).body(payload).when().post();
		System.out.println(response.asPrettyString());

		String actualFirstName = response.jsonPath().get("first_Name").toString();
		String actualLastName = response.jsonPath().get("last_name").toString();
		String actualEmail = response.jsonPath().get("email").toString();
		
		Assert.assertEquals("Saraswathi", actualFirstName);
		Assert.assertEquals("Kumar", actualLastName);
		Assert.assertEquals("Saraswathi@gmail.com", actualEmail);
		
		
	

	}
}
