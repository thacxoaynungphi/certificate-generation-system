/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import java.util.Date;

/**
 *
 * @author nhchung
 * Date: 13/03/2011
 * Version: 1.0
 */
public class Certificate {

    //field
    private int id;
    private String studentID;
    private float mark;
    private Date degreeDay;

    //contruction
    public Certificate() {
        id = 0;
        studentID = null;
        mark = 0;
        degreeDay = null;
    }

    public Certificate(int id, String studentID, float mark, Date degreeDay) throws Exception {
        setId(id);
        setStudentID(studentID);
        setMark(mark);
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
    public void setStudentID(String studentID) throws Exception {
        if (studentID.length() <= 0 || studentID.length() > 20) {
            throw new Exception("Student id invalidation");
        } else {
            this.studentID = studentID;
        }
    }

    /**
     * @return the sourse
     */
    public float getMark() {
        return mark;
    }

    /**
     * @param sourse the sourse to set
     */
    public void setMark(float mark) throws Exception {
        if (mark < 0 || mark > 100) {
            throw new Exception("Mark invalidation");
        } else {
            this.mark = mark;
        }
    }

    /**
     * @return the degreeDay
     */
    public Date getDegreeDay() {
        return degreeDay;
    }

    /**
     * @param degreeDay the degreeDay to set
     */
    public void setDegreeDay(Date degreeDay) throws Exception {
        if (degreeDay != null) {
            throw new Exception("Degree day invalidation");
        } else {
            this.degreeDay = degreeDay;
        }
    }
}
