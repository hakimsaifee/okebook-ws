package com.ebook.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the section database table.
 * 
 */
@Entity
@Table(name = "section")
@NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SECTION_ID_GENERATOR", sequenceName = "AUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECTION_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "section_heading", nullable = false, columnDefinition="TEXT")
	private String sectionHeading;

	@Column(name = "section_number", nullable = false, precision = 10, scale = 2)
	private BigDecimal sectionNumber;

	@Column(name = "section_detail", nullable = false, columnDefinition="TEXT")
	private String sectionDetail;
	
	@ManyToOne
	@JoinColumn(name = "chapter_id")
	private Chapter chapter;

	public Section() {
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	public void setSectionHeading(String sectionHeading) {
		this.sectionDetail = sectionHeading;
	}
	
	public String getSectionHeading() {
		return sectionDetail;
	}

	public BigDecimal getSectionNumber() {
		return this.sectionNumber;
	}

	public void setSectionNumber(BigDecimal sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public Chapter getChapter() {
		return this.chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public String getSectionDetail() {
		return sectionDetail;
	}

	public void setSectionDetail(String sectionDetail) {
		this.sectionDetail = sectionDetail;
	}
	
	

}