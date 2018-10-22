package com.ebook.services.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.CaseDetailDTO;
import com.ebook.domain.entity.CaseDetail;
import com.ebook.domain.repository.CaseDetailRepository;


@Service
public class CaseDetailService extends AbstractService<CaseDetail, CaseDetailDTO, CaseDetailRepository>{

	private static final Logger LOGGER = LoggerFactory.getLogger(CaseDetailService.class);
	
	public CaseDetailService() {
	}
	
	@Autowired
	public CaseDetailService(CaseDetailRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
	
	
	public List<CaseDetailDTO> getCaseDetailByCompanyId(Long companyId) {
		List<CaseDetail> caseDetails = repository.findAllByCompanyId(companyId);
		if(caseDetails != null && !caseDetails.isEmpty()) {
			List<CaseDetailDTO> caseDetailDTOs =  new ArrayList<>();
			for (CaseDetail caseDetail : caseDetails) {
				CaseDetailDTO  dto =beanMapper.map(caseDetail, CaseDetailDTO.class);
				caseDetailDTOs.add(dto);
			}
			return caseDetailDTOs;
		}
		return null;
	} 
}