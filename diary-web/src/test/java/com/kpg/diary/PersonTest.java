/**
 * 
 */
package com.kpg.diary;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kpg.diary.model.Address;
import com.kpg.diary.model.Person;
import com.kpg.diary.service.AddressService;
import com.kpg.diary.service.PersonService;

/**
 * PersonTest.java
 * 
 * @author Nikhil Mahajan
 * @since Dec 3, 2016
 */
public class PersonTest extends BaseTest {

	@Autowired
	PersonService personService;

	@Autowired
	AddressService addressService;

	// @Test
	public void test() {
		try {
			List<Person> aoPersons = personService.findAll();
			Assert.assertNotNull(aoPersons);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createPerson() {
		Person person = createPersonVo();
		personService.save(person);
	}

	public Person createPersonVo() {
		Person person = new Person();
		person.setFirstName("firstNameDemo");
		person.setLastName("lastNameDemo");
		Address address = new Address();
		address.setLine1("street 1");
		address.setLine2("street 2");
		address.setPerson(person);
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		person.setAddresses(addresses);
		return person;
	}

}
