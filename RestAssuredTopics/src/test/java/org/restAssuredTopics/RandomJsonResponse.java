package org.restAssuredTopics;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RandomJsonResponse {
	@Test
	private void tovalidateRandomJsonResponse() {
		RestAssured.baseURI = "http://restapi.adequateshop.com/api/Tourist";
		Response response = given().get();
		JSONObject obj = new JSONObject(response.asString());
		boolean flag=false;
		for (int i = 0; i < obj.getJSONArray("data").length(); i++) {

			String tourist_name = obj.getJSONArray("data").getJSONObject(i).get("tourist_name").toString();
			
			if(tourist_name.equalsIgnoreCase(" krishna")) {
				
				flag=true;
				break;
			}
			
		}
		Assert.assertEquals(flag, true);

	}

}
