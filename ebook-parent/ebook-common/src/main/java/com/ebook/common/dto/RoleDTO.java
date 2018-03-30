package com.ebook.common.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class RoleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String roleType; 
	
	private String itemName;
	
	
	@JsonBackReference
	private Set<UserDetailDTO> userDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}



	public Set<UserDetailDTO> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Set<UserDetailDTO> userDetails) {
		this.userDetails = userDetails;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
