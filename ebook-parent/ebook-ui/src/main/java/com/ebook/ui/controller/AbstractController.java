package com.ebook.ui.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ebook.domain.repository.AbstractRepository;
import com.ebook.services.service.AbstractService;

@CrossOrigin(origins = "*", maxAge = 3600)
public abstract class AbstractController<V, E extends AbstractService<?, V, ? extends AbstractRepository<?, ?>>> {

	protected E service;

	public AbstractController() {
	}

	public AbstractController(E service) {
		this.service = service;
	}

	@RequestMapping(path = "get/getById", produces = MediaType.APPLICATION_JSON_VALUE)
	public V getById(@RequestParam(value = "id") String id) {
		return service.getById(Long.parseLong(id));
	}

	
	@RequestMapping(path = "delete", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean delete(@RequestParam(value = "id") String id) {
		service.delete(Long.parseLong(id));
		return Boolean.TRUE;
	}
	
	
	@RequestMapping(path = "get/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<V> getAll() {
		Collection<V> elements = service.getAll();
		return elements;
	}

	@RequestMapping(path = "add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public V add(@RequestBody V dto) {
		return service.save(dto);
	}

	@RequestMapping(path = "update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public V update(@RequestBody V dto) {
		return service.update(dto);
	}

	@RequestMapping(path = "get/getAllPaged", produces = MediaType.APPLICATION_JSON_VALUE)
	public AbstractPageWrapper<V> getAllPagedElements(@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize) {
		System.out.println("Inside get all");
		System.out.println("Page Number : " + pageNumber);
		System.out.println("Page Size : " + pageSize);
		List<V> list = new ArrayList<V>();
		Collection<V> elements = service.getAll(pageNumber, pageSize);

		if (elements != null && !elements.isEmpty()) {
			elements.forEach(e -> list.add(e));
		}

		AbstractPageWrapper<V> pageWrapper = new AbstractPageWrapper<>();
		pageWrapper.setElements(list);
		int totalPages = (int) service.getCount();
		pageWrapper.setTotalRecords(totalPages);
		return pageWrapper;
	}

}
