package com.ebook.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name = "role")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ROLE_ID_GENERATOR", sequenceName = "AUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "role_type", nullable = false, length = 100)
	private String roleType;

	@ManyToMany(mappedBy = "roles")
	private Set<UserDetail> userDetails;

	@Transient
	private String itemName;
	
	public Role() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Set<UserDetail> getUserDetails() {
		return userDetails;
	}
	
	public void setUserDetails(Set<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}