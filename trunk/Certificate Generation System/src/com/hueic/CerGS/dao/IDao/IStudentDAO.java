/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.IDao;

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

    Student readByID(String id);

    boolean update(Student student);

}
