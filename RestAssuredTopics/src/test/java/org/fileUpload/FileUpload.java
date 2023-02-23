package org.fileUpload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FileUpload {

	@Test
	private void toValidateSuccessMessage() {

		RestAssured.baseURI = "https://api.upload.io";
		RestAssured.basePath = "/v1/files/form_data?";
		Response response = given()
				.multiPart("file", System.getProperty("user.dir") + "\\src\\test\\resources\\FileUpload.txt").post();
		String actualStatusLine = response.getStatusLine();
		String actualContentType = response.getContentType();
		String expectedContentType = "application/json; charset=utf-8";
		String expectedStatusLine = "HTTP/1.1 200 OK";
		Assert.assertEquals(actualStatusLine, expectedStatusLine);
		Assert.assertEquals(actualContentType, expectedContentType);
		System.out.println(response.asPrettyString());

	}
}
