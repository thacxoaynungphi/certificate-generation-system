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
public class Certificate implements PropertyIndex {

    //field
    private int id;
    private String studentID;
    private float score;
    private String degreeDay;

    //contruction
    public Certificate() {
        id = 0;
        studentID = null;
        score = 0;
        degreeDay = null;
    }

    public Certificate(int id, String studentID, float score, String degreeDay) {
        setId(id);
        setStudentID(studentID);
        setScore(score);
        setDegreeDay(degreeDay);
    }

    //method get-set
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the sourse
     */
    public float getScore() {
        return score;
    }

    /**
     * @param sourse the sourse to set
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     * @return the degreeDay
     */
    public String getDegreeDay() {
        return degreeDay;
    }

    /**
     * @param degreeDay the degreeDay to set
     */
    public void setDegreeDay(String degreeDay) {
        this.degreeDay = degreeDay;
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getId());
                break;
            case 2:
                value = this.getStudentID();
                break;
            case 3:
                value = String.valueOf(this.getScore());
                break;
            case 4:
                value = this.getDegreeDay();
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
