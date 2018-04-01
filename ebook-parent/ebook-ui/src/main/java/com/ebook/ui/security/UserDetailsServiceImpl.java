package com.ebook.ui.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.UserDetailDTO;
import com.ebook.services.service.UserDetailService;


@Service("userService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailService userService;

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		UserDetailDTO user = userService.getUserByUserName(emailId);
		return  user;
	}

}
