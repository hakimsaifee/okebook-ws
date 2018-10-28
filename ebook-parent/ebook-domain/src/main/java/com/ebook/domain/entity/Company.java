package com.ebook.domain.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the part database table.
 * 
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_GENERATOR")
	@GenericGenerator(name = "COMPANY_GENERATOR", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence", value = "COMPANY_SEQ") })
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "company_name", nullable = false, length = 1024)
	private String companyName;

	@Column(name = "company_id", nullable = true, length = 100)
	private String companyId;

	@Column(name = "company_detail", nullable = true, length = 1024)
	private String companyDetail;

	// bi-directional many-to-one association to Section
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private Set<CaseDetail> caseDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyDetail() {
		return companyDetail;
	}

	public void setCompanyDetail(String companyDetail) {
		this.companyDetail = companyDetail;
	}

	public Set<CaseDetail> getCaseDetails() {
		return caseDetails;
	}

	public void setCaseDetails(Set<CaseDetail> caseDetails) {
		this.caseDetails = caseDetails;
	}

}