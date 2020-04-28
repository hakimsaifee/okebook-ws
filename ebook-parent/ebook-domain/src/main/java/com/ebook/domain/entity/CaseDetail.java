package com.ebook.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the chapter database table.
 * 
 */
@Entity
@Table(name = "case_detail")
public class CaseDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CASE_DETAIL_GENERATOR")
	@GenericGenerator(name = "CASE_DETAIL_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "CASE_DETAIL_SEQ") })
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "case_id", length=100)
	private String caseId;

	@Column(name = "case_detail", length=1024)
	private String caseDetail;

	@Column(name = "case_document_path", length=1024)
	private String caseDocumentPath;

	@Column(name = "case_document_description", length=1024)
	private String caseDocumentDescription;
	
	@Column(name = "CREATED_TS")
	private Timestamp createdTs;

	@Column(name = "UPDATED_TS")
	private Timestamp updatedTs;

	@ManyToOne()
	@JoinColumn(name = "company_id" , referencedColumnName="id")
	private Company company;


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


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Timestamp getCreatedTs() {
		return createdTs;
	}
	
	public void setCreatedTs(Timestamp createdTs) {
		this.createdTs = createdTs;
	}
	
	public String getCaseDocumentDescription() {
		return caseDocumentDescription;
	}
	
	public void setCaseDocumentDescription(String caseDocumentDescription) {
		this.caseDocumentDescription = caseDocumentDescription;
	}
}