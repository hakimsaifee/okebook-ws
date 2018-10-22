package com.ebook.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.CompanyDTO;
import com.ebook.services.service.CompanyService;

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = CompanyController.COMPANY)
@CrossOrigin(origins = "*", maxAge = 3600)
public class CompanyController extends AbstractController<CompanyDTO, CompanyService> {
	public static final String COMPANY = "company";

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	public CompanyController(CompanyService service) {
		super(service);
	}

}
