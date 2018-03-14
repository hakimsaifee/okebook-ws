package com.ebook.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "regulation_heading", nullable = false, columnDefinition = "TEXT")
	private String regulationHeading;

	@Column(name = "regulation_number", nullable = false, precision = 10, scale = 2)
	private BigDecimal regulationNumber;

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

	public BigDecimal getRegulationNumber() {
		return regulationNumber;
	}

	public void setRegulationNumber(BigDecimal regulationNumber) {
		this.regulationNumber = regulationNumber;
	}

	public String getRegulationHeading() {
		return regulationHeading;
	}

	public void setRegulationHeading(String regulationHeading) {
		this.regulationHeading = regulationHeading;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

}