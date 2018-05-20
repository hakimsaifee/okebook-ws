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
 * The persistent class for the regulation database table.
 * 
 */
@Entity
@Table(name = "regulation")
@NamedQuery(name = "Regulation.findAll", query = "SELECT r FROM Regulation r")
public class Regulation extends TypeAwareEntity implements Serializable {
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

	
	@Column(name = "regulation_content", nullable = false, columnDefinition = "TEXT")
	private String regulationContent;
	
	
	// bi-directional many-to-one association to Part
	@ManyToOne
	@JoinColumn(name = "regulation_part_id")
	private RegulationPart regulationPart;

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

	public RegulationPart getRegulationPart() {
		return regulationPart;
	}

	public void setRegulationPart(RegulationPart regulationPart) {
		this.regulationPart = regulationPart;
	}

	public String getRegulationContent() {
		return regulationContent;
	}

	public void setRegulationContent(String regulationContent) {
		this.regulationContent = regulationContent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Regulation [id=").append(id).append(", regulationHeading=").append(regulationHeading)
				.append(", regulationNumber=").append(regulationNumber).append(", regulationContent=")
				.append(regulationContent).append(", regulationPart=").append(regulationPart).append("]");
		return builder.toString();
	}

}