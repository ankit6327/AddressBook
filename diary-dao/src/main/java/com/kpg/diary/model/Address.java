package com.kpg.diary.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Address.
 *
 * @author Ankit Sood Dec 5, 2016
 */
/** 
 * @author Jatinder Pal Singh
 * @since 08-Dec-2016 
 */
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4786096645563960973L;
    private Integer addressId;
    private Person person;
    private String number;
    private String line1;
    private String line2;
    private String city;
    private Boolean primaryAddress;
    private String state;
    private String country;
    private String zip;
    private String phone;
    // private Boolean prmry;

    /**
     * Instantiates a new address.
     *
     * @param addressId the address id
     */
    public Address(Integer addressId) {
	this.addressId = addressId;
    }
    
    
    
    /**
     * Instantiates a new address.
     */
    public Address() {
    }



    /**
     * Gets the address id.
     *
     * @return the address id
     */
    @Id
    @Column(name = "ADDRESS_ID", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAddressId() {
	return addressId;
    }


    /**
     * Sets the address id.
     *
     * @param addressId
     *            the new address id
     */
    public void setAddressId(Integer addressId) {
	this.addressId = addressId;
    }

    /**
     * Gets the person.
     *
     * @return the person
     */
    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "PERSON_ID", nullable = true)
    public Person getPerson() {
	return person;
    }

    /**
     * Sets the person.
     *
     * @param person
     *            the new person
     */
    public void setPerson(Person person) {
	this.person = person;
    }

    /**
     * Gets the street1.
     *
     * @return the street1
     */
    @Column(name = "STREET1")
    public String getLine1() {
	return line1;
    }

    /**
     * Sets the street1.
     *
     * @param street1
     *            the new street1
     */
    public void setLine1(String line1) {
	this.line1 = line1;
    }

    /**
     * Gets the street2.
     *
     * @return the street2
     */
    @Column(name = "STREET2")
    public String getLine2() {
	return line2;
    }

    /**
     * Sets the street2.
     *
     * @param street2
     *            the new street2
     */
    public void setLine2(String line2) {
	this.line2 = line2;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    @Column(name = "CITY")
    public String getCity() {
	return city;
    }

    /**
     * Sets the city.
     *
     * @param city
     *            the new city
     */
    public void setCity(String city) {
	this.city = city;
    }



    public String getNumber() {
        return number;
    }



    public void setNumber(String number) {
        this.number = number;
    }



    public Boolean getPrimaryAddress() {
        return primaryAddress;
    }



    public void setPrimaryAddress(Boolean primaryAddress) {
        this.primaryAddress = primaryAddress;
    }



    public String getState() {
        return state;
    }



    public void setState(String state) {
        this.state = state;
    }



    public String getCountry() {
        return country;
    }



    public void setCountry(String country) {
        this.country = country;
    }



    public String getZip() {
        return zip;
    }



    public void setZip(String zip) {
        this.zip = zip;
    }



    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }

    

}
