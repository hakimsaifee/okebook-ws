package com.ebook.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.RuleDTO;
import com.ebook.services.service.RuleService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = RuleController.RULE)
@CrossOrigin(origins="*", maxAge = 3600)
public class RuleController extends AbstractController<RuleDTO, RuleService>  {
	public static final String RULE = "rule";

	@Autowired
	public RuleController(RuleService service) {
		super(service);
	}
	
	
}
