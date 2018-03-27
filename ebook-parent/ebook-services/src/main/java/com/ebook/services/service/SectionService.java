package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.SectionDTO;
import com.ebook.domain.entity.Section;
import com.ebook.domain.repository.SectionRepository;

@Service
public class SectionService extends AbstractService<Section, SectionDTO, SectionRepository>{

	public SectionService() {
	}
	
	@Autowired
	public SectionService(SectionRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
	
	
}
