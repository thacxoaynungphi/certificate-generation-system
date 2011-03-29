/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import com.hueic.CerGS.component.PropertyIndex;

/**
 *
 * @author nhchung
 * Date: 13/03/2011
 * Version: 1.0
 */
public class Subject implements PropertyIndex {

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

    public Subject(String id, String name, int coefficient, String courseID) throws Exception {
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
    public void setId(String id) throws Exception {
        if (id.length() <= 0 || id.length() > 10) {
            throw new Exception("Id invalidation");
        }
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
    public void setName(String name) throws Exception {
        if (name.length() <= 0 || name.length() > 100) {
            throw new Exception("Subject name invalidation");
        } else {
            this.name = name;
        }
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
    public void setCoefficient(int coefficient) throws Exception {
        if (coefficient <= 0) {
            throw new Exception("Coefficient invalidation");
        } else {
            this.coefficient = coefficient;
        }
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
    public void setCourseID(String courseID) throws Exception {
        if (courseID.length() <= 0 || courseID.length() > 20) {
            throw new Exception("Course id invalidation");
        } else {
            this.courseID = courseID;
        }
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
        if (status != 0 && status != 1) {
            throw new Exception("Status invalidation");
        } else {
            this.status = status;
        }
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getId());
                break;
            case 2:
                value = String.valueOf(this.getName());
                break;
            case 3:
                value = String.valueOf(this.getCoefficient());
                break;
            case 4:
                value = String.valueOf(this.getCourseID());
                break;

            case 5:
                value = String.valueOf(this.getStatus());
                break;
        }
        return value;
    }

    public void setPropertyValue(int index, Object value) {
    }

    public Class getPropertyClass(int index) {
        return String.class;
    }
}
