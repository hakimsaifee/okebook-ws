package com.ebook.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class RegulationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String regulationHeading;

	private BigDecimal regulationNumber;

	private String regulationContent;
	
	
	@JsonBackReference
	private RegulationPartDTO regulationPart;
	
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RegulationPartDTO getRegulationPart() {
		return regulationPart;
	}
	
	public void setRegulationPart(RegulationPartDTO regulationPart) {
		this.regulationPart = regulationPart;
	}

	public String getRegulationContent() {
		return regulationContent;
	}

	public void setRegulationContent(String regulationContent) {
		this.regulationContent = regulationContent;
	}

	
}
