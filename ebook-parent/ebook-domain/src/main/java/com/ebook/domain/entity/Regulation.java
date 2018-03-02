package com.ebook.domain.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the regulation database table.
 * 
 */
@Entity
@Table(name = "regulation")
@NamedQuery(name = "Regulation.findAll", query = "SELECT r FROM Regulation r")
public class Regulation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "REGULATION_ID_GENERATOR", sequenceName = "AUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REGULATION_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "file_location", nullable = false, length = 2000)
	private String fileLocation;

	@Column(name = "file_name", nullable = false, length = 512)
	private String fileName;

	@Column(name = "regulation_name", nullable = false)
	@Lob
	private String regulationName;

	@ManyToMany(mappedBy = "regulations")
	private Set<Section> sections;

	public Regulation() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRegulationName() {
		return this.regulationName;
	}

	public void setRegulationName(String regulationName) {
		this.regulationName = regulationName;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

}