package com.kpg.diary.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * The Class PersonBean.
 *
 * @author Ankit Sood Dec 6, 2016
 */
public class PersonBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6153890349893193953L;
    private String firstName;
    private String lastName;
    private Date dob;
    private Integer id;
    
    private String title;
    private String mobile;
    private String email;
    
    

    /**
     * Instantiates a new person bean.
     *
     * @param firstName the first name
     * @param lastName the last name
     * @param dob the dob
     * @param id the id
     * @param title the title
     * @param mobile the mobile
     * @param email the email
     */
    public PersonBean(String firstName, String lastName, Date dob, Integer id, String title, String mobile,
	    String email) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.id = id;
	this.title = title;
	this.mobile = mobile;
	this.email = email;
    }



    /**
     * Instantiates a new person bean.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @param dob
     *            the dob
     */
    public PersonBean(String firstName, String lastName, Date dob) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
    }
    
    

    /**
     * Instantiates a new person bean.
     *
     * @param firstName the first name
     * @param lastName the last name
     * @param dob the dob
     * @param id the id
     */
    public PersonBean(String firstName, String lastName, Date dob, Integer id) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.id = id;
    }

    

    /**
     * Instantiates a new person bean.
     */
    public PersonBean() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }
    
    

}
