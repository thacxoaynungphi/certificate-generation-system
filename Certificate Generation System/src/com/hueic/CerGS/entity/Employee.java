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
public class Employee {

    //field
    private String id;
    private String beginWork;

    //contruction

    public Employee()
    {
        id = null;
        beginWork = null;
    }

    public Employee(String id,String beginWork)
    {
        setId(id);
        setBeginWork(beginWork);
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
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the beginWork
     */
    public String getBeginWork() {
        return beginWork;
    }

    /**
     * @param beginWork the beginWork to set
     */
    public void setBeginWork(String beginWork) {
        this.beginWork = beginWork;
    }    
}
