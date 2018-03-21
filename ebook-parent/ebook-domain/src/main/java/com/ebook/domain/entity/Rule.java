package com.ebook.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

	@Column(name = "rule_number", nullable = false, precision = 10, scale = 2)
	private BigDecimal ruleNumber;

	@Column(name = "rule_heading", nullable = false, columnDefinition = "TEXT")
	private String ruleHeading;

	/*@ManyToMany(mappedBy = "rules")
	private Set<Section> sections;
*/
	public Rule() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getRuleNumber() {
		return ruleNumber;
	}

	public void setRuleNumber(BigDecimal ruleNumber) {
		this.ruleNumber = ruleNumber;
	}

	public String getRuleHeading() {
		return ruleHeading;
	}

	public void setRuleHeading(String ruleHeading) {
		this.ruleHeading = ruleHeading;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}