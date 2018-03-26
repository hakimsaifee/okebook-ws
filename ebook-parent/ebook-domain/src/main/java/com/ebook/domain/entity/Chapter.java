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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the chapter database table.
 * 
 */
@Entity
@Table(name = "chapter")
@NamedQuery(name = "Chapter.findAll", query = "SELECT s FROM Chapter s")
public class Chapter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CHAPTER_ID_GENERATOR", sequenceName = "AUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHAPTER_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "chapter_number", nullable = false, precision = 10, scale = 2)
	private BigDecimal chapterNumber;
	
	@Column(name = "chapter_heading", nullable = false, columnDefinition="TEXT")
	private String chapterHeading;


	@ManyToOne
	@JoinColumn(name = "part_id")
	private Part part;
	
	
// bi-directional many-to-one association to Section
	@OneToMany(mappedBy = "chapter",cascade=CascadeType.ALL)
	private Set<Section> sections;

	public Chapter() {
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	public void setChapterHeading(String chapterHeading) {
		this.chapterHeading = chapterHeading;
	}
	
	public String getChapterHeading() {
		return chapterHeading;
	}

	public BigDecimal getChapterNumber() {
		return this.chapterNumber;
	}

	public void setChapterNumber(BigDecimal chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public Part getPart() {
		return this.part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Set<Section> getSections() {
		return this.sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public Section addSections(Section section) {
		getSections().add(section);
		section.setChapter(this);

		return section;
	}

	public Section removeSection(Section section) {
		getSections().remove(section);
		section.setChapter(null);

		return section;
	}

	
}