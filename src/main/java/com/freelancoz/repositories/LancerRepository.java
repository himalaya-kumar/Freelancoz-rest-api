package com.freelancoz.repositories;

import com.freelancoz.model.Lancer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancerRepository extends CrudRepository<Lancer,Long> {
    /**
     * TODO No of projects associated to it.
     *
     */
}