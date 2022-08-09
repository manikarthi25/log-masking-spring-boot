package com.logger.maskingsensitivedata.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
		Map<String, String> user = new HashMap<>();
		user.put("user_id", "87656");
		user.put("SSN", "786445563");
		user.put("address", "22 Street");
		user.put("city", "Chicago");
		user.put("Country", "U.S.");
		user.put("ip_address", "192.168.1.1");
		user.put("email_id", "spring@baeldung.com");
		JSONObject userDetails = new JSONObject(user);
		logger.info("User JSON: {}", userDetails);
		return "Successfuly Mask Private Data";
		*/
		
		User user = new User();
		user.setUser_id("87656");
		user.setSSN("786445563");
		user.setAddress("22 Street");
		user.setEmail_id("Chicago@gmail.com");
		user.setName("Mani");
		JSONObject userDetails = new JSONObject(user);
		logger.info("In Info Logger : User Details : {}", userDetails);
		System.out.println("=============");
		System.out.println("Without Logger : User Details" +userDetails);
		return "Successfuly Mask Private Data";
		

		/* OUTPUT
		 com.logger.maskingsensitivedata.controller.MaskSensitiveDataController: 
		 In Info Logger : User Details : 
		 {"email_id":"*****************","address":"*********","user_id":"87656","name":"Mani","SSN":"*********"}
		 =============
		 Without Logger : User Details
		 {"email_id":"Chicago@gmail.com","address":"22 Street","user_id":"87656","name":"Mani","SSN":"786445563"}
		 */
	}

}
