package com.ebook.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ImageDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7735136392210919632L;

	private long id;

	private String imageName;

	private String description;
	
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
