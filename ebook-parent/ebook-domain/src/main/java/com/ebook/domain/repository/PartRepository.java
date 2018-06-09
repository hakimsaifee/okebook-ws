package com.ebook.domain.repository;

import java.math.BigDecimal;

import com.ebook.common.enums.ContentTypeEnum;
import com.ebook.domain.entity.Part;

public interface PartRepository extends TypeAwareRepository<Part, Long> {

//	Part findBypartNumber(BigDecimal partId);
	
	public Part findByPartNumberAndContentType(BigDecimal partNumber, ContentTypeEnum contentTypeEnum);

	

}
