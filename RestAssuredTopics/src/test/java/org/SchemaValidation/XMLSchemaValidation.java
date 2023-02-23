package org.SchemaValidation;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidation {

	
	
	@Test
	private void toValidataXmlSchema() {
		File xmlSchema=new File("XmlSchema.xsd");
      RestAssured.baseURI="http://restapi.adequateshop.com";
      RestAssured.basePath="/api/Traveler";
      given()
      .get()
      .then()
      .body(RestAssuredMatchers.matchesXsdInClasspath(xmlSchema.toString()));
		
		
		
		
		
		
	}
	
	
	
	
}
