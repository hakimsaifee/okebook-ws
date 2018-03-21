package com.ebook.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the part database table.
 * 
 */
@Entity
@Table(name = "regulation_part")
@NamedQuery(name = "RegulationPart.findAll", query = "SELECT p FROM RegulationPart p")
public class RegulationPart implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REGULATION_PART_GENERATOR")
	@GenericGenerator(name = "REGULATION_PART_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "REGULATION_PART_SEQ") })
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "regulation_chapter_heading", nullable = false, columnDefinition = "TEXT")
	private String regulationChapterHeading;

	@Column(name = "part_chapter_number", nullable = false, precision = 10, scale = 2)
	private BigDecimal regulationChapterNumber;

	// bi-directional many-to-one association to Section
	@OneToMany(mappedBy = "regulationPart", cascade = CascadeType.ALL)
	private Set<Regulation> regulations;

	public RegulationPart() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegulationChapterHeading() {
		return regulationChapterHeading;
	}

	public void setRegulationChapterHeading(String regulationChapterHeading) {
		this.regulationChapterHeading = regulationChapterHeading;
	}

	public BigDecimal getRegulationChapterNumber() {
		return regulationChapterNumber;
	}

	public void setRegulationChapterNumber(BigDecimal regulationChapterNumber) {
		this.regulationChapterNumber = regulationChapterNumber;
	}

	public Set<Regulation> getRegulations() {
		return regulations;
	}

	public void setRegulations(Set<Regulation> regulations) {
		this.regulations = regulations;
	}

}