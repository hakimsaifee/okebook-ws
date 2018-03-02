package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.RuleDTO;
import com.ebook.domain.entity.Rule;
import com.ebook.domain.repository.RuleRepository;

@Service
public class RuleService extends AbstractService<Rule, RuleDTO, RuleRepository>{

	public RuleService() {
	}
	
	@Autowired
	public RuleService(RuleRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
}
