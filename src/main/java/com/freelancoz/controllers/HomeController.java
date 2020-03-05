package com.freelancoz.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("home")
public class HomeController {

	Logger LOG = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@GetMapping("/checkGet")
	public ResponseEntity<String> checkConnection() {
		LOG.info("Check for connection");
		return new ResponseEntity<String>("connectedGet",HttpStatus.OK);
	}
	
	@PostMapping("/checkPost")
	public ResponseEntity<String> checkPostConnection() {
		return new ResponseEntity<String>("connectedPost",HttpStatus.OK);
	}
	
	@PostMapping("/checkParam/{id}")
	public ResponseEntity<String> getParamAttribute(@PathVariable String id) {
		return new ResponseEntity<String>(id,HttpStatus.OK);
	}
	
	
	@GetMapping("/applicationName")
	public ResponseEntity<String> applicationName( ) {
		LOG.info("Application.name : "+httpServletRequest.getRequestURI());
		return new ResponseEntity<String>("Freelancoz",HttpStatus.OK);
	}
}