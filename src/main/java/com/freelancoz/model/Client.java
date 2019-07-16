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
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "client")
    private Set<Project> projectSet = new HashSet<>();

	public Client() {	}
	
    public Client(String name,Address address) {
        this.name = name;
        this.address = address;
    }

	public Client(String name, Address address, Set<Project> projectSet) {
		this.name = name;
		this.address = address;
		this.projectSet = projectSet;
	}	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		if(this.getAddress().equals(address))
			return;
		this.address = address;
	}
	
	public Set<Project> getProjectSet() {
		//defensive copy no body able to change the 
		//list from outside
		return new HashSet<Project>(projectSet);
	}
	
	public void addProject(Project project) {
		//prevent endless loop
		if(projectSet.contains(project))
			return;
		projectSet.add(project);
		project.setClient(this);
	}
	
	public void removeProject(Project project) {
		//prevent endless loop
		if(!projectSet.contains(project))
			return;
		projectSet.remove(project);
		project.setClient(null);
	}
}