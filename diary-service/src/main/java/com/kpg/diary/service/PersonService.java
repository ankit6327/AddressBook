/**
 * 
 */
package com.kpg.diary.service;

import java.util.List;

import com.kpg.diary.bean.PersonBean;
import com.kpg.diary.dto.PersonDto;
import com.kpg.diary.model.Person;

/**
 * PersonService.java
 * 
 * @author Nikhil Mahajan
 * @since Dec 3, 2016
 */
public interface PersonService extends IService<Person> {

    /**
     * Save person.
     *
     * @param bean
     *            the bean
     */
    public void savePerson(PersonBean bean);
    
    public List<PersonDto> findAllPersonDto();

    public void deleteById(Integer id);
    

}
