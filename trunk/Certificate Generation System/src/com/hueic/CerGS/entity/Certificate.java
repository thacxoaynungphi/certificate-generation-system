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
public class Certificate {

    //field
    private int id;
    private String studentID;
    private float sourse;
    private String grader;
    private String degreeDay;

    
    //contruction
    public Certificate()
    {
        id = 0;
        studentID = null;
        sourse = 0;
        grader = null;
        degreeDay = null;
    }

    public Certificate(int id,String studentID,float sourse,String grader,String degreeDay)
    {
        setId(id);
        setStudentID(studentID);
        setSourse(sourse);
        setGrader(grader);
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
    public float getSourse() {
        return sourse;
    }

    /**
     * @param sourse the sourse to set
     */
    public void setSourse(float sourse) {
        this.sourse = sourse;
    }

    /**
     * @return the grader
     */
    public String getGrader() {
        return grader;
    }

    /**
     * @param grader the grader to set
     */
    public void setGrader(String grader) {
        this.grader = grader;
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
}
