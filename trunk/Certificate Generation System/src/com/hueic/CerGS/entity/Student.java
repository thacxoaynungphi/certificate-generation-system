/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.entity;

import java.util.Date;

/**
 *
 * @author nhchung
 * Date : 13/03/2011
 * Version : 1.0
 */
public class Student extends Person{

    //field
    //contruction
    public Student() {
        super();
    }

    public Student(String id, String firstName, String lastName, Date birthDay, int gender, String phone, String email, String address, String image, String classID, String currentClass, String registrationDate) throws Exception {
        super(id, firstName, lastName, birthDay, gender, phone, email, address, image);
    }
}
