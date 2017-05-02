package com.kpg.diary.service;

import java.util.List;

/**
 * The Interface IService.
 *
 * @author Ankit Sood Dec 5, 2016
 * @param <T>
 *            the generic type
 */
public interface IService<T> {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<T> findAll();

	/**
	 * Save.
	 *
	 * @param entity
	 *            the entity
	 */
	public void save(final T entity);

	/**
	 * Save or update.
	 *
	 * @param entity
	 *            the entity
	 * @return the t
	 */
	public T saveOrUpdate(final T entity);

	/**
	 * Update.
	 *
	 * @param entity
	 *            the entity
	 */
	public void update(final T entity);

	/**
	 * Delete.
	 *
	 * @param entity
	 *            the entity
	 */
	public void delete(final T entity);
}
