package com.ebook.ui.controller;

import java.util.HashSet;

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

import com.ebook.common.dto.ChapterDTO;
import com.ebook.common.dto.PartDTO;
import com.ebook.common.enums.ContentTypeEnum;
import com.ebook.services.service.ChapterService;
import com.ebook.services.service.PartService;
import com.ebook.services.service.SectionService;

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = FormController.FORM)
@CrossOrigin(origins = "*", maxAge = 3600)
public class FormController extends AbstractController<ChapterDTO, ChapterService> {
	public static final String FORM = "form";

	private static final Logger LOGGER = LoggerFactory.getLogger(FormController.class);

	@Autowired
	public FormController(ChapterService service) {
		super(service);
	}

	@Autowired
	public PartService partService;

	@Autowired
	public SectionService sectionService;

	@RequestMapping(path = "saveForm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartDTO savePart(@RequestBody PartDTO partDTO, @RequestParam(value = "contentType") String contentType) {
		LOGGER.debug("Saving Form details for type : {}", contentType);

		if (contentType == null || ContentTypeEnum.valueOf(contentType) == null) {
			throw new IllegalArgumentException("Content Type is Missing.");
		}

		PartDTO part;
		if (partDTO != null && partDTO.getPartNumber() != null) {
			part = partService.getPartByPartNumber(partDTO.getPartNumber(), ContentTypeEnum.valueOf(contentType));
			if (part != null) {
				LOGGER.info("Part Already Exists , Hence Couldnt add a new Entry {}", part.getId());
				// Part is already exits need to add more chapters into part.
				if (partDTO.getForms() != null) {
					if (part.getForms() == null) {
						part.setForms(new HashSet<>());
					}
					part.getForms().addAll(partDTO.getForms());
				}
				LOGGER.info("Updating Forms for Part : {} ", part.getId());
				partService.update(part);
			} else {
				LOGGER.info("Part Doesnt Exists , Creating a new Entry");

			}
		}
		return partDTO;

	}

}
