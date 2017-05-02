/**
 * 
 */
package com.kpg.diary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kpg.diary.dto.PersonDto;
import com.kpg.diary.model.Person;

/**
 * PersonRepository.java
 * 
 * @author Nikhil Mahajan
 * @since Dec 3, 2016
 */
@Repository
public interface PersonRepository extends BaseRepository<Person, Integer> {

    @Query("SELECT new com.kpg.diary.dto.PersonDto(p.id,p.firstName,p.lastName,p.dob, p.title, p.mobile, p.email) FROM Person p")
    List<PersonDto> findAllPersonDto();

}
