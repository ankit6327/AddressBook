package com.kpg.diary.service;

import com.kpg.diary.dao.BaseRepository;

/**
 * @author Ankit Sood Dec 5, 2016
 * @param <T>
 */
public abstract class BaseService<T> extends Service<T, Integer> {

	/**
	 * @param genericRepository
	 *            the genericRepository to set
	 */
	protected void setGenericRepository(BaseRepository<T, Integer> baseRepository) {
		setRepository(baseRepository);
	}
}
