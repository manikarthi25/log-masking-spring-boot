package com.logger.maskingsensitivedata.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaskSensitiveDataController {
	
	private final Logger logger = LoggerFactory.getLogger(MaskSensitiveDataController.class);
	
	@GetMapping("/appstatus")
	public String getApplicationStatus() {
		return "Working";
	}
	
	@GetMapping("/maskdata")
	public String maskSensitiveData() {
		Map<String, String> user = new HashMap<>();
		user.put("user_id", "87656");
		user.put("SSN", "786445563");
		user.put("address", "22 Street");
		user.put("city", "Chicago");
		user.put("Country", "U.S.");
		user.put("ip_address", "192.168.1.1");
		user.put("email_id", "spring@baeldung.com");
		logger.info("User JSON: {}", user);
		return " Successfuly Mask Private Data";

	}

}
