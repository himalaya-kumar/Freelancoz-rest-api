package com.freelancoz.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/checkGet")
	public String checkConnection() {
		LOG.info("Check for connection");
		return "connectedGet";
	}
	
	@PostMapping("/checkPost")
	public String checkPostConnection() {
		return "connectedPost";
	}
	
	@PostMapping("/checkParam/{id}")
	public String getParamAttribute(@PathVariable String id) {
		return id;
	}

//	@GetMapping("ok")
//	public String getOk() {
//		return "Okay";
//	}
}