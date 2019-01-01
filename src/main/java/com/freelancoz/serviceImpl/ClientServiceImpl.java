package com.freelancoz.serviceImpl;

import com.freelancoz.model.Client;
import com.freelancoz.model.Project;
import com.freelancoz.repositories.ClientRepository;
import com.freelancoz.serviceInterface.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> getClientList() {
        return StreamSupport.stream(clientRepository.findAll().spliterator(),true).collect(Collectors.toList());
    }

    @Override
    public Set<Project> getProjectList(Client client)  {
        if (clientRepository.findById(client.getId()).isPresent()){
        return clientRepository.findById(client.getId()).get().getProjectSet();
        }
        return null;
    }
}