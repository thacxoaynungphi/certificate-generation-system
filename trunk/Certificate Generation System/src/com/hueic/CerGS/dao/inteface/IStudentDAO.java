/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.inteface;

import com.hueic.CerGS.entity.Student;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nhchung
 */
public interface IStudentDAO {

    String convertDate(Date date);

    boolean create(Student student);

    boolean delete(String id);

    ArrayList<Student> readByAll();

    ArrayList<Student> readByCommand(String fname, String lname, Date startDate, Date endDate, int gender);

    Student readByID(String id);

    boolean update(Student student);

}
