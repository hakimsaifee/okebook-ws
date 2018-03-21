package com.ebook.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class RegulationPartDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;

	private String regulationChapterHeading;

	private BigDecimal regulationChapterNumber;

	@JsonManagedReference
	private Set<RegulationDTO> regulations;

	public RegulationPartDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegulationChapterHeading() {
		return regulationChapterHeading;
	}

	public void setRegulationChapterHeading(String regulationChapterHeading) {
		this.regulationChapterHeading = regulationChapterHeading;
	}

	public BigDecimal getRegulationChapterNumber() {
		return regulationChapterNumber;
	}

	public void setRegulationChapterNumber(BigDecimal regulationChapterNumber) {
		this.regulationChapterNumber = regulationChapterNumber;
	}


	public Set<RegulationDTO> getRegulations() {
		return regulations;
	}
	
	public void setRegulations(Set<RegulationDTO> regulations) {
		this.regulations = regulations;
	}
}