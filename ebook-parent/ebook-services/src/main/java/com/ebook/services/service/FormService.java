package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.FormDTO;
import com.ebook.domain.entity.Form;
import com.ebook.domain.repository.FormRepository;

@Service
public class FormService extends AbstractService<Form, FormDTO, FormRepository>{

	public FormService() {
	}
	
	@Autowired
	public FormService(FormRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
	
}
