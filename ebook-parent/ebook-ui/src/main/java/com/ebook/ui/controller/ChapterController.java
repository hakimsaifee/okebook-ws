package com.ebook.ui.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.ChapterDTO;
import com.ebook.services.service.ChapterService;
import com.ebook.services.service.PartService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = ChapterController.CHAPTER)
public class ChapterController extends AbstractController<ChapterDTO, ChapterService>  {
	public static final String CHAPTER = "chapter";

	private static final Logger LOGGER = LoggerFactory.getLogger(ChapterController.class);

	
	@Autowired
	public ChapterController(ChapterService service) {
		super(service);
	}
	
	
	@Autowired
	public PartService partService;
	
	
		
	@RequestMapping(value = "/chapters", method = RequestMethod.GET)
	public Collection<ChapterDTO> listUser() {
		return service.getAll();
	}
	
}
