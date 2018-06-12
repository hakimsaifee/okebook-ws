package com.ebook.common.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class FormDTO extends ContentTypeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String heading;

	private String number;

	private String detail;

	@JsonBackReference
	private PartDTO part;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public PartDTO getPart() {
		return part;
	}

	public void setPart(PartDTO part) {
		this.part = part;
	}

}
