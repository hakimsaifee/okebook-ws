package com.ebook.ui.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.RoleDTO;
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
		UserDetailDTO userEntityDTO = null;

		if (userDetailDTO.getEmailId() != null && userDetailDTO.getEmailId().isEmpty()) {

			userEntityDTO = service.getUserByUserName(userDetailDTO.getEmailId());

			if (userEntityDTO != null) {
				LOGGER.info("User Name Already exists {}", userEntityDTO.getEmailId());

			}
		} else {
			userEntityDTO = service.save(userDetailDTO);

		}
		return userDetailDTO;

	}
	
	
	@RequestMapping(path = "updateUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDetailDTO updateUser(@RequestBody UserDetailDTO userDetailDTO) {

		System.out.println("Register User");
		UserDetailDTO userEntityDTO = null;

		if (userDetailDTO.getEmailId() != null && !userDetailDTO.getEmailId().isEmpty()) {

			userEntityDTO = service.getUserByUserName(userDetailDTO.getEmailId());

			if (userEntityDTO != null) {
				LOGGER.info("User Name Already exists {},Adding Roles", userEntityDTO.getEmailId());
				if(userDetailDTO.getRoles() !=null && !userDetailDTO.getRoles().isEmpty()) {
					Set<RoleDTO> userRoles = userDetailDTO.getRoles();
					for(RoleDTO roleDTO : userRoles) {
						roleDTO.setRoleType(roleDTO.getItemName());
						roleDTO.setUserDetails(new HashSet<>(Arrays.asList(userEntityDTO)));
						}
					
					userEntityDTO.setRoles(userRoles);
					
					userEntityDTO = service.update(userEntityDTO);
				}else {
					LOGGER.error("User Name {} doesnt exist,wont add Roles", userEntityDTO.getEmailId());
				}
			}
		} else {
			LOGGER.error("Invalid input");

		}
		return userEntityDTO;

	}
	
	

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public Collection<UserDetailDTO> getAll(){
        return service.getAll();
    }
    
    @RequestMapping(path = "getRoles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public  Set<RoleDTO> getUserRolesForEmail(@RequestBody UserDetailDTO userDetailDTO) {
		System.out.println("getUserRolesForEmail"+userDetailDTO);
		
		UserDetailDTO userDTO = service.getUserByUserName(userDetailDTO.getEmailId());
		
	
		if (userDTO.getRoles()!=null && !userDTO.getRoles().isEmpty())
			return userDTO.getRoles();
		else
			return null;
	}
}
