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

import com.ebook.common.dto.SectionDTO;
import com.ebook.common.enums.ContentTypeEnum;
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
				sectionDTOList.add(entityDTO);
			}
		}
		return sectionDTOList;

	}
}
