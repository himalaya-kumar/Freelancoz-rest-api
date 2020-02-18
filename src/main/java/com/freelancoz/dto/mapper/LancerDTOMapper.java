package com.freelancoz.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.freelancoz.dto.AddressDTO;
import com.freelancoz.dto.LancerDTO;
import com.freelancoz.model.Address;
import com.freelancoz.model.Lancer;
import com.freelancoz.model.Project;
import com.freelancoz.repositories.AddressRepository;
import com.freelancoz.service.ProjectService;

@Component
public class LancerDTOMapper {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ProjectService projectService;

	public LancerDTO fromLancer(Lancer lancer) {
		AddressDTO addressDTO = new AddressDTO(lancer.getAddress().getId(),lancer.getAddress().getCity());
		List<Long> projectidList = lancer.getProjectList().stream().map(Project::getId).collect(Collectors.toList());
		LancerDTO lancerDTO = new LancerDTO();
		lancerDTO.setId(lancer.getId());
		lancerDTO.setAddressDTO(addressDTO);
		lancerDTO.setProjectidList(projectidList);
		return lancerDTO;
	}
	
	public Lancer fromDTO(LancerDTO lancerDTO) {
		List<Project> projectList = lancerDTO.getProjectidList().stream().map(projectService::getProject).collect(Collectors.toList());
		Lancer lancer = new Lancer();
		lancer.setId(lancerDTO.getId());
		lancer.setName(lancerDTO.getName());
		lancer.setAddress(getAddress(lancerDTO.getAddressDTO()));
		lancer.setProjectList(projectList);
		return lancer;
	}
	
	private Address getAddress(AddressDTO addressDTO) {		
		return addressRepository.findById(addressDTO.getId()).get();
	}
}