package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.RegulationDTO;
import com.ebook.domain.entity.Regulation;
import com.ebook.domain.repository.RegulationRepository;

@Service
public class RegulationService extends AbstractService< Regulation, RegulationDTO, RegulationRepository>{

	public RegulationService() {
	}
	
	@Autowired
	public RegulationService(RegulationRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
}
