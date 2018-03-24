package com.ebook.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the user_detail database table.
 * 
 */
@Entity
@Table(name = "user_detail")
@NamedQuery(name = "UserDetail.findAll", query = "SELECT u FROM UserDetail u")
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USER_DETAIL_ID_GENERATOR", sequenceName = "AUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_DETAIL_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "email_id", length = 100)
	private String emailId;

	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 15)
	private long mobileNumber;
	
	@Column(name = "state", length = 100)
	private String state;
	
	@Column(name = "city", length = 100)
	private String city;
	
	@Column(name = "country", length = 100)
	private String country;
	
	@Column(name = "zipCode", length = 10)
	private long zipCode;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id", table = "user_detail") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id", table = "role") })
	private Set<Role> userRoles;

	public UserDetail() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return this.password;
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

	public Set<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}

}