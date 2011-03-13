/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.entity;

/**
 *
 * @author Huu Bien
 * Version 1.0
 * lop Class mo ta cac thuc the lop hoc.
 */
public class Class {

    private String id;
    private String name;
    private float totalFees;
    private String courseId;
    private String startDate;
    private int feesStructe;
    private int status;

    public Class(){}

    public Class(String id, String name, float totalFees, String courseId, String startDate, int feesStructe){
        setId(id);
        setCourseId(courseId);
        setName(name);
        setFeesStructe(feesStructe);
        setStartDate(startDate);
        setTotalFees(totalFees);
        setStatus(1);
    }

    public Class(String id, String name, float totalFees, String courseId, String startDate){
        setId(id);
        setName(name);
        setTotalFees(totalFees);
        setCourseId(courseId);
        setStartDate(startDate);
        setFeesStructe(0);
        setStatus(1);
    }

    public Class(String id, String name, float totalFees, String courseId, int feesStructe){
        setId(id);
        setCourseId(courseId);
        setName(name);
        setFeesStructe(feesStructe);
        setStartDate(null);
        setTotalFees(totalFees);
        setStatus(1);
    }

    public Class(String id, String name, float totalFees, String courseId){
        setId(id);
        setCourseId(courseId);
        setName(name);
        setTotalFees(totalFees);
        setStartDate(null);
        setFeesStructe(0);
        setStatus(1);
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
     * @return the totalFees
     */
    public float getTotalFees() {
        return totalFees;
    }

    /**
     * @param totalFees the totalFees to set
     */
    public void setTotalFees(float totalFees) {
        this.totalFees = totalFees;
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
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the feesStructe
     *
     */
    public int getFeesStructe() {
        return feesStructe;
    }

    /**
     * @param feesStructe the feesStructe to set
     * mac dinh la 0 tuong ung voi kieu thanh toan tra 1 lan
     */
    public void setFeesStructe(int feesStructe) {
        this.feesStructe = feesStructe;
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
