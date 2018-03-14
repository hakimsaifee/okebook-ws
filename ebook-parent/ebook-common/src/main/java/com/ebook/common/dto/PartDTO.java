package com.ebook.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class PartDTO implements Serializable {

	@Override
	public String toString() {
		return "PartDTO [id=" + id + ", partName=" + partName + ", partNumber=" + partNumber + ", sections=" + sections
				+ "]";
	}

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private long id;

	private String partHeading;

	private BigDecimal partNumber;

	private Set<SectionDTO> sections;

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

	public Set<SectionDTO> getSections() {
		return sections;
	}

	public void setSections(Set<SectionDTO> sections) {
		this.sections = sections;
	}
}
