package org.ConstructComplexPojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer {
	
	
public static void main(String[] args) throws JsonProcessingException {
	AllDetails allDetails=new AllDetails();
	allDetails.setId(11881);
	allDetails.setDate("2018-03-1997");
	allDetails.setDateGmt("2018-03-1997-76868-7474");
	allDetails.setModified("2018-03-1997-768j56-74hy");
	allDetails.setModifiedGmt("2018-03-yf657-768j56-74hy");
	allDetails.setSlug("some text");
	allDetails.setStatus("some status");
	allDetails.setType("post");
	allDetails.setLink("http://google.com");
	GuidAndTitle guidAndTitle= new GuidAndTitle();
	guidAndTitle.setRendered("http://google.com");
	GuidAndTitle guidAndTitle2= new GuidAndTitle();
	guidAndTitle2.setRendered("some title");
	allDetails.setGuid(guidAndTitle);
	allDetails.setTitle(guidAndTitle2);
	Data data=new Data();
	List list = new ArrayList();
	list.add(allDetails);
	data.setData(list);
	ObjectMapper obj=new ObjectMapper();
	String json = obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	System.out.println(json);
	
	
	
}
}
