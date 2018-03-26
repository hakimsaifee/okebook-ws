package com.ebook.services.service;

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
}
