/**
 * 
 */
package com.kpg.diary.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * BaseRepository.java
 * 
 * @author Nikhil Mahajan
 * @since Dec 3, 2016
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

}
