package com.ebook.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the part database table.
 * 
 */
@Entity
@Table(name = "image_detail")
public class ImageDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ImageDetail_GENERATOR")
	@GenericGenerator(name = "ImageDetail_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "ImageDetail_SEQ") })
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "image_name", nullable = false, length = 1024)
	private String imageName;

	@Column(name = "description", nullable = true, length = 512)
	private String description;
	
	@Column(name = "UPDATED_TS", nullable = false)
	private Timestamp updatedTs;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Timestamp getUpdatedTs() {
		return updatedTs;
	}
	
	public void setUpdatedTs(Timestamp updatedTs) {
		this.updatedTs = updatedTs;
	}

}