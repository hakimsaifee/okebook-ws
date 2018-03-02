package com.ebook.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.NotificationDTO;
import com.ebook.services.service.NotificationService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = NotificationController.NOTIFICATION)
public class NotificationController extends AbstractController<NotificationDTO, NotificationService>  {
	public static final String NOTIFICATION = "notification";

	@Autowired
	public NotificationController(NotificationService service) {
		super(service);
	}
	
	
}
