/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.IDao;

import com.hueic.CerGS.entity.Employee;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nhchung
 */
public interface IEmployeeDAO {

    String convertDate(Date date);

    boolean create(Employee emp);

    boolean delete(String id);

    ArrayList<Employee> readByAll();

    ArrayList<Employee> readByCommand(String fname, String lname, Date startDate, Date endDate, int gender);

    Employee readByID(String id);

    boolean update(Employee emp);

}
