/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.IDao;

import com.hueic.CerGS.entity.Person;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public interface IPersonDAO {

    boolean create(Person person);

    boolean delete(String Id);

    ArrayList<Person> readByAll();

    ArrayList<Person> readByAllNotAcc();

    Person readByID(String id);

    boolean update(Person person);

}
