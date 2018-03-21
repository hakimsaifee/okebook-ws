package com.ebook.domain.repository;

import java.math.BigDecimal;

import com.ebook.domain.entity.Part;

public interface PartRepository extends AbstractRepository<Part, Long> {

	Part findBypartNumber(BigDecimal partId);

}
