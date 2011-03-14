/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

/**
 *
 * @author nhchung
 * Date: 13/03/2011
 * Version: 1.0
 */
public class Subject {

    //field
    private String id;
    private String name;
    private int coefficient;
    private String courseID;
    private int status;

    //contruction
    public Subject() {
        id = null;
        name = null;
        coefficient = 0;
        courseID = null;
        status = 0;
    }

    public Subject(String id, String name, int coefficient, String courseID) {
        setId(id);
        setName(name);
        setCoefficient(coefficient);
        setCourseID(courseID);
        setStatus(1);
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the coefficient
     */
    public int getCoefficient() {
        return coefficient;
    }

    /**
     * @param coefficient the coefficient to set
     */
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * @return the courseID
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
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
    public void setStatus(int status) {
        this.status = status;
    }
}
