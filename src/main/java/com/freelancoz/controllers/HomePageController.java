package com.freelancoz.controllers;

import com.freelancoz.model.Client;
import com.freelancoz.model.ContactInformation;
import com.freelancoz.model.Project;
import com.freelancoz.serviceInterface.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class HomePageController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/homepage")
    public String hompage(){
        return "home";
    }

    @PostMapping(value = "/addClient")
    public Client addClient(@RequestParam(value = "client_name")String name, @RequestParam(value = "contact_info")ContactInformation
                            contactInformation, @RequestParam(value = "project_set")Set<Project> projects){
            Client client = new Client();
            client.setName(name);
            client.setContactInformation(contactInformation);
            client.setProjectSet(projects);
            clientService.saveClient(client);
            return client;
    }

    @PostMapping(value = "/showContact")
    public ContactInformation showContact(@RequestParam(value = "city")String city,@RequestParam(value = "state")String state,
                              @RequestParam(value = "postalCode")String code,@RequestParam(value = "email")String mail,@RequestParam(value = "phone")String phone){
        ContactInformation contactInformation = new ContactInformation(city,state,code,phone,mail);
        return contactInformation;
    }
}