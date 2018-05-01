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

import com.ebook.common.dto.RegulationDTO;
import com.ebook.common.dto.RegulationPartDTO;
import com.ebook.services.service.RegulationPartService;
import com.ebook.services.service.RegulationService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = RegulationController.REGULATION)
@CrossOrigin(origins="*", maxAge = 3600)
public class RegulationController extends AbstractController<RegulationDTO, RegulationService>  {
	public static final String REGULATION = "regulation";

	private static final Logger LOGGER = LoggerFactory.getLogger(RegulationController.class);
	
	@Autowired
	public RegulationController(RegulationService service) {
		super(service);
	}
	
	@Autowired
	public RegulationPartService regulationService;
	
	@RequestMapping(path = "saveRegulation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RegulationPartDTO saveRegulation(@RequestBody RegulationPartDTO dto) {
		System.out.println("Update");
		RegulationPartDTO  regulationPart = null;
		
		if(dto.getRegulationChapterNumber() !=null) {
			regulationPart = regulationService.getRegulationByRegulationNumber(dto.getRegulationChapterNumber());
			if(regulationPart !=null) {
				LOGGER.info("Regulation Part Already Exists {} , Adding Regulations ",regulationPart.getId());

				Set<RegulationDTO> regulationDTOs = dto.getRegulations();
				
				if(regulationDTOs !=null && !regulationDTOs.isEmpty()) {
					
					for(RegulationDTO regDTO :regulationDTOs) {
						regDTO.setRegulationPart(regulationPart);
						regDTO = service.save(regDTO);
					}
				
				}
			}else {
				System.out.println("Regulation Part Doesnt Exists , Hence Wont Add regulations");
				
			}
		}
		return regulationPart;
		
	}
	
	
	@RequestMapping(path = "edit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RegulationPartDTO editRegulation(@RequestBody RegulationPartDTO regulationPartDTO) {
		LOGGER.debug("Editing Regulation details ");

		RegulationPartDTO entityDTO = new RegulationPartDTO();
		if (regulationPartDTO != null && regulationPartDTO.getRegulations() != null && !regulationPartDTO.getRegulations().isEmpty()) {
			
			entityDTO = regulationService.getRegulationByRegulationNumber(regulationPartDTO.getRegulationChapterNumber());
			LOGGER.info("Regulation Already Exists , Hence Updating {}", entityDTO.getId());
			
			Set<RegulationDTO> regulationDTOs = regulationPartDTO.getRegulations();
			
			for(RegulationDTO regulationDTO : regulationDTOs) {
				regulationDTO.setRegulationPart(entityDTO);
				regulationDTO = service.update(regulationDTO);
				// AWSSendMail.sendEmail();
				System.out.println("Saved DTO" + entityDTO);
			}
		} else {
			LOGGER.warn("Chapter Doesnt Exists , Nothng to Update");
		}
		return entityDTO;
		
	}
}
