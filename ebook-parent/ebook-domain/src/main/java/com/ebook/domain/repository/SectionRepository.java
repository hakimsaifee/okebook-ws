package com.ebook.domain.repository;

import java.util.List;

import com.ebook.domain.entity.Section;

public interface SectionRepository extends AbstractRepository<Section, Long> {

	List<Section> findAllByOrderBySectionNumberAsc();

}
