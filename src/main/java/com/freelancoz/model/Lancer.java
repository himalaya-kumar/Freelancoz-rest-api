package com.freelancoz.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A lancer would be trying buddy who like to see and have a project
 * to try out....that's it for now
 */
@Data
@Entity
@NoArgsConstructor
public class Lancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "lancer_id_gen")
    @SequenceGenerator(name = "lancer_id_gen",initialValue = 2000,allocationSize =1)
    private Long id;

    @Version
    private Integer version;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactInfo_id")
    private ContactInformation contactInformation;

    /**
     * TODO :: Educational Bi directional One To Many
     * one to many project
     * @param name
     */
//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "lancer",cascade = CascadeType.ALL)
//    private Set<Project> projectSet = new LinkedHashSet<Project>();

    /**
     * TODO :: Educational Bi directional Many To Many
     */
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Project> projectList = new ArrayList<>();

    //Project Id last Project worked on
//    private Long lastProjectWorkedOn;

    public Lancer(String name){
        this.name = name;
    }

    public Lancer(String name, ContactInformation contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
    }
}