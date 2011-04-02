/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.inteface;

import com.hueic.CerGS.entity.Account;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public interface IAccountDAO {

    boolean changePass(Account acc, String oldPass);

    boolean create(Account acc);

    boolean delete(String username);

    boolean login(Account acc);

    ArrayList<Account> readByAll();

    boolean update(Account acc);

}
