package com.ebook.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.ebook.domain.entity.Chapter;

public interface ChapterRepository extends AbstractRepository<Chapter, Long> {

	Chapter findBychapterNumber(BigDecimal chapterNumber);
	
	List<Chapter> findAllByOrderByChapterNumberAsc();

}
