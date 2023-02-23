package org.deserialization;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class MakingJsonIntoPojoUsingdeserialization {

	private String first_Name;
	private String last_name;
	private String email;

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
