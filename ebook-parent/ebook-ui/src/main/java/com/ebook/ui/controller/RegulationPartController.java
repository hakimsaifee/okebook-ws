package com.ebook.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.RegulationPartDTO;
import com.ebook.services.service.RegulationPartService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = RegulationPartController.PART_REGULATION)
public class RegulationPartController extends AbstractController<RegulationPartDTO, RegulationPartService>  {
	public static final String PART_REGULATION = "partRegulation";

	@Autowired
	public RegulationPartController(RegulationPartService service) {
		super(service);
	}
	
	
}
