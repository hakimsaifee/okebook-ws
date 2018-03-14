package com.ebook.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class RuleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private BigDecimal ruleNumber;

	private String ruleHeading;

	private Set<SectionDTO> sections;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRuleHeading() {
		return ruleHeading;
	}

	public void setRuleHeading(String ruleHeading) {
		this.ruleHeading = ruleHeading;
	}

	public BigDecimal getRuleNumber() {
		return ruleNumber;
	}

	public void setRuleNumber(BigDecimal ruleNumber) {
		this.ruleNumber = ruleNumber;
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
