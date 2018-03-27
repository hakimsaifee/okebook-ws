package com.ebook.ui.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.ChapterDTO;
import com.ebook.common.dto.SectionDTO;
import com.ebook.domain.entity.Chapter;
import com.ebook.services.service.ChapterService;
import com.ebook.services.service.SectionService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = SectionController.Section)
public class SectionController extends AbstractController<SectionDTO, SectionService>  {
	public static final String Section = "section";

	private static final Logger LOGGER = LoggerFactory.getLogger(PartController.class);
	
	@Autowired
	public SectionController(SectionService service) {
		super(service);
	}
	
	@Autowired
	private ChapterService chapterService;

	@RequestMapping(path = "saveSections", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ChapterDTO saveChapter(@RequestBody ChapterDTO chapterDTO) {
		
		if(chapterDTO.getChapterNumber() !=null) {
			Chapter chapter = null;
			try {
				chapter = chapterService.getChapterByChapterNumber(chapterDTO.getChapterNumber());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(chapter !=null) {
				LOGGER.info("Chapter Already Exists {} , Adding Sections ",chapter.getId());

				Set<SectionDTO> sectionDTOs = chapterDTO.getSections();
				
				if(sectionDTOs !=null && !sectionDTOs.isEmpty()) {
					for(SectionDTO sectionDTO :sectionDTOs) {
						sectionDTO.setChapter(chapterDTO);
						sectionDTO = service.save(sectionDTO);
					}
				
				}
				
			}else {
				LOGGER.error("Chapter Doesnt Exist {} , Hence Wont add Sections ");
				
			}
		}else {
			LOGGER.error("Invalid input - ChapterDTO");
		}
		return chapterDTO;
		
	}
	
	
}
