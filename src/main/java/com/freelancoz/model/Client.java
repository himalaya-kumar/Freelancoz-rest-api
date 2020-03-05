package com.freelancoz.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * - A Client will have the information of every project he deployed.
 * - A Client will have the information of every lancer he will be connected.
 * - A Client will have to give its address. 
 * - Time of client is staying 
 *
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    
    @OneToOne
    private Address address;
    
    /**
     * One to many bi-directional
     *
     * @param name
     * @param address
     */
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Project> projectSet;
}