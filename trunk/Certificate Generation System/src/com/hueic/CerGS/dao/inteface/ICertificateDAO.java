/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.inteface;

import com.hueic.CerGS.entity.Certificate;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public interface ICertificateDAO {

    boolean create(Certificate cer);

    boolean delete(int id);

    ArrayList<Certificate> readByAll();

    Certificate readById(int id);

    ArrayList<Certificate> readByStudentId(String studentID);

    boolean update(Certificate cer);

}
