package com.ebook.common.dto;

import java.io.Serializable;
import java.util.Set;

public class UserDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String emailId;

	private String password;

	private String username;

	private Set<RoleDTO> userRoles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String eamilId) {
		this.emailId = eamilId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<RoleDTO> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<RoleDTO> userRoles) {
		this.userRoles = userRoles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
