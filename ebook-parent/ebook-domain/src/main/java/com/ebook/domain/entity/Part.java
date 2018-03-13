package com.ebook.domain.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the part database table.
 * 
 */
@Entity
@Table(name = "part")
@NamedQuery(name = "Part.findAll", query = "SELECT p FROM Part p")
public class Part implements Serializable {
	private static final long serialVersionUID = 1L;

	// @Id
	// @SequenceGenerator(name="PART_ID_GENERATOR", sequenceName="AUTO")
	// @GeneratedValue(strategy=GenerationType.SEQUENCE,
	// generator="PART_ID_GENERATOR")
	@Id
//	@SequenceGenerator(name="PART_SEQ", initialValue=19899, allocationSize=100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_REGISTRATION_ID_GENERATOR")
	@GenericGenerator(name = "PRODUCT_REGISTRATION_ID_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "PART_SEQ" )  })
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "part_name", nullable = false)
	private String partName;

	@Column(name = "part_number", nullable = false, length = 512)
	@Lob
	private String partNumber;

	// bi-directional many-to-one association to Section
	@OneToMany(mappedBy = "part",cascade=CascadeType.ALL)
	private Set<Section> sections;

	public Part() {
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartNumber() {
		return this.partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public Set<Section> getSections() {
		return this.sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public Section addSection(Section section) {
		getSections().add(section);
		section.setPart(this);

		return section;
	}

	public Section removeSection(Section section) {
		getSections().remove(section);
		section.setPart(null);

		return section;
	}

}