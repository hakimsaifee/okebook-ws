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

	private long mobileNumber;
	
	private String state;
	
	private String city;
	
	private String country;
	
	private long zipCode;

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


	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
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
