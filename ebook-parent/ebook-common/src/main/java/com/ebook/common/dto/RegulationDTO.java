package com.ebook.common.dto;

import java.io.Serializable;
import java.util.Set;

public class RegulationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String fileLocation;

	private String fileName;

	private String regulationName;

	private Set<SectionDTO> sections;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRegulationName() {
		return regulationName;
	}

	public void setRegulationName(String regulationName) {
		this.regulationName = regulationName;
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
