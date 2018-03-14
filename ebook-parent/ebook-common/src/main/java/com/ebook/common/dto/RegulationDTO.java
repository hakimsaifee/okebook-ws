package com.ebook.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class RegulationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String regulationHeading;

	private BigDecimal regulationNumber;

	private Set<SectionDTO> sections;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegulationHeading() {
		return regulationHeading;
	}

	public void setRegulationHeading(String regulationHeading) {
		this.regulationHeading = regulationHeading;
	}

	public BigDecimal getRegulationNumber() {
		return regulationNumber;
	}
	
	public void setRegulationNumber(BigDecimal regulationNumber) {
		this.regulationNumber = regulationNumber;
	}
	
	public Set<SectionDTO> getSections() {
		return sections;
	}

	public void setSections(Set<SectionDTO> sections) {
		this.sections = sections;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
