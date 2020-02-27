package com.freelancoz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelancoz.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{}