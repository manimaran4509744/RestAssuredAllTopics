package org.requestChaining;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateTourist {

	@Test
	public void CreateTourist(ITestContext context) {
	  File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\restApiTraveler.json");
      RestAssured.baseURI="http://restapi.adequateshop.com";
      RestAssured.basePath="/api/Tourist";
      Response response=given()
       	.contentType(ContentType.JSON)
       	.body(file)
       	.when()
       	.post();
      System.out.println(response.asPrettyString());
      int idNumber=response.jsonPath().getInt("id");
      context.getSuite().setAttribute("id", idNumber);
      System.out.println(context.getAttribute("id"));
      System.out.println(idNumber);
      
	}
	
}
