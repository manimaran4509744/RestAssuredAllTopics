package org.differentTypesofPayloads;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsingJsonObject {
	@Test
	private void sendingPayloadUsingStringVariable() {
        JSONObject obj=new JSONObject();
        obj.put("first_Name", "LekaAkka");
        obj.put("last_name", "SasiKumar");
        obj.put("email", "leka@gmail.com");
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/employees";
		Response response = given().contentType(ContentType.JSON).body(obj.toString()).when().post();
		System.out.println(response.asPrettyString());

		String actualFirstName = response.jsonPath().get("first_Name").toString();
		String actualLastName = response.jsonPath().get("last_name").toString();
		String actualEmail = response.jsonPath().get("email").toString();
		
		Assert.assertEquals("LekaAkka", actualFirstName);
		Assert.assertEquals("SasiKumar", actualLastName);
		Assert.assertEquals("leka@gmail.com", actualEmail);
		
		
	

	}

}
