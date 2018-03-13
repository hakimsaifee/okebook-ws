package com.ebook.common.dto;

import java.io.Serializable;
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
	private String partName;
	private String partNumber;
	private Set<SectionDTO> sections;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public Set<SectionDTO> getSections() {
		return sections;
	}

	public void setSections(Set<SectionDTO> sections) {
		this.sections = sections;
	}
}
