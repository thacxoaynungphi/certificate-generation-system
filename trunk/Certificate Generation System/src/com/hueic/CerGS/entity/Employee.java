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
public class Employee extends Person {
    
    private String beginWork;
    //contruction
    public Employee()
    {
        super();
        beginWork = null;
    }

    public Employee(String id,String firstName,String lastName,String birthDay,String gender,String phone,String email,String address,String image,String beginWork)
    {
        super(id, firstName, lastName, birthDay, gender, phone, email, address, image);
        setBeginWork(beginWork);
    }
    //method get-set    
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