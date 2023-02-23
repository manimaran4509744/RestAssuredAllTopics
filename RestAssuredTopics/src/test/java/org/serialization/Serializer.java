package org.serialization;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Serializer {
    @Test
	private void UsingPojoObject() 
	{
		MakingPojoIntoJsonUsingSerialization obj = new MakingPojoIntoJsonUsingSerialization();
		obj.setFirst_Name("Jaishri");
		obj.setLast_name("Arul");
		obj.setEmail("Jaishri@gmail.com");
		ObjectMapper mapper = new ObjectMapper();
		String payload = null;
		try {
			payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/employees";
		Response response = given().contentType(ContentType.JSON).body(payload).when().post();
		System.out.println(response.asPrettyString());

		String actualFirstName = response.jsonPath().get("first_Name").toString();
		String actualLastName = response.jsonPath().get("last_name").toString();
		String actualEmail = response.jsonPath().get("email").toString();

		Assert.assertEquals(obj.getFirst_Name(), actualFirstName);
		Assert.assertEquals(obj.getLast_name(), actualLastName);
		Assert.assertEquals(obj.getEmail(), actualEmail);

	}


}
