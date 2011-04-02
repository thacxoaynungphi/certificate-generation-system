/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.inteface;

import com.hueic.CerGS.entity.Register;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public interface IRegisterDAO {

    boolean create(Register regis);

    boolean delete(String id, String courseId);

    boolean delete(String studentId);

    ArrayList<Register> readByAll();

    ArrayList<Register> readByCourseId(String courseId);

    Register readById(String id, String courseId);

    Register readByStudentId(String studentID);

    ArrayList<Register> readByStudentIdOfPerson(String studentId);

    boolean update(Register res);

}
