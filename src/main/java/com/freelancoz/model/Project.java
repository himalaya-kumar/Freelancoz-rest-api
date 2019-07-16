package com.freelancoz.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Project should have many Client and many lancer
 * Project will be started by only one client.
 * but many lancer wish to try this project out
 * can have the data and wish to try....
 */
@Data
@Entity
@NoArgsConstructor
public class Project {
    /**
     * This Class will Have
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "project_id_gen")
    @SequenceGenerator(name = "project_id_gen",initialValue = 1000,allocationSize =1)
    private Long id;

    @Version
    private Integer version;

    private String projectName;

    private String projectType;

    //TODO :: Educational Many To One
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "lancer")
//    private Lancer lancer;

    //TODO :: Educational Many To Many
    @ManyToMany(mappedBy = "projectList")
    private List<Lancer> lancerList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    //Project Status

    //Project Files

    //Project Information

    //Projects Will have Files to show the Information

    public Project(String projectName) {
        this.projectName = projectName;
    }
}