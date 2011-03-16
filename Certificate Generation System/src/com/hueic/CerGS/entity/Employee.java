/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import com.hueic.CerGS.component.PropertyIndex;

/**
 *
 * @author nhchung
 * Date: 13/03/2011
 * Version: 1.0
 */
public class Employee extends Person implements PropertyIndex {

    private String beginWork;
    //contruction

    public Employee() {
        super();
        beginWork = null;
    }

    public Employee(String id, String firstName, String lastName, String birthDay, int gender, String phone, String email, String address, String image, String beginWork) throws Exception {
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
    //khi nhap beginwork thi se dua vao Commbobox de nhap
    public void setBeginWork(String beginWork) {
        this.beginWork = beginWork;
    }

    public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getId());
                break;
            case 2:
                value = this.getFirstName();
                break;
            case 3:
                value = this.getLastName();
                break;
            case 4:
                value = this.getBirthDay();
                break;
            case 5:
                if (this.getGender() == 0) {
                    value = "Male";
                } else {
                    value = "FeMale";
                }

                break;
            case 6:
                value = this.getPhone();
                break;
            case 7:
                value = this.getEmail();
                break;
            case 8:
                value = this.getAddress();
                break;
            case 9:
                value = this.getImage();
                break;
            case 10:
                value = String.valueOf(this.getStatus());
                break;
            case 11:
                value = this.getBeginWork();
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
