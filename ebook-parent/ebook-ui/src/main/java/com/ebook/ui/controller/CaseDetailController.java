package com.ebook.ui.controller;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.CaseDetailDTO;
import com.ebook.common.dto.CompanyDTO;
import com.ebook.common.dto.PartDTO;
import com.ebook.services.service.CaseDetailService;
import com.ebook.services.service.CompanyService;

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = CaseDetailController.CASES)
@CrossOrigin(origins = "*", maxAge = 3600)
public class CaseDetailController extends AbstractController<CaseDetailDTO, CaseDetailService> {
	public static final String CASES = "cases";

	private static final Logger LOGGER = LoggerFactory.getLogger(CaseDetailController.class);

	@Autowired
	public CaseDetailController(CaseDetailService service) {
		super(service);
	}

	@Autowired
	private CompanyService companyService;

	@RequestMapping(path = "get/getCasesByCompanyId", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CaseDetailDTO> getCaseDetailsByCompanyId(@RequestParam(value = "companyId") String companyId) {
		try {
			if (companyId != null) {
				Long id = Long.valueOf(companyId);
				LOGGER.info("Fetching Case Detais for Company Id: {}", id);
				return service.getCaseDetailByCompanyId(id);
			} else {
				LOGGER.error("Company ID is not valid in the request : {} ", companyId);
			}
		} catch (Exception e) {
			LOGGER.error("Error while fetching case details by company id. " + e);
		}
		return null;
	}

	@RequestMapping(path = "addCase", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CaseDetailDTO addCompany(@RequestBody CaseDetailDTO caseDetailDTO) {

//		if (caseDetailDTO != null) {
//			caseDetailDTO.setCreatedTs(new Timestamp(System.currentTimeMillis()));
			if (caseDetailDTO != null && caseDetailDTO.getCompany() != null) {
				CompanyDTO companyDTO = companyService.getById(caseDetailDTO.getCompany().getId());
				caseDetailDTO.setCompany(companyDTO);
				return service.save(caseDetailDTO);
			}
//		}
		return null;
	}

}
