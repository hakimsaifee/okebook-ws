package com.ebook.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.RoleDTO;
import com.ebook.services.service.RoleService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = RoleController.ROLE)
@CrossOrigin(origins="*", maxAge = 3600)
public class RoleController extends AbstractController<RoleDTO, RoleService>  {
	public static final String ROLE = "role";

	@Autowired
	public RoleController(RoleService service) {
		super(service);
	}
	
	
}
