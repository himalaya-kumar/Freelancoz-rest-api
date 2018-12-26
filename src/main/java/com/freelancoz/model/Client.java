package com.freelancoz.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator ="client_id_gen")
    @SequenceGenerator(name = "client_id_gen",initialValue = 2000,allocationSize =1)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    /**
     * This is an examplary code snippet of
     * One to many Unidirectional
     */
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinTable(name = "Client_Project",joinColumns =@JoinColumn(name = "client"),inverseJoinColumns = @JoinColumn(name = "project"))
//    private Set<Project> projectSet = new HashSet<>();

    /**
     * One to many bi-directional
     *
     * @param name
     * @param address
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client",fetch = FetchType.LAZY)
    private Set<Project> projectSet = new HashSet<>();

    public Client(String name,Address address) {
        this.name = name;
        this.address = address;
    }
}