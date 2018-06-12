package com.ebook.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class PartDTO extends ContentTypeDTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private long id;

	private String partHeading;

	private BigDecimal partNumber;

	@JsonManagedReference
	private Set<ChapterDTO> chapters;

	@JsonManagedReference
	private Set<FormDTO> forms;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPartHeading() {
		return partHeading;
	}

	public void setPartHeading(String partHeading) {
		this.partHeading = partHeading;
	}

	public BigDecimal getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(BigDecimal partNumber) {
		this.partNumber = partNumber;
	}

	public Set<ChapterDTO> getChapters() {
		return chapters;
	}

	public void setChapters(Set<ChapterDTO> chapters) {
		this.chapters = chapters;
	}

	public Set<FormDTO> getForms() {
		return forms;
	}

	public void setForms(Set<FormDTO> forms) {
		this.forms = forms;
	}
}
