package com.freelancoz.repositories;

import org.springframework.data.repository.CrudRepository;

import com.freelancoz.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long>{}