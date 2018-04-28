package com.ebook.ui.controller;

import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.ChapterDTO;
import com.ebook.common.dto.PartDTO;
import com.ebook.common.dto.SectionDTO;
import com.ebook.common.dto.TreeModel;
import com.ebook.services.service.PartService;

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = PartController.PART)
@CrossOrigin(origins = "*", maxAge = 3600)
public class PartController extends AbstractController<PartDTO, PartService> {
	public static final String PART = "part";

	private static final Logger LOGGER = LoggerFactory.getLogger(PartController.class);

	@Autowired
	public PartController(PartService service) {
		super(service);
	}

	@RequestMapping(path = "savePart", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartDTO savePart(@RequestBody PartDTO partDTO) {
		LOGGER.debug("Saving Part details ");

		PartDTO part;
		if (partDTO != null && partDTO.getPartNumber() != null) {
			part = service.getPartByPartNumber(partDTO.getPartNumber());
			if (part != null) {
				LOGGER.info("Part Already Exists , Hence Couldnt add a new Entry {}", part.getId());
			} else {
				LOGGER.info("Part Doesnt Exists , Creating a new Entry");

					//Checking is Sections Exists , If yes do a explicit mapping so that we have part_Id relation in db
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

	@RequestMapping(path = "partNumbers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PartDTO> getPartNumbers() {
		System.out.println("getPartNumbers");
		List<PartDTO> partDTOList = (List<PartDTO>) service.getAll();

		System.out.println("partDTO list is " + partDTOList);

		return partDTOList;
	}

	@RequestMapping(path = "edit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartDTO editPart(@RequestBody PartDTO partDTO) {
	LOGGER.debug("Editing Part details ");
	
		PartDTO  part;
		if(partDTO !=null && partDTO.getPartNumber() !=null) {
			part = service.getPartByPartNumber(partDTO.getPartNumber());
			if(part !=null) {
				
				/*LOGGER.info("Part Already Exists , Hence  Updating Entry {}", part.getId() );
				if(partDTO.getChapters() !=null && !partDTO.getChapters().isEmpty()) {
					Set<ChapterDTO> chapterDTOs = partDTO.getChapters();
					
					for(ChapterDTO chapterDTO :chapterDTOs) {
						chapterDTO.setPart(partDTO);
					}
				
				}*/
				
				part.setPartHeading(partDTO.getPartHeading());
				part.setPartNumber(partDTO.getPartNumber());
				part = service.save(part);
				
				//AWSSendMail.sendEmail();
				System.out.println("Saved DTO" + partDTO);
			}else {
				LOGGER.warn("Part Doesnt Exists , Nothng to Update");
				
				//Checking is Sections Exists , If yes do a explicit mapping so that we have part_Id relation in db
				
			}
		}
		return partDTO;
	}
	@RequestMapping(path = "partHeading", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PartDTO getPartHeading(@RequestBody PartDTO partNumber) {
		System.out.println("getPartHeading");

		PartDTO partDto = service.getPartByPartNumber(partNumber.getPartNumber());

		System.out.println("partDTO list is " + partDto);

		return partDto;
	}

	@RequestMapping(path = "get/getAllParts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TreeModel> getAllParts() {
		// TreeModel root = new TreeModel();
		List<TreeModel> treeModels = null;
		Collection<PartDTO> elements = service.getAll();
		if (elements != null && !elements.isEmpty()) {
			treeModels = new ArrayList<>();
			for (PartDTO partDTO : elements) {
				TreeModel tree = new TreeModel();
				mapPartToTreeModel(partDTO, tree);
				treeModels.add(tree);
			}
		}
		// root.setChildren(treeModels);
		return treeModels;
	}

	private void mapPartToTreeModel(PartDTO partDTO, TreeModel tree) {
		tree.setData("Part " + partDTO.getPartNumber() + " | " + partDTO.getPartHeading());
		Set<ChapterDTO> chapters = partDTO.getChapters();
		if (chapters != null && !chapters.isEmpty()) {
			List<TreeModel> chaptersTree = new ArrayList<>();
			for (ChapterDTO chapterDTO : chapters) {
				TreeModel chapterModel = new TreeModel();
				mapChapterToTreeModel(chapterDTO, chapterModel);
				chaptersTree.add(chapterModel);
			}
			tree.setChildren(chaptersTree);
		}
	}

	private void mapChapterToTreeModel(ChapterDTO chapterDTO, TreeModel chapterTree) {
		chapterTree.setData("Chapter " + chapterDTO.getChapterNumber() + " | " + chapterDTO.getChapterHeading());
		Set<SectionDTO> sections = chapterDTO.getSections();
		if (sections != null && !sections.isEmpty()) {
			List<TreeModel> sectionsTree = new ArrayList<>();
			for (SectionDTO sectionDTO : sections) {
				TreeModel sectionModel = new TreeModel();
				mapChapterToTreeModel(sectionDTO, sectionModel);
				sectionsTree.add(sectionModel);
			}
			chapterTree.setChildren(sectionsTree);
		}
	}

	private void mapChapterToTreeModel(SectionDTO sectionDTO, TreeModel sectionTree) {
		sectionTree.setData("Section " + sectionDTO.getSectionNumber() + " | " + sectionDTO.getSectionHeading());
	}

}
