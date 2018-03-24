package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.RoleDTO;
import com.ebook.domain.entity.Role;
import com.ebook.domain.repository.RoleRepository;

@Service
public class RoleService extends AbstractService<Role, RoleDTO, RoleRepository> {

	public RoleService() {
	}

	@Autowired
	public RoleService(RoleRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}

	public RoleDTO getRoleByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}
}
