package com.ebook.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.ebook.common.enums.ContentTypeEnum;

@MappedSuperclass
public abstract class TypeAwareEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1054991101784952196L;

	@Column(name = "content_type")
	@Enumerated(EnumType.STRING)
	protected ContentTypeEnum contentType;

	public ContentTypeEnum getContentType() {
		return contentType;
	}

	public void setContentType(ContentTypeEnum contentType) {
		this.contentType = contentType;
	}
}
