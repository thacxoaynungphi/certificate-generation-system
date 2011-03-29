/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nhchung
 * Date : 13/03/2011
 * Version 1.0
 */
public class Person {

    //field
    private String id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private int gender;
    private String phone;
    private String email;
    private String address;
    private String image;
    private int status;

    //contruction
    public Person() {
        id = null;
        firstName = null;
        lastName = null;
        birthDay = null;
        gender = 1;
        phone = null;
        email = null;
        address = null;
        image = null;
        status = 1;
    }

    public Person(String id, String firstName, String lastName, Date birthDay, int gender, String phone, String email, String address, String image) throws Exception {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDay(birthDay);
        setGender(gender);
        setPhone(phone);
        setEmail(email);
        setAddress(address);
        setImage(image);
        setStatus(1);
    }

    //method get - set
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) throws Exception {
        if (id.length() > 20 || id.length() <= 0) {
            throw new Exception("Id invalidation");
        } else {
            this.id = id;
        }
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) throws Exception {
        if (firstName.length() > 30 || firstName.length() < 0) {
            throw new Exception("Firstname invalidation");
        } else {
            this.firstName = firstName;
        }
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) throws Exception {
        if (lastName.length() > 20 || lastName.length() < 0) {
            throw new Exception("Lastname invalidation");
        } else {
            this.lastName = lastName;
        }
    }

    /**
     * @return the birthDay
     */
    public Date getBirthDay() {
        return birthDay;
    }

    /**
     * @param birthDay the birthDay to set
     */
    //TODO can them vao Pattern dinh dang ngay thang. tuy vao ngon ngu
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * @return the gender
     */
    public int getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(int gender) throws Exception {
        if (gender > 1 || gender < 0) {
            throw new Exception("Gender of Person must be \n0 -> Male \n1 -> Female");
        }
        this.gender = gender;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) throws Exception {
        if (phone.length() > 20) {
            throw new Exception("Phone string's length can't greater than 20");
        }
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) throws Exception {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]");
        Matcher match = pattern.matcher(email);
        if (match.matches()) {
            this.email = email;

        } else {
            throw new Exception("Email is not valid format");
        }
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) throws Exception {
        if (status > 1 || status < 0) {
            throw new Exception("Status invalidation");
        }
        this.status = status;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
