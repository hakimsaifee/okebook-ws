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
import com.ebook.common.dto.PartDTO;
import com.ebook.domain.entity.Part;
import com.ebook.services.service.ChapterService;
import com.ebook.services.service.PartService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = ChapterController.CHAPTER)
public class ChapterController extends AbstractController<ChapterDTO, ChapterService>  {
	public static final String CHAPTER = "chapter";

	private static final Logger LOGGER = LoggerFactory.getLogger(PartController.class);

	
	@Autowired
	public ChapterController(ChapterService service) {
		super(service);
	}
	
	
	@Autowired
	public PartService partService;
	
	
	@RequestMapping(path = "savChapter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartDTO saveChapter(@RequestBody PartDTO dto) {
		System.out.println("Update");
		PartDTO partDTO = null;
		
		if(dto.getPartNumber() !=null) {
			Part  part = partService.getPartByPartNumber(dto.getPartNumber());
			if(part !=null) {
				LOGGER.info("\"Part Already Exists {} , Adding Sections ",part.getId());

				Set<ChapterDTO> chapterDTOs = dto.getChapters();
				
				if(chapterDTOs !=null && !chapterDTOs.isEmpty()) {
					
					for(ChapterDTO chapterDTO :chapterDTOs) {
						chapterDTO.setPart(partDTO);
						chapterDTO = service.save(chapterDTO);
					}
				
				}
			}else {
				System.out.println("Part Doesnt Exists , Hence Wont Add sections");
				
			}
		}
		return partDTO;
		
	}
	
}
