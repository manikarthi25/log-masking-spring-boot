package com.logger.maskingsensitivedata.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logger.maskingsensitivedata.model.Address;
import com.logger.maskingsensitivedata.model.PersonalData;
import com.logger.maskingsensitivedata.model.User;

@RestController
public class MaskSensitiveDataController {

	private final Logger logger = LoggerFactory.getLogger(MaskSensitiveDataController.class);

	@GetMapping("/appstatus")
	public String getApplicationStatus() {
		return "Working";
	}

	@GetMapping("/maskdata")
	public String maskSensitiveData() {
		/*
		 * Map<String, String> user = new HashMap<>(); user.put("user_id", "87656");
		 * user.put("SSN", "786445563"); user.put("address", "22 Street");
		 * user.put("city", "Chicago"); user.put("Country", "U.S.");
		 * user.put("ip_address", "192.168.1.1"); user.put("email_id",
		 * "spring@baeldung.com"); JSONObject userDetails = new JSONObject(user);
		 * logger.info("User JSON: {}", userDetails); return
		 * "Successfuly Mask Private Data";
		 */

		List<Address> addressList = new ArrayList<>();
		Address permanentAddress = new Address();
		permanentAddress.setAddressType("Permanent Address");
		permanentAddress.setStreet("Permanent Street");
		permanentAddress.setDistrict("Permanent District");
		permanentAddress.setPincode("Permanent 111111");

		Address temporaryAddress = new Address();
		temporaryAddress.setAddressType("Temporary Address");
		temporaryAddress.setStreet("Temporary Street");
		temporaryAddress.setDistrict("Temporary District");
		temporaryAddress.setPincode("Temporary 222222");

		addressList.add(permanentAddress);
		addressList.add(temporaryAddress);

		PersonalData personalData = new PersonalData();
		personalData.setEmailId("Chicago@gmail.com");
		personalData.setName("Mani");
		personalData.setMobileNumber("9999999999");
		personalData.setIpAddress("123.123.123.123");

		User user = new User();
		user.setUserId("user-123");
		user.setPassword("password");
		user.setAddressList(addressList);
		user.setPersonalData(personalData);

		JSONObject userDetails = new JSONObject(user);
		logger.info("In Info Logger : User Details : {}", userDetails);
		System.out.println("=============");
		System.out.println("Without Logger : User Details : " + userDetails);
		return "Successfuly Mask Private Data";

		/* OUTPUT
		 
		 In Info Logger : User Details : 
		 {"password":"********",
		 	"addressList": [
		 			{"pincode":"Permanent 111111","street":"****************","addressType":"Permanent Address","district":"Permanent District"},
		 			{"pincode":"Temporary 222222","street":"****************","addressType":"Temporary Address","district":"Temporary District"}
		 		],
		 	"personalData":{"mobileNumber":"9999999999","ipAddress":"***************","name":"Mani","emailId":"*****************"},
		 "userId":"********"}
		 
		 =============
		 
		Without Logger : User Details : 		
		{"password":"password",
			"addressList": [
				{"pincode":"Permanent 111111","street":"Permanent Street","addressType":"Permanent Address","district":"Permanent District"},
				{"pincode":"Temporary 222222","street":"Temporary Street","addressType":"Temporary Address","district":"Temporary District"}
			  ],
			"personalData":{"mobileNumber":"9999999999","ipAddress":"123.123.123.123","name":"Mani","emailId":"Chicago@gmail.com"},
		"userId":"user-123"}

		 */
	}

}
