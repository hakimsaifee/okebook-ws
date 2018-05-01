package com.ebook.domain.repository;

import java.math.BigDecimal;

import java.util.List;

import com.ebook.domain.entity.Section;

public interface SectionRepository extends AbstractRepository<Section, Long> {

	public Section getBySectionNumber(BigDecimal sectionNumber);
	
	List<Section> findAllByOrderBySectionNumberAsc();

}
