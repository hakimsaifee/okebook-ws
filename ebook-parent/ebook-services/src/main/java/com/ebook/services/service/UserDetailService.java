package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.UserDetailDTO;
import com.ebook.domain.entity.UserDetail;
import com.ebook.domain.repository.UserDetailRepository;

@Service
public class UserDetailService extends AbstractService<UserDetail, UserDetailDTO, UserDetailRepository>{

	public UserDetailService() {
	}
	
	@Autowired
	public UserDetailService(UserDetailRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
}
