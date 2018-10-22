package com.ebook.common.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class CompanyDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7735136392210919632L;

	private long id;

	private String companyName;

	private String companyId;

	private String companyDetail;

//	@JsonBackReference
//	private Set<CaseDetailDTO> caseDetails;

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

	/*public Set<CaseDetailDTO> getCaseDetails() {
		return caseDetails;
	}

	public void setCaseDetails(Set<CaseDetailDTO> caseDetails) {
		this.caseDetails = caseDetails;
	}*/

}
