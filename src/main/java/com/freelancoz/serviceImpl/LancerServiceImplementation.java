package com.freelancoz.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelancoz.model.Lancer;
import com.freelancoz.repositories.LancerRepository;
import com.freelancoz.service.LancerService;

@Transactional
@Service
public class LancerServiceImplementation implements LancerService {

	@Autowired
	private LancerRepository lancerRepository;
		
	@Override
	public Boolean isLancerExist(Long lancerId) {
		return lancerRepository.existsById(lancerId);
	}

	@Override
	public Lancer getLancer(Long id) {
		return lancerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wrong Lancer ID"));
	}

	@Override
	public List<Lancer> getAllLancer() {
		return StreamSupport.stream(lancerRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public void saveOrUpdateLancer(Lancer lancer) {
		lancerRepository.save(lancer);
	}

	@Override
	public void deleteLancer(Lancer lancer) {
		lancerRepository.delete(lancer);
	}
}