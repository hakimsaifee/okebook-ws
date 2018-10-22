package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.CompanyDTO;
import com.ebook.domain.entity.Company;
import com.ebook.domain.repository.CompanyRepository;


@Service
public class CompanyService extends AbstractService<Company, CompanyDTO, CompanyRepository>{

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);
	
	public CompanyService() {
	}
	
	@Autowired
	public CompanyService(CompanyRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
}