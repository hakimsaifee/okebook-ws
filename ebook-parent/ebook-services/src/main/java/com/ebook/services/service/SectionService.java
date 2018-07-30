package com.ebook.services.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.PartDTO;
import com.ebook.common.dto.SectionDTO;
import com.ebook.common.enums.ContentTypeEnum;
import com.ebook.domain.entity.Chapter;
import com.ebook.domain.entity.Part;
import com.ebook.domain.entity.Section;
import com.ebook.domain.entity.TypeAwareEntity;
import com.ebook.domain.repository.SectionRepository;

@Service
public class SectionService extends AbstractService<Section, SectionDTO, SectionRepository> {

	public SectionService() {
	}
	
	@Autowired
	public SectionService(SectionRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
	
	@Transactional
	public List<SectionDTO> getAll(ContentTypeEnum contentType) {
		Order order = new Order(Sort.Direction.ASC, "sectionNumber");
		Sort sort = new Sort(order);
		List<TypeAwareEntity> entities = repository.findAllBycontentType(contentType, sort);
		List<SectionDTO> sectionDTOList = new ArrayList<>();
		if (entities != null) {
			for(TypeAwareEntity entity :entities) {
				Section section = (Section) entity;
				SectionDTO entityDTO = convertDaoToDto(section, dtoClazz);
				sectionDTOList.add(entityDTO);
			}
		}
		return sectionDTOList;
		
	}
	

	public SectionDTO getSectionBySectionNumber(BigDecimal sectionNumber, ContentTypeEnum contentTypeEnum) {
		Section section = this.repository.getBySectionNumberAndContentType(sectionNumber, contentTypeEnum);
		if (section != null) {
			return super.convertDaoToDto(section, SectionDTO.class);
		}
		return null;
	}

	
	public List<SectionDTO> getAllByContentType(ContentTypeEnum contentTypeEnum) {
		Order order = new Order(Sort.Direction.ASC, "sectionNumber");
		Sort sort = new Sort(order);
		List<TypeAwareEntity> entities = repository.findAllBycontentType(contentTypeEnum, sort);
		List<SectionDTO> sectionDTOList = new ArrayList<>();
		if (entities != null) {
			for (TypeAwareEntity entity : entities) {
				Section section = (Section) entity;
				SectionDTO entityDTO = convertDaoToDto(section, SectionDTO.class);
				PartDTO partDTO = setPartDetails(section);
				entityDTO.setPart(partDTO);
				sectionDTOList.add(entityDTO);
			}
		}
		return sectionDTOList;

	}

	private PartDTO setPartDetails(Section section) {
		if(section != null) {
			Chapter chapter = section.getChapter();
			Part part = chapter != null ? chapter.getPart() : null;
			
			if(part == null) return null;
			
			PartDTO partDTO = new PartDTO();
			partDTO.setId(part.getId());
			partDTO.setPartHeading(part.getPartHeading());
			partDTO.setPartNumber(part.getPartNumber());
			return partDTO;
		}
		return null;
	}
}
