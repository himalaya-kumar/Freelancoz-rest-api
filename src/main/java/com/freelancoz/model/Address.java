package com.freelancoz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * - A Way to figure out whose address it is(Probably boolean)
 * 
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private Integer version;
	
	private String city;

}