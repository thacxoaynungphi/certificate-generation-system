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
public class Employee extends Person {

    private Date beginWork;
    //contruction

    public Employee() {
        super();
        beginWork = null;
    }

    public Employee(String id, String firstName, String lastName, Date birthDay, int gender, String phone, String email, String address, String image, Date beginWork) throws Exception {
        super(id, firstName, lastName, birthDay, gender, phone, email, address, image);
        setBeginWork(beginWork);
    }
    //method get-set    

    /**
     * @return the beginWork
     */
    public Date getBeginWork() {
        return beginWork;
    }

    /**
     * @param beginWork the beginWork to set
     */
    //khi nhap beginwork thi se dua vao Commbobox de nhap
    public void setBeginWork(Date beginWork) throws Exception {
        if (beginWork != null) {
            throw new Exception("Beginwork invalidation");
        } else {
            this.beginWork = beginWork;
        }
    }
}
