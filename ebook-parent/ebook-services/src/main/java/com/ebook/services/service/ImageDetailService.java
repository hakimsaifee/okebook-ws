package com.ebook.services.service;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.ImageDetailDTO;
import com.ebook.domain.entity.ImageDetail;
import com.ebook.domain.repository.ImageDetailRepository;


@Service
public class ImageDetailService extends AbstractService<ImageDetail, ImageDetailDTO, ImageDetailRepository>{

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageDetailService.class);
	
	public ImageDetailService() {
	}
	
	@Autowired
	public ImageDetailService(ImageDetailRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}
	
	public ImageDetailDTO getByImageName(String imageName) {
		ImageDetail byImageName = repository.getByImageName(imageName);
		LOGGER.trace("Found Image with name : {} ", imageName);
		if(byImageName == null) {
			return null;
		}
		return beanMapper.map(byImageName, ImageDetailDTO.class);
		
	}
}