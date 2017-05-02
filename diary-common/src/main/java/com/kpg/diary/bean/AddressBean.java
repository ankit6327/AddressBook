package com.kpg.diary.bean;

import java.io.Serializable;

/**
 * The Class AddressBean.
 *
 * @author Ankit Sood Dec 6, 2016
 */
public class AddressBean implements Serializable {

    private static final long serialVersionUID = 1486265338001711137L;
    
    private Integer addressId;
    private Integer personId;
    private String line1;
    private String line2;
    private String city;
    
    private String number;
    private Boolean primary;
    private String state;
    private String country;
    private String zip;
    private String phone;
    
    
    
    /**
     * Instantiates a new address bean.
     *
     * @param addressId the address id
     * @param personId the person id
     * @param street1 the street1
     * @param street2 the street2
     * @param city the city
     * @param number the number
     * @param primary the primary
     * @param state the state
     * @param country the country
     * @param zip the zip
     * @param phone the phone
     */
    public AddressBean(Integer addressId, Integer personId, String line1, String line2, String city, String number,
	    Boolean primary, String state, String country, String zip, String phone) {
	this.addressId = addressId;
	this.personId = personId;
	this.line1 = line1;
	this.line2 = line2;
	this.city = city;
	this.number = number;
	this.primary = primary;
	this.state = state;
	this.country = country;
	this.zip = zip;
	this.phone = phone;
    }

    /**
     * Instantiates a new address bean.
     *
     * @param addressId the address id
     * @param personId the person id
     * @param street1 the street1
     * @param street2 the street2
     * @param city the city
     */
    public AddressBean(Integer addressId, Integer personId, String line1, String line2, String city) {
	this.addressId = addressId;
	this.personId = personId;
	this.line1 = line1;
	this.line2 = line2;
	this.city = city;
    }

    /**
     * Instantiates a new address bean.
     *
     * @param addressId the address id
     * @param street1 the street1
     * @param street2 the street2
     * @param city the city
     */
    public AddressBean(Integer addressId, String line1, String line2, String city) {
	this.addressId = addressId;
	this.line1 = line1;
	this.line2 = line2;
	this.city = city;
    }

    
    /**
     * Instantiates a new address bean.
     *
     * @param street1 the street1
     * @param street2 the street2
     * @param city the city
     */
    public AddressBean(String line1, String line2, String city) {
	this.line1 = line1;
	this.line2 = line2;
	this.city = city;
    }

    /**
     * Instantiates a new address bean.
     */
    public AddressBean() {
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
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

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }
    
}
