package com.freelancoz.repositories;

import org.springframework.data.repository.CrudRepository;

import com.freelancoz.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{}