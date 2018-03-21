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

import com.ebook.common.dto.RegulationDTO;
import com.ebook.common.dto.RegulationPartDTO;
import com.ebook.domain.entity.RegulationPart;
import com.ebook.services.service.RegulationPartService;
import com.ebook.services.service.RegulationService;


@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = RegulationController.REGULATION)
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
		RegulationPartDTO regulationDTO = null;
		
		if(dto.getRegulationChapterNumber() !=null) {
			RegulationPart  regulationPart = regulationService.getRegulationByRegulationNumber(dto.getRegulationChapterNumber());
			if(regulationPart !=null) {
				LOGGER.info("Regulation Part Already Exists {} , Adding Regulations ",regulationPart.getId());

				Set<RegulationDTO> regulationDTOs = dto.getRegulations();
				
				if(regulationDTOs !=null && !regulationDTOs.isEmpty()) {
					
					for(RegulationDTO regDTO :regulationDTOs) {
						regDTO.setRegulationPart(regulationDTO);
						regDTO = service.save(regDTO);
					}
				
				}
			}else {
				System.out.println("Regulation Part Doesnt Exists , Hence Wont Add regulations");
				
			}
		}
		return regulationDTO;
		
	}
	
}
