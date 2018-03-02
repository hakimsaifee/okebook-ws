package com.ebook.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.SectionDTO;
import com.ebook.services.service.SectionService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = SectionController.Section)
public class SectionController extends AbstractController<SectionDTO, SectionService>  {
	public static final String Section = "section";

	@Autowired
	public SectionController(SectionService service) {
		super(service);
	}
	
	
}
