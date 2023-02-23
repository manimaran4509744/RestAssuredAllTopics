package org.ConstructComplexPojo2;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer {

	public static void main(String[] args) throws JsonProcessingException {
		AllDetails allDetails = new AllDetails();
		allDetails.setCompanyName("MSE");
		allDetails.setCompanyHOCity("Bengaluru");
		allDetails.setCompanyCeo("Amod");
		List<Object> list = new ArrayList();
		list.add("HDFC");
		list.add("ICICI");
		list.add("AXIS");
		allDetails.setSupportedSalaryBank(list);
		List<Object> list2 = new ArrayList();
		list2.add(348478);
		list2.add(568778);
		list2.add(864778);
		allDetails.setPincodesOfCityOffice(list2);
		EmployeeDetails details = new EmployeeDetails();
		details.setFirstName("Amod");
		details.setLastName("Prasant");
		details.setGender("Male");
		details.setAge(28);
		details.setSalary(10000.56d);
		details.setMarried(false);
		EmployeeDetails details2 = new EmployeeDetails();
		details2.setFirstName("Kitty");
		details2.setLastName("Prasant");
		details2.setGender("Male");
		details2.setAge(24);
		details2.setSalary(20000.56d);
		details2.setMarried(false);
		EmployeeDetails details3 = new EmployeeDetails();
		details3.setFirstName("UnderTaker");
		details3.setLastName("Prasant");
		details3.setGender("Male");
		details3.setAge(36);
		details3.setSalary(50000.56d);
		details3.setMarried(false);
		List<Object> list3 = new ArrayList();
		list3.add(details);
		list3.add(details2);
		list3.add(details3);
		allDetails.setEmployee(list3);
		ContractorsDetails contractorsDetails = new ContractorsDetails();
		contractorsDetails.setFirstName("Akash");
		contractorsDetails.setLastName("Kumar");
		contractorsDetails.setContractFrom("Jan-2019");
		contractorsDetails.setContractTo("Mar-2019");
		ContractorsDetails contractorsDetails2 = new ContractorsDetails();
		contractorsDetails2.setFirstName("ManiMaran");
		contractorsDetails2.setLastName("Kumar");
		contractorsDetails2.setContractFrom("Apr-2019");
		contractorsDetails2.setContractTo("Dec-2019");
		List<Object> list4 = new ArrayList();
		list4.add(contractorsDetails);
		list4.add(contractorsDetails2);
		allDetails.setContractors(list4);
		CompanyPfDetails companyPfDetails = new CompanyPfDetails();
		companyPfDetails.setPfName("XYZ");
		companyPfDetails.setPfCity("Bengaluru");
		companyPfDetails.setPfYear(2012);
		companyPfDetails.setNoOfEmployees(10);
		allDetails.setCompanyPFDetails(companyPfDetails);
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writerWithDefaultPrettyPrinter().writeValueAsString(allDetails);
		System.out.println(json);

	}

}
