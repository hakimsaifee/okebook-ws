package com.ebook.domain.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * The persistent class for the rule database table.
 * 
 */
@Entity
@Table(name = "rule")
@NamedQuery(name = "Rule.findAll", query = "SELECT r FROM Rule r")
public class Rule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RULE_ID_GENERATOR", sequenceName = "AUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RULE_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "chapter_number", nullable = false, length = 50)
	private String chapterNumber;

	@Column(name = "file_location", nullable = false, length = 2000)
	private String fileLocation;

	@Column(name = "file_name", nullable = false, length = 512)
	private String fileName;

	@ManyToMany(mappedBy = "rules")
	private Set<Section> sections;

	public Rule() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChapterNumber() {
		return this.chapterNumber;
	}

	public void setChapterNumber(String chapterNumber) {
		this.chapterNumber = chapterNumber;
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

}