/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.IDao;

import com.hueic.CerGS.entity.Permission;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public interface IPermissionDAO {

    boolean create(Permission per);

    boolean delete(int id);

    ArrayList<Permission> readByAll();

    Permission readByID(int id);

    Permission readByName(String name);

    boolean update(Permission per);

}
