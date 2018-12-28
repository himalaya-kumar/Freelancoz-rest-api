package com.freelancoz.project;

import com.freelancoz.model.Address;
import com.freelancoz.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.freelancoz*"})
@EntityScan({"com.freelancoz*"})
@EnableJpaRepositories({"com.freelancoz"})
public class FreelancozApplication implements CommandLineRunner {

	@Autowired
	private AddressRepository addressService;

	public static void main(String[] args){
		SpringApplication.run(FreelancozApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Nyc","CAL","1234");
		addressService.save(address);
		System.out.println(addressService.findById(new Long(3000)));
	}
}