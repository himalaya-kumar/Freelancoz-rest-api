package com.freelancoz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * - A Project will some period of time. 
 * - It will have knowledge of clients and projects with which he is associated with.
 * - date of project started
 * - date of project when will it closes.
 * - 
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "project_id_gen")
    @SequenceGenerator(name = "project_id_gen",initialValue = 1000,allocationSize =1)
    private Long id;

    @Version
    private Integer version;

    private String projectName;

    @ManyToMany(mappedBy = "projectList")
    private List<Lancer> lancerList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

}