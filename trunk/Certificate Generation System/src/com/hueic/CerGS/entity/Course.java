
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
        id = null;
        status = 1;
        totalFees = 0;
        name = null;
    }

    public Course(String id, String name) throws Exception {
        setId(id);
        setName(name);
        setStatus(1);
    }

    public Course(String id, String name, float totalFees, int status) throws Exception {
        setId(id);
        setName(name);
        setTotalFees(totalFees);
        setStatus(status);
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
            throw new Exception("Id invalidation");
        } else {
            this.id = id;
        }
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
            throw new Exception("Course name invalidation");
        } else {
            this.name = name;
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

    /**
     * @return the totalFees
     */
    public float getTotalFees() {
        return totalFees;
    }

    /**
     * @param totalFees the totalFees to set
     */
    public void setTotalFees(float totalFees) throws Exception {
        if (totalFees < 0) {
            throw new Exception("Total fees invalidation");
        } else {
            this.totalFees = totalFees;
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
