package org.parsingXmlBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class RandomXmlResponse {
	@Test
	private void toValidateField() {
		RestAssured.baseURI = "http://restapi.adequateshop.com";
		RestAssured.basePath = "/api/Traveler";
		Response xmlResponse = given().queryParam("page", 1).get();
         XmlPath xmlObj= new XmlPath(xmlResponse.asString());
         List<String> list = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
         //To check developer is there in the "name" key in xml response
         for(String name:list) {
        	 if(name.equalsIgnoreCase("Developer")) {
        		 System.out.println("Developer is there in xml respose");
        		 break;
        	 }
         }
         
		
	}
}