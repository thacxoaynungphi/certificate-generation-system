/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import com.hueic.CerGS.component.PropertyIndex;
import java.sql.Date;

/**
 *
 * @author Wind
 */
public class Register implements PropertyIndex {

    private String studentId;
    private String courseId;
    private int feesStructe;
    private Date regisDate;
    private String studentCourseId;

    public Register() {
    }

    public Register(String studentCourseId, String studentId, String courseId, int feesStructe, Date regisDate) throws Exception {
        setStudentId(studentId);
        setCourseId(courseId);
        setFeesStructe(feesStructe);
        setRegisDate(regisDate);
        setStudentCourseId(studentCourseId);
    }

    public Register(String studentCourseId, String studentId, String courseId, int feesStructe) throws Exception {
        setStudentId(studentId);
        setCourseId(courseId);
        setFeesStructe(feesStructe);
        this.regisDate = null;
        setStudentCourseId(studentCourseId);
    }

    /**
     * @return the id
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the id to set
     */
    public void setStudentId(String studentId) throws Exception {
        if (studentId.length() <= 0 || studentId.length() > 20) {
            throw new Exception("Id not validation");
        } else {
            this.studentId = studentId;
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
            throw new Exception("Fees structe must be 1 or 0");
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
    public String getStudentCourseId() {
        return studentCourseId;
    }

    /**
     * @param studentCourseId the studentId to set
     */
    public void setStudentCourseId(String studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getStudentId());
                break;
            case 2:
                value = String.valueOf(this.getCourseId());
                break;
            case 3:
                if(this.getFeesStructe() == 1){
                    value = "Installment Payment";
                } else {
                    value = "Full Payment";
                }
                break;
            case 4:
                value = String.valueOf(this.getRegisDate());
                break;
            case 5:
                value = String.valueOf(this.getStudentCourseId());
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
