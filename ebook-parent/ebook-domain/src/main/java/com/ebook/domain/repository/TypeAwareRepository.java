package com.ebook.domain.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import com.ebook.common.enums.ContentTypeEnum;
import com.ebook.domain.entity.TypeAwareEntity;

@NoRepositoryBean
public interface TypeAwareRepository<T extends TypeAwareEntity, E extends Serializable>
		extends AbstractRepository<T, E> {
	
	List<TypeAwareEntity> findAllBycontentType(ContentTypeEnum contentTypeEnum, Sort s);

}
