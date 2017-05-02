package com.kpg.diary.dto;

public class AddressViewDto {

    private String number;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String email;
    private String title;
    private String firstName;
    private String lastName;
    private String mobile;

    /**
     * Instantiates a new address view dto.
     *
     * @param number
     *            the number
     * @param line1
     *            the line1
     * @param line2
     *            the line2
     * @param city
     *            the city
     * @param state
     *            the state
     * @param country
     *            the country
     * @param zip
     *            the zip
     * @param title
     *            the title
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @param mobile
     *            the mobile
     * @param email
     *            the email
     */
    public AddressViewDto(String number, String line1, String line2, String city, String state, String country,
	    String zip, String title, String firstName, String lastName, String mobile, String email) {
	this.number = number;
	this.line1 = line1;
	this.line2 = line2;
	this.city = city;
	this.state = state;
	this.country = country;
	this.zip = zip;
	this.title = title;
	this.firstName = firstName;
	this.lastName = lastName;
	this.mobile = mobile;
	this.email = email;
    }

    public AddressViewDto() {
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
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

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
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

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
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

    public String getMobile() {
	return mobile;
    }

    public void setMobile(String mobile) {
	this.mobile = mobile;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	if (objectNotNull(firstName) && objectNotNull(lastName)) {
	    builder.append(firstName + " " + lastName + "\n");
	}
	if (objectNotNull(mobile)) {
	    builder.append(mobile + "\n");
	}
	if (objectNotNull(email)) {
	    builder.append(email + "\n");
	}
	if (objectNotNull(line1)) {
	    builder.append("Line1: " + line1 + "\n");
	}
	if (objectNotNull(line2)) {
	    builder.append("Line2: " + line2 + "\n");
	}
	if (objectNotNull(line2)) {
	    builder.append("City: " + city).append(", " + state).append("(" + zip + ")\n");
	}
	if (objectNotNull(country)) {
	    builder.append(country);
	}
	return builder.toString();
    }

    /**
     * Object not null.
     *
     * @param string
     *            the string
     * @return true, if successful
     */
    private boolean objectNotNull(String string) {
	if (null != string && !string.isEmpty()) {
	    return true;
	}
	return false;
    }

}
