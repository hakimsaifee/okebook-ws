package com.ebook.ui.controller;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.dto.ImageDetailDTO;
import com.ebook.services.service.ImageDetailService;

@RestController // Need to include jackson formattor to get xml/json as needed.
@RequestMapping(value = ImageDetailController.IMAGE_DETAIL)
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImageDetailController extends AbstractController<ImageDetailDTO, ImageDetailService> {
	public static final String IMAGE_DETAIL = "imageDetail";

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageDetailController.class);

	@Autowired
	public ImageDetailController(ImageDetailService service) {
		super(service);
	}

	@RequestMapping(path = "addImageDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ImageDetailDTO add(@RequestBody ImageDetailDTO dto) {
		ImageDetailDTO foundImage = service.getByImageName(dto.getImageName());
		if(foundImage != null) {
			LOGGER.trace("Image Detail already exits with name : {} ", foundImage.getImageName());
			foundImage.setUpdatedTs(new Timestamp(System.currentTimeMillis()));
			return super.update(foundImage);
		} else {
			LOGGER.trace("Create new Image Detail with name :  {} ", dto.getImageName());	
			dto.setUpdatedTs(new Timestamp(System.currentTimeMillis()));
			return super.add(dto);
		}
	}
	
}
 