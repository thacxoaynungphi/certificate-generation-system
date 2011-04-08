/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.IDao;

import com.hueic.CerGS.entity.Mark;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public interface IMarkDAO {

    float avgMark(String studentId);

    boolean create(Mark Marks);

    boolean delete(int id);

    String getGrades(float mark);

    boolean isCompleteCourse(String courseId, String studentId);

    ArrayList<Mark> readBYCourseID(String courseId);

    ArrayList<Mark> readByAll();

    Mark readByID(int id);

    ArrayList<Mark> readByStudentID(String studentId);

    boolean update(Mark Marks);

}
