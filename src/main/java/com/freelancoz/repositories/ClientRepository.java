package com.freelancoz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelancoz.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{}