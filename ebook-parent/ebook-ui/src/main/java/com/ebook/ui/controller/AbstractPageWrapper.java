package com.ebook.ui.controller;


import java.io.Serializable;
import java.util.List;

public class AbstractPageWrapper<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2862075567411646917L;

	List<T> elements;
	
	int pageNumber;
	
	int totalRecords;

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<T> getElements() {
		return elements;
	}

	public int getPageNumber() {
		return pageNumber;
	}


	public void setElements(List<T> elements) {
		this.elements = elements;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}
