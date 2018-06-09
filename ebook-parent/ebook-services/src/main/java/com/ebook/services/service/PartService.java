package com.ebook.services.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.PartDTO;
import com.ebook.common.enums.ContentTypeEnum;
import com.ebook.domain.entity.Part;
import com.ebook.domain.entity.TypeAwareEntity;
import com.ebook.domain.repository.PartRepository;


@Service
public class PartService extends AbstractService<Part, PartDTO, PartRepository>{

	private static final Logger LOGGER = LoggerFactory.getLogger(PartService.class);
	
	public PartService() {
	}
	
	@Autowired
	public PartService(PartRepository repository, DozerBeanMapper dozerBeanMapper) {
		super(repository, dozerBeanMapper);
	}

	public PartDTO getPartByPartNumber(BigDecimal partNumber, ContentTypeEnum contentTypeEnum) {
		Part findBypartNumber = repository.findByPartNumberAndContentType(partNumber, contentTypeEnum);
		
		if(findBypartNumber !=null) {
			return beanMapper.map(findBypartNumber, PartDTO.class);
		}
		return null;
	}

	@Transactional
	public List<PartDTO> getAll(ContentTypeEnum contentTypeEnum) {
		Order order = new Order(Sort.Direction.ASC, "partNumber");
		Sort sort = new Sort(order);
		List<TypeAwareEntity> entities = repository.findAllBycontentType(contentTypeEnum,sort);
		List<PartDTO> partDTOList = new ArrayList<>();
		if (entities != null) {
			for (TypeAwareEntity entity : entities) {
				Part part = (Part) entity;
				PartDTO entityDTO = convertDaoToDto(part, PartDTO.class);
				partDTOList.add(entityDTO);
			}
		}
		return partDTOList;

	}

}