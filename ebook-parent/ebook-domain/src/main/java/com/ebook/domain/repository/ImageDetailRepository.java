package com.ebook.domain.repository;

import com.ebook.domain.entity.ImageDetail;

public interface ImageDetailRepository extends AbstractRepository<ImageDetail, Long> {

	ImageDetail getByImageName(String imageName);
	
}
