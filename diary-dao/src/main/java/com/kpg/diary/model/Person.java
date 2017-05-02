/**
 * 
 */
package com.kpg.diary.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Person.java
 * 
 * @author Nikhil Mahajan
 * @since Dec 3, 2016
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3312605145172227695L;
	
	private Integer id;
	private String title;
	private String firstName;
	private String lastName;
	private Date dob;
	private String mobile;
	private String email;
	private List<Address> addresses = new ArrayList<>();
	
	/**
	 * Instantiates a new person.
	 *
	 * @param id the id
	 */
	public Person(Integer id) {
	    this.id = id;
	}
	
	

	/**
	 * Instantiates a new person.
	 */
	public Person() {
	}



	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@Column(name = "PERSON_ID", unique = true, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the addresses.
	 *
	 * @return the addresses
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * Sets the addresses.
	 *
	 * @param addresses
	 *            the new addresses
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob
	 *            the new dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getTitle() {
	    return title;
	}



	public void setTitle(String title) {
	    this.title = title;
	}



	public String getMobile() {
	    return mobile;
	}



	public void setMobile(String mobile) {
	    this.mobile = mobile;
	}



	public String getEmail() {
	    return this.email;
	}



	public void setEmail(String email) {
	    this.email = email;
	}
	
}
