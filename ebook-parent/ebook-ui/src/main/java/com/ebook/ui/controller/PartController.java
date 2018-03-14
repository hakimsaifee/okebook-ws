package com.ebook.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.PartDTO;
import com.ebook.services.service.PartService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = PartController.PART)
public class PartController extends AbstractController<PartDTO, PartService>  {
	public static final String PART = "part";

	@Autowired
	public PartController(PartService service) {
		super(service);
	}

	@RequestMapping(path = "saveOrEdit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public PartDTO saveOrEdit(@RequestBody PartDTO dto) {
			System.out.println("Update");
			PartDTO update = service.update(dto);
			System.out.println("Updated DTO" + update);
			return update;
		}
	
	
}
