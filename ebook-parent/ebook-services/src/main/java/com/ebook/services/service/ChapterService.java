package com.ebook.services.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.ChapterDTO;
import com.ebook.domain.entity.Chapter;
import com.ebook.domain.repository.ChapterRepository;

@Service
public class ChapterService extends AbstractService<Chapter, ChapterDTO, ChapterRepository>{

	public ChapterService() {
	}
	
	@Autowired
	public ChapterService(ChapterRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
	
	public ChapterDTO getChapterByChapterNumber(BigDecimal chapterNumber) {
		Chapter findBychapterNumber = repository.findBychapterNumber(chapterNumber);
		
		if(findBychapterNumber !=null) {
			return beanMapper.map(findBychapterNumber, ChapterDTO.class);
		}
		return null;
	}
	
	
	@Transactional
	@Override
	public List<ChapterDTO> getAll() {
		List<Chapter> entities = repository.findAllByOrderByChapterNumberAsc();
		List<ChapterDTO> chapterDTOList = new ArrayList<>();
		if (entities != null) {
			for(Chapter chapter :entities) {
				ChapterDTO entityDTO = convertDaoToDto(chapter, dtoClazz);
				chapterDTOList.add(entityDTO);
			}
		}
		return chapterDTOList;
		
	}
	
}
