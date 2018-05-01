package com.ebook.services.service;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.ChapterDTO;
import com.ebook.common.dto.SectionDTO;
import com.ebook.domain.entity.Section;
import com.ebook.domain.entity.Chapter;
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
	@Override
	public List<SectionDTO> getAll() {
		List<Section> entities = repository.findAllByOrderBySectionNumberAsc();
		List<SectionDTO> sectionDTOList = new ArrayList<>();
		if (entities != null) {
			for(Section section :entities) {
				SectionDTO entityDTO = convertDaoToDto(section, dtoClazz);
				sectionDTOList.add(entityDTO);
			}
		}
		return sectionDTOList;
		
	}
	

	public SectionDTO getSectionBySectionNumber(BigDecimal sectionNumber) {
		Section section = this.repository.getBySectionNumber(sectionNumber);
		if (section != null) {
			return super.convertDaoToDto(section, SectionDTO.class);
		}
		return null;
	}

}
