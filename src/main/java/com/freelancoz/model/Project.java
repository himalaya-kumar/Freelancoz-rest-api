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

/**
 * - A Project will some period of time. 
 * - It will have knowledge of clients and projects with which he is associated with.
 * - date of project started
 * - date of project when will it closes.
 * - 
 */
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

    public Project(String projectName) {
        this.projectName = projectName;
    }

	public Project() {	}

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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Lancer> getLancerList() {
		return lancerList;
	}

	public void setLancerList(List<Lancer> lancerList) {
		this.lancerList = lancerList;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client clientNew) {
		if(sameAsFormer(clientNew)) {
			return;
		}
		
		Client clientOld = this.client;
		this.client = clientNew;
		
		if(clientOld != null) {
			clientOld.removeProject(this);
		}
		if(clientNew != null) {
			clientNew.addProject(this);
		}
	}
	
	private boolean sameAsFormer(Client newClient) {
		return client == null ? newClient == null : client.equals(newClient);
	}
	
	public void addLancer(Lancer lancer) {
		if(lancerList.contains(lancer)) {
			return;
		}
		lancerList.add(lancer);
		lancer.addProject(this);
	}

	public void removeLancer(Lancer lancer) {
		if(!lancerList.contains(lancer)) {
			return;
		}
		lancerList.remove(lancer);
		lancer.removeProject(this);		
	}
}