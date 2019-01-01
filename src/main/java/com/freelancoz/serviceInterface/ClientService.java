package com.freelancoz.serviceInterface;

import com.freelancoz.model.Client;
import com.freelancoz.model.Project;

import java.util.List;
import java.util.Set;

/**
 * TODO :
 */
public interface ClientService {
    void saveClient(Client client);
    Client getClient(Long id);
    List<Client> getClientList();
    Set<Project> getProjectList(Client client);
}