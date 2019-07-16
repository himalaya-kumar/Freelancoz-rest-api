package com.freelancoz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private Integer version;
	
	private String city;
	
//	private Lancer lancer;
//	
//	private Client client;

	public Address() {	}

	public Address(String city) {
		this.city = city;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}