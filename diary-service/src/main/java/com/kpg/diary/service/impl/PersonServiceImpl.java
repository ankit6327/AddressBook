/**
 * 
 */
package com.kpg.diary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpg.diary.bean.PersonBean;
import com.kpg.diary.dao.PersonRepository;
import com.kpg.diary.dto.PersonDto;
import com.kpg.diary.model.Person;
import com.kpg.diary.service.BaseService;
import com.kpg.diary.service.PersonService;

/**
 * PersonServiceImpl.java
 * 
 * @author Nikhil Mahajan
 * @since Dec 3, 2016
 */
/*
 * @Service("personService")
 */
@Service("personService")
public class PersonServiceImpl extends BaseService<Person> implements PersonService {

    private PersonRepository personRepository;

    /**
     * Sets the person repository.
     *
     * @param personRepository
     *            the new person repository
     */
    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
	this.personRepository = personRepository;
	setGenericRepository(personRepository);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kpg.diary.service.PersonService#savePerson(com.kpg.diary.bean.
     * PersonBean)
     */
    public void savePerson(PersonBean bean) {
	Person person = new Person();
	person.setFirstName(bean.getFirstName());
	person.setLastName(bean.getLastName());
	person.setDob(bean.getDob());
	person.setMobile(bean.getMobile());
	person.setTitle(bean.getTitle());
	person.setEmail(bean.getEmail());
	if(bean.getId() != null){
	    person.setId(bean.getId());
	}
	personRepository.save(person);
    }

    @Override
    public List<PersonDto> findAllPersonDto() {
	return personRepository.findAllPersonDto();
    }

}
