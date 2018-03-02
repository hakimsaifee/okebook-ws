package com.ebook.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.UserDetailDTO;
import com.ebook.services.service.UserDetailService;

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = UserDetailController.UserDetail)
public class UserDetailController extends AbstractController<UserDetailDTO, UserDetailService> {
	public static final String UserDetail = "userDetail";

	@Autowired
	public UserDetailController(UserDetailService service) {
		super(service);
	}

}
