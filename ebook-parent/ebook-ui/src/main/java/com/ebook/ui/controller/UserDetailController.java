package com.ebook.ui.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.UserDetailDTO;
import com.ebook.services.service.UserDetailService;

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = UserDetailController.UserDetail)
public class UserDetailController extends AbstractController<UserDetailDTO, UserDetailService> {
	public static final String UserDetail = "userDetail";

	private static final Logger LOGGER = LoggerFactory.getLogger(PartController.class);

	@Autowired
	public UserDetailController(UserDetailService service) {
		super(service);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Collection<UserDetailDTO> listUser() {
		return service.getAll();
	}

	@RequestMapping(path = "register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDetailDTO registerUser(@RequestBody UserDetailDTO userDetailDTO) {

		System.out.println("Register User");
		UserDetailDTO userDTO = null;

		if (userDetailDTO.getEmailId() != null && userDetailDTO.getEmailId().isEmpty()) {

			com.ebook.domain.entity.UserDetail userDetail = service.getUserByUserName(userDetailDTO.getEmailId());

			if (userDetail != null) {
				LOGGER.info("User Name Already exists {}", userDetail.getEmailId());

			}
		} else {
			service.save(userDetailDTO);

		}
		return userDTO;

	}

}
