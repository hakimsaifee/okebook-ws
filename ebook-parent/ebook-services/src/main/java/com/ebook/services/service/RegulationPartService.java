package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.RegulationPartDTO;
import com.ebook.domain.entity.RegulationPart;
import com.ebook.domain.repository.RegulationPartRepository;

@Service
public class RegulationPartService extends AbstractService<RegulationPart, RegulationPartDTO, RegulationPartRepository>{

	public RegulationPartService() {
	}
	
	@Autowired
	public RegulationPartService(RegulationPartRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}

}
