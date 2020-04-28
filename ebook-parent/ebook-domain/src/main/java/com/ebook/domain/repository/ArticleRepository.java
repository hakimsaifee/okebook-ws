package com.ebook.domain.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.ebook.domain.entity.Article;

public interface ArticleRepository extends AbstractRepository<Article, Long> {

	@Query("select distinct year(ar.publishDate) FROM Article ar order by year(ar.publishDate) desc")
    List<Timestamp> findAllPublishDate();

	@Query(" FROM Article ar where EXTRACT(year from ar.publishDate)= ?1 order by year(ar.publishDate) desc")
	List<Article> findByPublishYearDesc(Integer publishYear);
}
