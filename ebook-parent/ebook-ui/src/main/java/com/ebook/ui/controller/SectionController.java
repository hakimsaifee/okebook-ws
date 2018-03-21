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

import com.ebook.common.dto.PartDTO;
import com.ebook.common.dto.SectionDTO;
import com.ebook.domain.entity.Part;
import com.ebook.services.service.PartService;
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
	public PartService partService;
	
	@RequestMapping(path = "saveSection", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartDTO saveSection(@RequestBody PartDTO dto) {
		System.out.println("Update");
		PartDTO partDTO = null;
		
		if(dto.getPartNumber() !=null) {
			Part  part = partService.getPartByPartNumber(dto.getPartNumber());
			if(part !=null) {
				LOGGER.info("\"Part Already Exists {} , Adding Sections ",part.getId());

				Set<SectionDTO> sectionDTOs = dto.getSections();
				
				if(sectionDTOs !=null && !sectionDTOs.isEmpty()) {
					
					for(SectionDTO sectionDTO :sectionDTOs) {
						sectionDTO.setPart(partDTO);
						sectionDTO = service.save(sectionDTO);
					}
				
				}
			}else {
				System.out.println("Part Doesnt Exists , Hence Wont Add sections");
				
			}
		}
		return partDTO;
		
	}
	
}
