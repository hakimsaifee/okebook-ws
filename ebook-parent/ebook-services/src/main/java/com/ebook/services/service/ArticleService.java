package com.ebook.services.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.ArticleDTO;
import com.ebook.domain.entity.Article;
import com.ebook.domain.repository.ArticleRepository;

@Service
public class ArticleService extends AbstractService<Article, ArticleDTO, ArticleRepository> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	public ArticleService() {
	}

	@Autowired
	public ArticleService(ArticleRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}

	public List<ArticleDTO> getArticlesByPublishDate(String publishYear) {
		List<Article> articles = repository.findByPublishYearDesc(Integer.valueOf(publishYear));
		if (articles != null && !articles.isEmpty()) {
			List<ArticleDTO> articleDTO = new ArrayList<>();
			for (Article article : articles) {
				ArticleDTO dto = beanMapper.map(article, ArticleDTO.class);
				articleDTO.add(dto);
			}
			return articleDTO;
		}
		return null;
	}

	public List<Timestamp> getAllPublishDates() {
		return repository.findAllPublishDate();
	}
	
	@Override
	public Collection<ArticleDTO> getAll(int pageNumber, int pageSize) {
		Pageable page = new PageRequest(pageNumber - 1, pageSize, Direction.DESC,"publishDate");
		Page<Article> pagedElements = repository.findAll(page);
		return convertDaoToDto(pagedElements.getContent(), ArticleDTO.class);
	}

}