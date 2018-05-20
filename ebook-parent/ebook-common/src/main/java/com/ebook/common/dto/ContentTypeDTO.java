package com.ebook.common.dto;

import java.io.Serializable;

import com.ebook.common.enums.ContentTypeEnum;

public class ContentTypeDTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	protected String contentType;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
