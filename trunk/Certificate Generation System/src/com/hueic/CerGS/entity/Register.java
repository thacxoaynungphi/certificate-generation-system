/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import java.util.Date;

/**
 *
 * @author Wind
 */
public class Register {

    private String id;
    private String courseId;
    private int feeStructe;
    private Date regisDate;
    private String studentId;

    public Register() {
    }

    public Register(String id, String courseId, int feeStructe, Date regisDate, String studentId) {
        this.id = id;
        this.courseId = courseId;
        this.feeStructe = feeStructe;
        this.regisDate = regisDate;
        this.studentId = studentId;
    }

    public Register(String id, String courseId, int feeStructe, String studentId) {
        this.id = id;
        this.courseId = courseId;
        this.feeStructe = feeStructe;
        this.regisDate = null;
        this.studentId = studentId;
    }

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
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the feeStructe
     */
    public int getFeeStructe() {
        return feeStructe;
    }

    /**
     * @param feeStructe the feeStructe to set
     */
    public void setFeeStructe(int feeStructe) {
        this.feeStructe = feeStructe;
    }

    /**
     * @return the regisDate
     */
    public Date getRegisDate() {
        return regisDate;
    }

    /**
     * @param regisDate the regisDate to set
     */
    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
