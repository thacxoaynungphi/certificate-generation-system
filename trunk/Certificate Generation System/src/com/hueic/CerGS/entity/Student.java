/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import com.hueic.CerGS.component.PropertyIndex;
import java.sql.Date;

/**
 *
 * @author nhchung
 * Date : 13/03/2011
 * Version : 1.0
 */
public class Student extends Person implements PropertyIndex{

    //field
    //contruction
    public Student() {
        super();
    }

    public Student(String id, String firstName, String lastName, Date birthDay, int gender, String phone, String email, String address, String image, String classID, String currentClass, String registrationDate) throws Exception {
        super(id, firstName, lastName, birthDay, gender, phone, email, address, image);
    }

     public Object getPropertyValue(int index) {
        String value = "";
        switch (index) {
            case 1:
                value = String.valueOf(this.getId());
                break;
            case 2:
                value = String.valueOf(this.getFirstName());
                break;
            case 3:
                value = String.valueOf(this.getLastName());
                break;
            case 4:
                value = String.valueOf(this.getBirthDay());
                break;
            case 5:
               if (this.getGender() == 1) {
                    value = "FeMale";
                } else {
                    value = "Male";
                }
                break;
            case 6:
                value = String.valueOf(this.getPhone());
                break;
            case 7:
                value = String.valueOf(this.getEmail());
                break;
            case 8:
                value = String.valueOf(this.getAddress());
                break;
            case 9:
                value = String.valueOf(this.getImage());
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
