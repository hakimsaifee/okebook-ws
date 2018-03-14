package com.ebook.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class SectionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String sectionHeading;

	private BigDecimal sectionNumber;

	private Set<RegulationDTO> regulations;

	private Set<RuleDTO> rules;

	private PartDTO part;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSectionHeading(String sectionHeading) {
		this.sectionHeading = sectionHeading;
	}

	public String getSectionHeading() {
		return sectionHeading;
	}

	public BigDecimal getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(BigDecimal sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public Set<RegulationDTO> getRegulations() {
		return regulations;
	}

	public void setRegulations(Set<RegulationDTO> regulations) {
		this.regulations = regulations;
	}

	public Set<RuleDTO> getRules() {
		return rules;
	}

	public void setRules(Set<RuleDTO> rules) {
		this.rules = rules;
	}

	public PartDTO getPart() {
		return part;
	}

	public void setPart(PartDTO part) {
		this.part = part;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
