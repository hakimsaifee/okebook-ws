package com.ebook.services.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ebook.domain.repository.AbstractRepository;

public abstract class AbstractService<T, V, E extends AbstractRepository<T, ?>> {

	protected E repository;

	private Class<V> dtoClazz;
	private Class<T> daoClazz;

	protected DozerBeanMapper beanMapper;

	  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);
	  
	public AbstractService() {
	}

	public AbstractService(E repository) {
		this.repository = repository;
	}

	@SuppressWarnings("unchecked")
	public AbstractService(E repository, DozerBeanMapper beanMapper) {
		this.repository = repository;
		this.beanMapper = beanMapper;
		daoClazz = (Class<T>) ((java.lang.reflect.ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

		dtoClazz = (Class<V>) ((java.lang.reflect.ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];

	}

	// TODO: Implement proper exception handling on all methods.
	@Transactional
	public Collection<V> getAll() {
		Iterable<T> entities = repository.findAll();
		if (entities != null) {
			return convertDaoToDto((Collection<T>) entities, dtoClazz);
		}
		return null;
	}

	public V save(V dto) {
		T entity = convertDtoToDao(dto, daoClazz);

		T savedEntity = repository.save(entity);

		return convertDaoToDto(savedEntity, dtoClazz);
	}

	@Transactional
	public V update(V dto) {
		return save(dto);
	}

	public V getById(Long id) {
		T entity = repository.findOne(id);
		return convertDaoToDto(entity, dtoClazz);
	}

	public long getCount() {
		return repository.count();
	}

	public Collection<V> getAll(int pageNumber, int pageSize) {
		Pageable page = new PageRequest(pageNumber - 1, pageSize);
		Page<T> pagedElements = repository.findAll(page);
		return convertDaoToDto(pagedElements.getContent(), dtoClazz);
	}

	private V convertDaoToDto(T source, Class<V> object) {
		if (source != null) {
			return beanMapper.map(source, object);
		}
		return null;
	}

	private Collection<V> convertDaoToDto(Collection<T> source, Class<V> object) {
		if (source != null && !source.isEmpty()) {
			List<V> targetObjects = new ArrayList<>();
			source.forEach(e -> {
				V obj = convertDaoToDto(e, object);
				if (obj != null) {
					targetObjects.add(obj);
				}
			});
			return targetObjects;
		}
		return null;
	}

	private T convertDtoToDao(V dto, Class<T> dao) {
		if (dto != null) {
			return beanMapper.map(dto, dao);
		}
		return null;
	}
}
