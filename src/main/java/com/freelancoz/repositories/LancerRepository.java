package com.freelancoz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelancoz.model.Lancer;

public interface LancerRepository extends JpaRepository<Lancer, Long>{}