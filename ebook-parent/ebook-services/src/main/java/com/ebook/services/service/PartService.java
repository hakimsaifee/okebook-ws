package com.ebook.services.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.common.dto.PartDTO;
import com.ebook.domain.entity.Part;
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

	public PartDTO getPartByPartNumber(BigDecimal partNumber) {
		Part findBypartNumber = repository.findBypartNumber(partNumber);
		
		if(findBypartNumber !=null) {
			return beanMapper.map(findBypartNumber, PartDTO.class);
		}
		return null;
	}

	@Transactional
	@Override
	public List<PartDTO> getAll() {
		List<Part> entities = repository.findAllByOrderByPartNumberAsc();
		List<PartDTO> partDTOList = new ArrayList<>();
		if (entities != null) {
			for (Part part : entities) {
				PartDTO entityDTO = convertDaoToDto(part, PartDTO.class);
				partDTOList.add(entityDTO);
			}
		}
		return partDTOList;

	}

}