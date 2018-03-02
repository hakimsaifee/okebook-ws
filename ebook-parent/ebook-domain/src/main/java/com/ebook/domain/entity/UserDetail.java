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

	@Column(name = "eamil_id", length = 100)
	private String eamilId;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false, length = 512)
	private String username;

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

	public String getEamilId() {
		return this.eamilId;
	}

	public void setEamilId(String eamilId) {
		this.eamilId = eamilId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}

}