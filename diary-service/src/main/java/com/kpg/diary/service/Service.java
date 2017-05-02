package com.kpg.diary.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

import com.kpg.diary.dao.BaseRepository;

/**
 * The Class Service.
 *
 * @author Ankit Sood Dec 5, 2016
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 */
public abstract class Service<T, ID extends Serializable> {

	/** The dao generic. */
	/* genericRepository<T> genericRepository; */
	protected BaseRepository<T, ID> repository;

	/**
	 * Sets the repository.
	 *
	 * @param repository
	 *            the repository
	 */
	protected void setRepository(BaseRepository<T, ID> repository) {
		this.repository = repository;
	}

	/**
	 * Find one.
	 * 
	 * @param id
	 *            the id
	 * @return the t
	 */

	public T findOne(ID id) {
		return repository.findOne(id);
	}

	/**
	 * Gets the reference.
	 * 
	 * @param id
	 *            the id
	 * @return the reference
	 */
	public T getReference(ID id) {
		return repository.findOne(id);
	}

	/**
	 * Find all.
	 * 
	 * @return the list
	 */
	public List<T> findAll() {
		return repository.findAll();
	}

	/**
	 * Save.
	 * 
	 * @param entity
	 *            the entity
	 */
	public void save(T entity) {
		repository.save(entity);
	}

	/**
	 * Update.
	 * 
	 * @param entity
	 *            the entity
	 */
	public void update(T entity) {
		repository.save(entity);

	}

	/**
	 * Save or update.
	 *
	 * @param entity
	 *            the entity
	 * @return the t
	 */
	public T saveOrUpdate(T entity) {
		return repository.save(entity);

	}

	/**
	 * Delete.
	 * 
	 * @param entity
	 *            the entity
	 */
	public void delete(T entity) {
		repository.delete(entity);

	}

	/**
	 * Delete by id.
	 * 
	 * @param entityId
	 *            the entity id
	 */
	@Modifying
	public void deleteById(ID entityId) {
		repository.delete(entityId);
	}

}
