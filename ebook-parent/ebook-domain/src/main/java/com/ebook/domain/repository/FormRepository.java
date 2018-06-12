package com.ebook.domain.repository;

import com.ebook.common.enums.ContentTypeEnum;
import com.ebook.domain.entity.Form;

public interface FormRepository extends TypeAwareRepository<Form, Long> {
	
	public Form getByNumberAndContentType(String number, ContentTypeEnum contentTypeEnum);

}
