/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;
/**
 *
 * @author nhchung
 * Date : 13/03/2011
 * Version : 1.0
 */
public class Student extends Person {

    //field
    private String classID;
    private String currentClass;
    private String registrationDate;

    //contruction
    public Student()
    {
        super();
        classID = null;
        currentClass = null;
        registrationDate = null;
    }

    public Student(String id,String firstName,String lastName,String birthDay,int gender,String phone,String email,String address,String image,String classID,String currentClass,String registrationDate) throws Exception
    {
        super(id, firstName, lastName, birthDay, gender, phone, email, address, image);
        setClassID(classID);
        setCurrentClass(currentClass);
        setRegistrationDate(registrationDate);
    }

    //method get-set    
    /**
     * @return the classID
     */
    public String getClassID() {
        return classID;
    }

    /**
     * @param classID the classID to set
     */
    public void setClassID(String classID) {
        this.classID = classID;
    }

    /**
     * @return the currentClass
     */
    public String getCurrentClass() {
        return currentClass;
    }

    /**
     * @param currentClass the currentClass to set
     */
    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    /**
     * @return the registraionDate
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registraionDate the registraionDate to set
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }    
}