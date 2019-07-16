package com.freelancoz.service;

import java.util.List;

import com.freelancoz.model.Lancer;

public interface LancerService {

	Boolean isLancerExist(Long id);
	
	Lancer getLancer(Long id);
	
	List<Lancer> getAllLancer();
	
	void saveOrUpdateLancer(Lancer lancer);
	
	void deleteLancer(Lancer lancer);

}