package com.ebook.domain.entity;

import java.io.Serializable;

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
@Table(name = "form")
@NamedQuery(name = "Form.findAll", query = "SELECT s FROM Form s")
public class Form extends TypeAwareEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FORM_ID_GENERATOR", sequenceName = "AUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORM_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "heading", nullable = false, columnDefinition = "TEXT")
	private String heading;

	@Column(name = "number", nullable = false)
	private String number;

	@Column(name = "detail", nullable = false, columnDefinition = "TEXT")
	private String detail;

	@ManyToOne
	@JoinColumn(name = "part_id")
	private Part part;
	
	public Form() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Part getPart() {
		return part;
	}
	
	public void setPart(Part part) {
		this.part = part;
	}
	
}