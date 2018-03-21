package com.ebook.services.service;

import java.math.BigDecimal;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.PartDTO;
import com.ebook.domain.entity.Part;
import com.ebook.domain.repository.PartRepository;

@Service
public class PartService extends AbstractService<Part, PartDTO, PartRepository>{

	public PartService() {
	}
	
	@Autowired
	public PartService(PartRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}

	public Part getPartByPartNumber(BigDecimal partNumber) {
		return repository.findBypartNumber(partNumber);
	}
	
	
}
