package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.NotificationDTO;
import com.ebook.domain.entity.Notification;
import com.ebook.domain.repository.NotificationRepository;

@Service
public class NotificationService extends AbstractService<Notification, NotificationDTO, NotificationRepository>{

	public NotificationService() {
	}
	
	@Autowired
	public NotificationService(NotificationRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
}
