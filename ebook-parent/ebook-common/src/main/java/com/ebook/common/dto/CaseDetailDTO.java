package com.ebook.common.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class CaseDetailDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8813389376317589033L;

	private long id;

	private String caseId;

	private String caseDetail;

	private String caseDocumentPath;

	private Timestamp createdTs;

//	@JsonManagedReference
	private CompanyDTO company;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCaseDetail() {
		return caseDetail;
	}

	public void setCaseDetail(String caseDetail) {
		this.caseDetail = caseDetail;
	}

	public String getCaseDocumentPath() {
		return caseDocumentPath;
	}

	public void setCaseDocumentPath(String caseDocumentPath) {
		this.caseDocumentPath = caseDocumentPath;
	}

	public Timestamp getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}

	public CompanyDTO getCompany() {
		return company;
	}
	
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}
}
