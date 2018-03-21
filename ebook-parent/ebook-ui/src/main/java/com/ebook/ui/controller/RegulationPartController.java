package com.ebook.ui.controller;

import java.util.List;
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

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = RegulationPartController.PART_REGULATION)
public class RegulationPartController extends AbstractController<RegulationPartDTO, RegulationPartService> {
	public static final String PART_REGULATION = "partRegulation";

	private static final Logger LOGGER = LoggerFactory.getLogger(RegulationController.class);

	@Autowired
	public RegulationPartController(RegulationPartService service) {
		super(service);
	}

	@RequestMapping(path = "saveRegulation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RegulationPartDTO saveRegulation(@RequestBody RegulationPartDTO regulationPartDTO) {
		LOGGER.debug("Saving Regulation details ");

		RegulationPart regulationPart;
		if (regulationPartDTO != null && regulationPartDTO.getRegulationChapterNumber() != null) {
			regulationPart = service.getRegulationByRegulationNumber(regulationPartDTO.getRegulationChapterNumber());
			if (regulationPart != null) {
				LOGGER.info("Regulation Already Exists , Hence Couldnt add a new Entry {}", regulationPart.getId());
			} else {
				LOGGER.info("Regulation Doesnt Exists , Creating a new Entry");

				// Checking is Sections Exists , If yes do a explicit mapping so that we have
				// part_Id relation in db
				if (regulationPartDTO.getRegulations() != null && !regulationPartDTO.getRegulations().isEmpty()) {
					Set<RegulationDTO> regulationDTOs = regulationPartDTO.getRegulations();

					for (RegulationDTO regulationDTO : regulationDTOs) {
						regulationDTO.setRegulationPart(regulationPartDTO);
					}
				}
				regulationPartDTO = service.save(regulationPartDTO);

				// AWSSendMail.sendEmail();
				System.out.println("Saved DTO" + regulationPartDTO);
			}
		}
		return regulationPartDTO;
	}
	
	
	
	@RequestMapping(path = "regulationPartNumbers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RegulationPartDTO> getRegulationPartNumbers() {
		System.out.println("Get Regulation Part Number");
		List<RegulationPartDTO> regulationPartDTOs = (List<RegulationPartDTO>) service.getAll();
		
		System.out.println("RegulationPartDTO list is " + regulationPartDTOs);
	
		return regulationPartDTOs;
	}
	
	
	@RequestMapping(path = "regulationPartHeading", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public  RegulationPart getregulationPartHeading(@RequestBody RegulationPartDTO regulationPartNumber) {
		System.out.println("getPartHeading");
		
		RegulationPart partDto = service.getRegulationByRegulationNumber(regulationPartNumber.getRegulationChapterNumber());
		
		System.out.println("partDTO list is " + partDto);
	
		return partDto;
	}
}
