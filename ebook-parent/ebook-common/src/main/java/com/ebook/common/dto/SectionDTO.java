package com.ebook.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class SectionDTO extends ContentTypeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String sectionHeading;

	private BigDecimal sectionNumber;
	
	private String sectionDetail;


	@JsonBackReference
	private ChapterDTO chapter;
	
	//Added just because we need to know part detail for the regulation.
	private PartDTO part;

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
		return sectionNumber;
	}

	public void setSectionNumber(BigDecimal sectionNumber) {
		this.sectionNumber = sectionNumber;
	}


	public ChapterDTO getChapter() {
		return chapter;
	}

	public void setChapter(ChapterDTO chapter) {
		this.chapter = chapter;
	}

	public String getSectionDetail() {
		return sectionDetail;
	}

	public void setSectionDetail(String sectionDetail) {
		this.sectionDetail = sectionDetail;
	}
	
	public PartDTO getPart() {
		return part;
	}
	
	public void setPart(PartDTO part) {
		this.part = part;
	}

}
