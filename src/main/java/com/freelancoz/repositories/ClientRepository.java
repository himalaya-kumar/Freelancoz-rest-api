package com.freelancoz.repositories;

import com.freelancoz.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
    /**
     * As the interface is not going to implement any code
     * TODO : This Will Have All The Information Regarding the Client
     * TODO 1. Client will have knowledge of previous worked projects
     * TODO 2. A Client can see different Project Associated to it.
     *
     */
}