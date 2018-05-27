package com.ebook.ui.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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

import com.amazonaws.services.workdocs.model.InvalidArgumentException;
import com.ebook.common.dto.ChapterDTO;
import com.ebook.common.dto.SectionDTO;
import com.ebook.common.enums.ContentTypeEnum;
import com.ebook.services.service.ChapterService;
import com.ebook.services.service.SectionService;

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = SectionController.Section)
@CrossOrigin(origins = "*", maxAge = 3600)
public class SectionController extends AbstractController<SectionDTO, SectionService> {
	public static final String Section = "section";

	private static final Logger LOGGER = LoggerFactory.getLogger(SectionController.class);

	@Autowired
	public SectionController(SectionService service) {
		super(service);
	}

	@Autowired
	private ChapterService chapterService;

	@Autowired
	private SectionService sectionService;

	@RequestMapping(path = "saveSections", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ChapterDTO saveChapter(@RequestBody ChapterDTO chapterDTO) {
		ChapterDTO chapEntityDTO = null;
//		if (chapterDTO.getId() == 0) {
			try {
				chapEntityDTO = chapterService.getById(chapterDTO.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (chapEntityDTO != null) {
				LOGGER.info("Chapter Already Exists {} , Adding Sections ", chapEntityDTO.getId());

				Set<SectionDTO> sectionDTOs = chapterDTO.getSections();
				chapEntityDTO.setSections(sectionDTOs);
				if (sectionDTOs != null && !sectionDTOs.isEmpty()) {
					for (SectionDTO sectionDTO : sectionDTOs) {
						sectionDTO.setChapter(chapEntityDTO);
					}
				}
				chapEntityDTO = chapterService.update(chapEntityDTO);
			} else {
				LOGGER.error("Chapter Doesnt Exist {} , Hence Wont add Sections ");

			}
//		} else {
//			LOGGER.error("Invalid input - ChapterDTO");
//		}
		return chapEntityDTO;

	}

	@RequestMapping(path = "edit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SectionDTO editSection(@RequestBody SectionDTO sectionDTO) {
		LOGGER.debug("Editing Section details for section id : {}", sectionDTO.getId());

//		ChapterDTO chapDTO = new ChapterDTO();
//		if (chapterDTO != null && chapterDTO.getSections() != null && !chapterDTO.getSections().isEmpty()) {
//			
//			chapDTO = chapterService.getById(chapterDTO.getId());
//			LOGGER.info("Chapter Already Exists , Hence Updating {}", chapDTO.getId());
//			
//			Set<SectionDTO> sectionDTOs = chapterDTO.getSections();
//			
//			for(SectionDTO sectionDTO :sectionDTOs) {
//				sectionDTO.setChapter(chapDTO);
				SectionDTO storedSection = sectionService.getById(sectionDTO.getId());
				if(storedSection != null) {
					storedSection.setSectionNumber(sectionDTO.getSectionNumber());
					storedSection.setSectionHeading(sectionDTO.getSectionHeading());
					storedSection.setSectionDetail(sectionDTO.getSectionDetail());
					sectionDTO = sectionService.update(storedSection);
				}
						
				// AWSSendMail.sendEmail();
//				System.out.println("Saved DTO" + chapDTO);
//			}
//		} else {
//			LOGGER.warn("Chapter Doesnt Exists , Nothng to Update");
//		}
		return sectionDTO;
	}
	
	
	@RequestMapping(path = "get/sectionNumber", produces = MediaType.APPLICATION_JSON_VALUE)
	public SectionDTO getById(@RequestParam(value = "contentType") String contentType, @RequestParam(value = "id") String sectionNumber) {
		
		LOGGER.info("Get Section for Type : {}", contentType);
		if(contentType == null || ContentTypeEnum.valueOf(contentType) == null) {
			throw new InvalidArgumentException("Content Type is Missing.");
		}
		
		double number = 0;
		try {
			number = Double.valueOf(sectionNumber);
		} catch (Exception e) {
			LOGGER.error("Unable to parse section number : " + e);
			return null;
		}
		return service.getSectionBySectionNumber(BigDecimal.valueOf(number), ContentTypeEnum.valueOf(contentType));
	}
	
	@RequestMapping(path = "get/getAllByContentType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SectionDTO> getPartNumbers(@RequestParam(value = "contentType") String contentType) {
		
		LOGGER.info("Get All Sectionss for Type : {}", contentType);
		if(contentType == null || ContentTypeEnum.valueOf(contentType) == null) {
			throw new InvalidArgumentException("Content Type is Missing.");
		}
		
		List<SectionDTO> sectionDTOList = service.getAllByContentType(ContentTypeEnum.valueOf(contentType));

		System.out.println("SectionDTO list is " + sectionDTOList);
		LOGGER.trace("SectionDTO list is {}" , sectionDTOList);

		return sectionDTOList;
	}
}
