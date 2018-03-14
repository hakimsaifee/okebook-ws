package com.ebook.domain.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "section_regulation", joinColumns = {
			@JoinColumn(name = "section_id", referencedColumnName = "id", table = "section") }, inverseJoinColumns = {
					@JoinColumn(name = "regulation_id", referencedColumnName = "id", table = "regulation") })
	private Set<Regulation> regulations;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "section_rule", joinColumns = {
			@JoinColumn(name = "section_id", referencedColumnName = "id", table = "section") }, inverseJoinColumns = {
					@JoinColumn(name = "rule_id", referencedColumnName = "id", table = "rule") })
	private Set<Rule> rules;

	// bi-directional many-to-one association to Part
	@ManyToOne
	@JoinColumn(name = "part_id")
	private Part part;

	public Section() {
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	public void setSectionHeading(String sectionHeading) {
		this.sectionHeading = sectionHeading;
	}
	
	public String getSectionHeading() {
		return sectionHeading;
	}

	public BigDecimal getSectionNumber() {
		return this.sectionNumber;
	}

	public void setSectionNumber(BigDecimal sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public Set<Regulation> getRegulations() {
		return regulations;
	}

	public void setRegulations(Set<Regulation> regulations) {
		this.regulations = regulations;
	}

	public Part getPart() {
		return this.part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Set<Rule> getRules() {
		return rules;
	}

	public void setRules(Set<Rule> rules) {
		this.rules = rules;
	}

}