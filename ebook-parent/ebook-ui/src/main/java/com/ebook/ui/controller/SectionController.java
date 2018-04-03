package com.ebook.ui.controller;

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
import com.ebook.common.dto.SectionDTO;
import com.ebook.services.service.ChapterService;
import com.ebook.services.service.SectionService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = SectionController.Section)
@CrossOrigin(origins="*", maxAge = 3600)
public class SectionController extends AbstractController<SectionDTO, SectionService>  {
	public static final String Section = "section";

	private static final Logger LOGGER = LoggerFactory.getLogger(SectionController.class);
	
	@Autowired
	public SectionController(SectionService service) {
		super(service);
	}
	
	@Autowired
	private ChapterService chapterService;

	@RequestMapping(path = "saveSections", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ChapterDTO saveChapter(@RequestBody ChapterDTO chapterDTO) {
		ChapterDTO chapEntityDTO = null;
		if(chapterDTO.getChapterNumber() !=null) {
			try {
				chapEntityDTO = chapterService.getChapterByChapterNumber(chapterDTO.getChapterNumber());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(chapEntityDTO !=null) {
				LOGGER.info("Chapter Already Exists {} , Adding Sections ",chapEntityDTO.getId());

				Set<SectionDTO> sectionDTOs = chapterDTO.getSections();
				chapEntityDTO.setSections(sectionDTOs);
				if(sectionDTOs !=null && !sectionDTOs.isEmpty()) {
					for(SectionDTO sectionDTO :sectionDTOs) {
						sectionDTO.setChapter(chapEntityDTO);
					}
				}
				chapEntityDTO = chapterService.update(chapEntityDTO);
			}else {
				LOGGER.error("Chapter Doesnt Exist {} , Hence Wont add Sections ");
				
			}
		}else {
			LOGGER.error("Invalid input - ChapterDTO");
		}
		return chapEntityDTO;
		
	}
	
	
}
