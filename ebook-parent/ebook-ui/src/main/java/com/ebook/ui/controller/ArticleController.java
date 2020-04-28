package com.ebook.ui.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.ArticleDTO;
import com.ebook.services.service.ArticleService;

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = ArticleController.ARTICLE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArticleController extends AbstractController<ArticleDTO, ArticleService> {
	public static final String ARTICLE = "article";

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	public ArticleController(ArticleService service) {
		super(service);
	}

	@RequestMapping(path = "get/getArticlesByPublishDate", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ArticleDTO> getArticlesByPublishDate(@RequestParam(value = "publishYear") String publishYear) {
		try {
			if (publishYear != null) {

				LOGGER.info("Fetching article for publish date: {}", publishYear);
				return service.getArticlesByPublishDate(publishYear);
			} else {
				LOGGER.error("Publish Date is not valid in the request : {} ", publishYear);
			}
		} catch (Exception e) {
			LOGGER.error("Error while fetching articles by publish date. " + e);
		}
		return null;
	}

	@RequestMapping(path = "get/getAllPublishDate", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Timestamp> getArticlesByPublishDate() {
		try {
			LOGGER.info("Fetching all publish dates...");
			return service.getAllPublishDates();

		} catch (Exception e) {
			LOGGER.error("Error while fetching all publish dates. " + e);
		}
		return null;
	}

	@RequestMapping(path = "get/getAllArticlePaged", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<ArticleDTO> getAllArticlePagedElements(@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize) {
		System.out.println("Inside get all");
		System.out.println("Page Number : " + pageNumber);
		System.out.println("Page Size : " + pageSize);
		
		return service.getAll(pageNumber, pageSize);
	}
}
