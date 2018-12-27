package com.freelancoz.project;

import com.freelancoz.model.Address;
import com.freelancoz.serviceInterface.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreelancozApplication implements CommandLineRunner {

	@Autowired
	private AddressService addressService;

	public static void main(String[] args){
		SpringApplication.run(FreelancozApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Nyc","CAL","1234");
		addressService.saveAddress(address);
		System.out.println(addressService.getAddress(3000));
	}
}