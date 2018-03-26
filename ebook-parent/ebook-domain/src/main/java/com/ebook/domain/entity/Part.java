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
@Table(name = "part")
@NamedQuery(name = "Part.findAll", query = "SELECT p FROM Part p")
public class Part implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PART_GENERATOR")
	@GenericGenerator(name = "PART_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "PART_SEQ" )  })
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "part_heading", nullable = false, columnDefinition="TEXT")
	private String partHeading;

	@Column(name = "part_number", nullable = false, precision = 10, scale = 2)
	private BigDecimal partNumber;

	// bi-directional many-to-one association to Section
	@OneToMany(mappedBy = "part",cascade=CascadeType.ALL)
	private Set<Chapter> chapters;

	public Part() {
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getPartHeading() {
		return partHeading;
	}
	
	public void setPartHeading(String partHeading) {
		this.partHeading = partHeading;
	}


	public BigDecimal getPartNumber() {
		return partNumber;
	}
	
	public void setPartNumber(BigDecimal partNumber) {
		this.partNumber = partNumber;
	}
	
	public Set<Chapter> getChapters() {
		return this.chapters;
	}

	public void setChapters(Set<Chapter> chapters) {
		this.chapters = chapters;
	}

	public Chapter addChapter(Chapter chapter) {
		getChapters().add(chapter);
		chapter.setPart(this);

		return chapter;
	}

	public Chapter removeChapter(Chapter chapter) {
		getChapters().remove(chapter);
		chapter.setPart(null);

		return chapter;
	}

}