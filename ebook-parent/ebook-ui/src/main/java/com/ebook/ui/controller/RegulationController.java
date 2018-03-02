package com.ebook.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.RegulationDTO;
import com.ebook.services.service.RegulationService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = RegulationController.REGULATION)
public class RegulationController extends AbstractController<RegulationDTO, RegulationService>  {
	public static final String REGULATION = "regulation";

	@Autowired
	public RegulationController(RegulationService service) {
		super(service);
	}
	
	
}
