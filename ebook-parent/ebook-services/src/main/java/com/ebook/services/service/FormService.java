package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.FormDTO;
import com.ebook.common.dto.PartDTO;
import com.ebook.domain.entity.Form;
import com.ebook.domain.repository.FormRepository;

@Service
public class FormService extends AbstractService<Form, FormDTO, FormRepository> {

	public FormService() {
	}

	@Autowired
	public FormService(FormRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}

	@Override
	public FormDTO update(FormDTO dto) {
		Form savedForm = repository.findOne(dto.getId());
		if (savedForm == null) {
			return null;
		}
		if (savedForm.getPart() != null) {
			PartDTO savedPart = beanMapper.map(savedForm.getPart(), PartDTO.class);
			dto.setPart(savedPart);
		}
		return super.update(dto);
	}
}
