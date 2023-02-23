package org.parsingXmlBody;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class BddStyle {
	@Test
	private void toValidateField() {

		RestAssured.baseURI="http://restapi.adequateshop.com";
		RestAssured.basePath="/api/Traveler";
		given().queryParam("page", 1)
		.get()
		.then()
	    .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo( "Developer"));
		
		
	}

}
