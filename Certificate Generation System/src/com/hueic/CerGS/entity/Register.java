/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import java.sql.Date;

/**
 *
 * @author Wind
 */
public class Register {

    private String id;
    private String courseId;
    private int feesStructe;
    private Date regisDate;
    private String studentId;

    public Register() {
    }

    public Register(String id, String courseId, int feesStructe, Date regisDate, String studentId) throws Exception {
        setId(id);
        setCourseId(courseId);
        setFeesStructe(feesStructe);
        setRegisDate(regisDate);
        setStudentId(studentId);
    }

    public Register(String id, String courseId, int feesStructe, String studentId) throws Exception {
        setId(id);
        setCourseId(courseId);
        setFeesStructe(feesStructe);
        this.regisDate = null;
        setStudentId(studentId);
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
    public void setId(String id) throws Exception {
        if (id.length() <= 0 || id.length() > 20) {
            throw new Exception("Id not validation");
        } else {
            this.id = id;
        }
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
    public void setCourseId(String courseId) throws Exception {
        if (courseId.length() <= 0 || courseId.length() > 20) {
            throw new Exception("Course id invalidation");
        } else {
            this.courseId = courseId;
        }
    }

    /**
     * @return the feeStructe
     */
    public int getFeesStructe() {
        return feesStructe;
    }

    /**
     * @param feeStructe the feeStructe to set
     */
    public void setFeesStructe(int feesStructe) throws Exception {
        if (feesStructe != 0 && feesStructe != 1) {
            throw new Exception("Fees structe invalidation");
        } else {
            this.feesStructe = feesStructe;
        }
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
