package com.ebook.ui.controller;

import java.util.Collection;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.ChapterDTO;
import com.ebook.common.dto.PartDTO;
import com.ebook.services.service.ChapterService;
import com.ebook.services.service.PartService;
import com.ebook.services.service.SectionService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = ChapterController.CHAPTER)
@CrossOrigin(origins="*", maxAge = 3600)
public class ChapterController extends AbstractController<ChapterDTO, ChapterService>  {
	public static final String CHAPTER = "chapter";

	private static final Logger LOGGER = LoggerFactory.getLogger(ChapterController.class);

	
	@Autowired
	public ChapterController(ChapterService service) {
		super(service);
	}
	
	
	@Autowired
	public PartService partService;
	
	
	@Autowired
	public SectionService sectionService;
	
	
		
	@RequestMapping(value = "get/getAllOrdered", method = RequestMethod.GET)
	public Collection<ChapterDTO> listUser() {
		return service.getAll();
	}
	
	@RequestMapping(path = "edit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartDTO editChapter(@RequestBody PartDTO partDTO) {
		LOGGER.debug("Editing Chapter details ");

		PartDTO entityDTO = new PartDTO();
		if (partDTO != null && partDTO.getChapters() != null && !partDTO.getChapters().isEmpty()) {
			LOGGER.info("Part Already Exists , Hence Updating {}", partDTO.getId());
			
			entityDTO = partService.getById(partDTO.getId());
			
			Set<ChapterDTO> chapterDTOs = partDTO.getChapters();
			
			for(ChapterDTO chapterDTO :chapterDTOs) {
				chapterDTO.setPart(entityDTO);
				chapterDTO = service.update(chapterDTO);
				// AWSSendMail.sendEmail();
				System.out.println("Saved DTO" + chapterDTO);
			}
		} else {
			LOGGER.warn("Chapter Doesnt Exists , Nothng to Update");
		}
		return partDTO;
	}
	
}
