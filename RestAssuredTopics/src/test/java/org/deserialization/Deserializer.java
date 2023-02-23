package org.deserialization;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserializer {
	@Test
	private void usingJson() throws StreamReadException, DatabindException, IOException {
              File file= new File(System.getProperty("user.dir")+"\\src\\test\\resources\\CreateJson.json");
		MakingJsonIntoPojoUsingdeserialization deserialization = new MakingJsonIntoPojoUsingdeserialization();
		ObjectMapper mapper = new ObjectMapper();
		MakingJsonIntoPojoUsingdeserialization pojoObject = mapper.readValue(file, MakingJsonIntoPojoUsingdeserialization.class);
		String first_Name = pojoObject.getFirst_Name();
		String last_name = pojoObject.getLast_name();
		String email = pojoObject.getEmail();
		Assert.assertEquals("Jaishri", first_Name);
		Assert.assertEquals("Arul", last_name);
		Assert.assertEquals("Jaishri@gmail.com", email);
		
		
	}

}
