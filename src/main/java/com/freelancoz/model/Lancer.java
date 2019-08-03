package com.freelancoz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;


@Entity
public class Lancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    private List<Project> projectList = new ArrayList<>();
    
    public Lancer() { }

	public Lancer(String name){
        this.name = name;
    }

    public Lancer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

	public Lancer(String name, Address address, List<Project> projectList) {
		super();
		this.name = name;
		this.address = address;
		this.projectList = projectList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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
		this.address = address;
	}

	public List<Project> getProjectList() {
		return new ArrayList<>(projectList);
	}
	
	public void  addProject(Project project) {
		if(projectList.contains(project)) {
			return;
		}
		projectList.add(project);
		project.addLancer(this);
	}
	
	public void removeProject(Project project) {
		if(!projectList.contains(project)) {
			return;
		}
		projectList.remove(project);
		project.removeLancer(this);
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
}