package com.kpg.diary.dto;

import java.util.Date;

/**
 * The Class PersonDto.
 *
 * @author Ankit Sood Dec 6, 2016
 */
public class PersonDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date dob;

    // Action Buttons
    private String delete = "Delete";
    private String edit = "Edit";
    private String show = "Show";
    
    private String title;
    private String mobile;
    private String email;

    public PersonDto() {
    }

    public PersonDto(Integer id, String firstName, String lastName, Date dob) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
    }
    
    public PersonDto(Integer id, String firstName, String lastName, Date dob, String title, String mobile,
	    String email) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.title = title;
	this.mobile = mobile;
	this.email = email;
    }

    public String getDelete() {
	return delete;
    }

    public void setDelete(String delete) {
	this.delete = delete;
    }
    
    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }
    
    public String getShow() {
   	return show;
    }

    
    public void setShow(String show) {
        this.show = show;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
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

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public Date getDob() {
	return dob;
    }

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
