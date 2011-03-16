/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import com.hueic.CerGS.component.PropertyIndex;

/**
 *
 * @author nhchung
 * Date : 13/03/2011
 * Version : 1.0
 */
public class Student extends Person implements PropertyIndex {

    //field
    //contruction
    public Student() {
        super();
    }

    public Student(String id, String firstName, String lastName, String birthDay, int gender, String phone, String email, String address, String image, String classID, String currentClass, String registrationDate) throws Exception {
        super(id, firstName, lastName, birthDay, gender, phone, email, address, image);
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
                value = String.valueOf(this.getGender());
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
        }
        return value;
    }

    public void setPropertyValue(int index, Object value) {
    }

    public Class getPropertyClass(int index) {
        return String.class;
    }
}
