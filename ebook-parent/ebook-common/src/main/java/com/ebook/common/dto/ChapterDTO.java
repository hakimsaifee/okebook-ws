package com.ebook.common.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class ChapterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String chapterHeading;

	private BigDecimal chapterNumber;


	@JsonBackReference
	private PartDTO part;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getChapterHeading() {
		return chapterHeading;
	}

	public void setChapterHeading(String chapterHeading) {
		this.chapterHeading = chapterHeading;
	}

	public BigDecimal getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(BigDecimal chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public PartDTO getPart() {
		return part;
	}

	public void setPart(PartDTO part) {
		this.part = part;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
