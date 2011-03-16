/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import com.hueic.CerGS.component.PropertyIndex;

/**
 *
 * @author HuuBien
 * Version 1.0
 * lop Course mo ta cac khoa hoc.
 * ngay 13/3/11
 */
public class Course implements PropertyIndex {

    private String id;
    private String name;
    private float totalFees;
    private int status;

    public Course() {
        setId(null);
        setStatus(1);
        setName(null);
    }

    public Course(String id, String name) {
        setId(id);
        setName(name);
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

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getId());
                break;
            case 2:
                value = this.getName();
                break;
            case 3:
                value = String.valueOf(this.getTotalFees());
                break;
            case 4:
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
