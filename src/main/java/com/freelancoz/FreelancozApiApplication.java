package com.freelancoz;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.freelancoz.model.Address;
import com.freelancoz.model.Client;
import com.freelancoz.model.Lancer;
import com.freelancoz.model.Project;
import com.freelancoz.repositories.AddressRepository;
import com.freelancoz.service.ClientService;
import com.freelancoz.service.LancerService;
import com.freelancoz.service.ProjectService;

@SpringBootApplication
public class FreelancozApiApplication {
	
	static Logger LOG = LoggerFactory.getLogger(FreelancozApiApplication.class);

	@Autowired
	private ClientService clientService;

	@Autowired
	private LancerService lancerService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private AddressRepository addressRepository;

	@PersistenceContext
	private EntityManager entityManager;

	
	public static void main(String[] args) {
		LOG.info("JS");
		File js_file = Paths.get("src/main/resources/static/dist/index.js").toFile();
		js_file.setWritable(true);
		LOG.info(js_file.exists()+"");
		LOG.info(""+js_file.delete());
		jsCompilation();
		SpringApplication.run(FreelancozApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initJS() {
		return args -> {
			/**
			 * Address for the client
			 */
			Address addressClient = Address.builder().city("Address Client").build();
			Address addressLancerOne = Address.builder().city("Address Lancer").build();
			addressRepository.saveAll(Arrays.asList(addressClient, addressLancerOne));

			/**
			 * Client
			 */
			Client client = Client.builder().name("Client One").address(addressClient).build();
			clientService.saveOrUpdateClient(client);

			/**
			 * Project
			 */
			Project project = Project.builder().client(client).projectName("Project One").build();
			projectService.saveOrUpdateProject(project);

			/**
			 * Lancer One
			 */
			Lancer lancer = Lancer.builder().name("Lancer One").address(addressLancerOne)
					.projectList(Arrays.asList(project)).build();
			lancerService.saveOrUpdateLancer(lancer);
		};
	}

	private static void jsCompilation() {
		ProcessBuilder processBuilder = new ProcessBuilder("C:\\Users\\Himgiri\\Desktop\\spring_boot\\freelancoz-rest-api\\npm_command.bat");
		try {
			Process process = processBuilder.start();
			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println(output);
			} else {
				// abnormal...
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
