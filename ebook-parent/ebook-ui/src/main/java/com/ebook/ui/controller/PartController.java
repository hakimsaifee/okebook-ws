package com.ebook.ui.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

import com.ebook.common.dto.ChapterDTO;
import com.ebook.common.dto.ContactUsDTO;
import com.ebook.common.dto.NodeTypeEnum;
import com.ebook.common.dto.PartDTO;
import com.ebook.common.dto.SectionDTO;
import com.ebook.common.dto.TreeModel;
import com.ebook.common.dto.TreeWrapper;
import com.ebook.common.enums.ContentTypeEnum;
import com.ebook.common.util.SorterUtil;
import com.ebook.services.service.PartService;
import com.ebook.services.service.SectionService;
import com.ebook.ui.mail.AWSSendMail;

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = PartController.PART)
@CrossOrigin(origins = "*", maxAge = 3600)
public class PartController extends AbstractController<PartDTO, PartService> {
	public static final String PART = "part";

	private static final Logger LOGGER = LoggerFactory.getLogger(PartController.class);

	@Autowired
	private SectionService sectionService;

	@Autowired
	public PartController(PartService service) {
		super(service);
	}

	@RequestMapping(path = "savePart", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartDTO savePart(@RequestBody PartDTO partDTO, @RequestParam(value = "contentType") String contentType) {
		LOGGER.debug("Saving Part details {}", partDTO.getContentType());
		System.out.println("Saving Part details" + partDTO.getContentType());

		LOGGER.info("Get Part for Type : {}", contentType);
		if (contentType == null || ContentTypeEnum.valueOf(contentType) == null) {
			throw new IllegalArgumentException("Content Type is Missing.");
		}

		PartDTO part;
		if (partDTO != null && partDTO.getPartNumber() != null) {
			part = service.getPartByPartNumber(partDTO.getPartNumber(), ContentTypeEnum.valueOf(contentType));
			if (part != null) {
				LOGGER.info("Part Already Exists , Hence Couldnt add a new Entry {}", part.getId());
				// Part is already exits need to add more chapters into part.
				if (partDTO.getChapters() != null) {
					part.getChapters().addAll(partDTO.getChapters());
				}
				service.update(part);
			} else {
				LOGGER.info("Part Doesnt Exists , Creating a new Entry");

				// Checking is Sections Exists , If yes do a explicit mapping so
				// that we have part_Id relation in db
				if (partDTO.getChapters() != null && !partDTO.getChapters().isEmpty()) {
					Set<ChapterDTO> chapterDTOs = partDTO.getChapters();

					for (ChapterDTO chapterDTO : chapterDTOs) {
						chapterDTO.setPart(partDTO);
					}

				}
				partDTO = service.save(partDTO);

				// AWSSendMail.sendEmail();
				System.out.println("Saved DTO" + partDTO);
			}
		}
		return partDTO;

	}

	@RequestMapping(path = "contactMail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ContactUsDTO sendContactEmail(@RequestBody ContactUsDTO contactUsDTO) {
		LOGGER.debug("Sending contact email " + contactUsDTO);
		System.out.println("Sending contact email " + contactUsDTO);
		AWSSendMail.sendContactUsEmail(contactUsDTO);
		return contactUsDTO;
	}

	@RequestMapping(path = "partNumbers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PartDTO> getPartNumbers(@RequestParam(value = "contentType") String contentType) {

		LOGGER.info("Gell Part Numbers for Type : {}", contentType);
		if (contentType == null || ContentTypeEnum.valueOf(contentType) == null) {
			throw new IllegalArgumentException("Content Type is Missing.");
		}

		System.out.println("getPartNumbers");
		List<PartDTO> partDTOList = (List<PartDTO>) service.getAll(ContentTypeEnum.valueOf(contentType));

		System.out.println("partDTO list is " + partDTOList);

		return partDTOList;
	}

	@RequestMapping(path = "edit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartDTO editPart(@RequestBody PartDTO partDTO, @RequestParam(value = "contentType") String contentType) {
		LOGGER.debug("Editing Part details ");

		LOGGER.info("Get Part for Type : {}", contentType);
		if (contentType == null || ContentTypeEnum.valueOf(contentType) == null) {
			throw new IllegalArgumentException("Content Type is Missing.");
		}

		PartDTO part;
		if (partDTO != null && partDTO.getPartNumber() != null) {
			part = service.getPartByPartNumber(partDTO.getPartNumber(), ContentTypeEnum.valueOf(contentType));
			if (part != null) {

				/*
				 * LOGGER.info("Part Already Exists , Hence  Updating Entry {}",
				 * part.getId() ); if (partDTO.getChapters() != null &&
				 * !partDTO.getChapters().isEmpty()) { Set<ChapterDTO>
				 * chapterDTOs = partDTO.getChapters();
				 * 
				 * for (ChapterDTO chapterDTO : chapterDTOs) {
				 * chapterDTO.setPart(partDTO); }
				 * 
				 * }
				 */

				part.setPartHeading(partDTO.getPartHeading());
				part.setPartNumber(partDTO.getPartNumber());
				part = service.save(part);

				// AWSSendMail.sendEmail();
				System.out.println("Saved DTO" + partDTO);
			} else {
				LOGGER.warn("Part Doesnt Exists , Nothng to Update");

				// Checking is Sections Exists , If yes do a explicit mapping so
				// that we have part_Id relation in db

			}
		}
		return partDTO;
	}

	@RequestMapping(path = "partHeading", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartDTO getPartHeading(@RequestBody PartDTO partNumber,
			@RequestParam(value = "contentType") String contentType) {
		
		LOGGER.info("Get Part By Part Number : {} ", partNumber);

		LOGGER.info("Get Part for Type : {}", contentType);
		if (contentType == null || ContentTypeEnum.valueOf(contentType) == null) {
			throw new IllegalArgumentException("Content Type is Missing.");
		}

		PartDTO partDto = service.getPartByPartNumber(partNumber.getPartNumber(), ContentTypeEnum.valueOf(contentType));

		System.out.println("partDTO list is " + partDto);

		return partDto;
	}

	@RequestMapping(path = "get/getAllParts", produces = MediaType.APPLICATION_JSON_VALUE)
	public TreeWrapper getAllParts(@RequestParam(value = "contentType") String contentType) {
		LOGGER.info("Gell All Parts for : {}", contentType);
		if (contentType == null || ContentTypeEnum.valueOf(contentType) == null) {
			throw new IllegalArgumentException("Content Type is Missing.");
		}
		TreeWrapper treeWrapper = null;
		List<TreeModel> treeModels = null;
		Collection<PartDTO> elements = service.getAll(ContentTypeEnum.valueOf(contentType));
		if (elements != null && !elements.isEmpty()) {
			treeWrapper = new TreeWrapper();
			treeModels = new ArrayList<>();
			ArrayList<PartDTO> sortedList = new ArrayList<>(elements);
			Collections.sort(sortedList, SorterUtil.partComparator);
			for (PartDTO partDTO : sortedList) {
				TreeModel tree = new TreeModel();
				mapPartToTreeModel(partDTO, tree);
				treeModels.add(tree);
			}
			treeWrapper.setTreeModels(treeModels);
			// Adding sorted section list also.
			treeWrapper.setSections(getOrderedSections(ContentTypeEnum.valueOf(contentType)));
		}
		return treeWrapper;
	}

	private void mapPartToTreeModel(PartDTO partDTO, TreeModel tree) {
		tree.setData(partDTO.getPartNumber(), partDTO.getPartHeading(), NodeTypeEnum.PART);
		Set<ChapterDTO> chapters = partDTO.getChapters();
		if (chapters != null && !chapters.isEmpty()) {
			List<TreeModel> chaptersTree = new ArrayList<>();
			ArrayList<ChapterDTO> sortedList = new ArrayList<>(chapters);
			Collections.sort(sortedList, SorterUtil.chapterComparator);
			for (ChapterDTO chapterDTO : sortedList) {
				TreeModel chapterModel = new TreeModel();
				mapChapterToTreeModel(chapterDTO, chapterModel);
				chaptersTree.add(chapterModel);
			}
			tree.setChildren(chaptersTree);
		}
	}

	private void mapChapterToTreeModel(ChapterDTO chapterDTO, TreeModel chapterTree) {
		chapterTree.setData(chapterDTO.getChapterNumber(), chapterDTO.getChapterHeading(), NodeTypeEnum.CHAPTER);
		Set<SectionDTO> sections = chapterDTO.getSections();
		if (sections != null && !sections.isEmpty()) {
			List<TreeModel> sectionsTree = new ArrayList<>();
			ArrayList<SectionDTO> sortedList = new ArrayList<>(sections);
			Collections.sort(sortedList, SorterUtil.sectionComparator);
			for (SectionDTO sectionDTO : sortedList) {
				TreeModel sectionModel = new TreeModel();
				mapSectionToTreeModel(sectionDTO, sectionModel);
				sectionsTree.add(sectionModel);
			}
			chapterTree.setChildren(sectionsTree);
		}
	}

	private void mapSectionToTreeModel(SectionDTO sectionDTO, TreeModel sectionTree) {
		sectionTree.setData(sectionDTO.getSectionNumber(), sectionDTO.getSectionHeading(), NodeTypeEnum.SECTION);
	}

	private List<SectionDTO> getOrderedSections(ContentTypeEnum contentType) {
		return sectionService.getAll(contentType);
	}
}
