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
public class Student {

    //field
    private String id;
    private String classID;
    private String currentClass;
    private String registrationDate;

    //contruction
    public Student()
    {
        id = null;
        classID = null;
        currentClass = null;
        registrationDate = null;
    }


    public Student(String id,String classID,String currentClass,String registrationDate)
    {
        setId(id);
        setClassID(classID);
        setCurrentClass(currentClass);
        setRegistrationDate(registrationDate);
    }

    //method get-set
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

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

