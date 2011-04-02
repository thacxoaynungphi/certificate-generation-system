/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.IDao;

import com.hueic.CerGS.entity.Subject;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public interface ISubjectDAO {

    boolean create(Subject sub);

    boolean delete(String id);

    ArrayList<Subject> readByAll();

    ArrayList<Subject> readByCourseId(String id);

    Subject readByID(String id);

    boolean update(Subject sub);

}
