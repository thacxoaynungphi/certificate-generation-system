/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.IDao;

import com.hueic.CerGS.entity.Course;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public interface ICourseDAO {

    boolean create(Course course);

    boolean delete(String id);

    ArrayList<Course> readByAll();

    Course readById(String id);

    Course readByName(String name);

    boolean update(Course course);

}
