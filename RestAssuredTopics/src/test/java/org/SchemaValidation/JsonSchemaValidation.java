package org.SchemaValidation;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class JsonSchemaValidation {
	@Test
	private void toValidataSchema() {

		File jsonFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\CreateJson.json");
		
		File schema=new File("JsonSchema.json");
		given().basePath("/employees").baseUri("http://localhost:3000")
				.contentType(ContentType.JSON).body(jsonFile).when().post()
				.then().statusCode(201)
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schema.toString()));
		
		
		
		
	}

}
