package com.ebook.domain.repository;

import java.math.BigDecimal;

import com.ebook.domain.entity.RegulationPart;

public interface RegulationPartRepository extends AbstractRepository<RegulationPart, Long> {

	RegulationPart findByregulationChapterNumber(BigDecimal partId);

}
