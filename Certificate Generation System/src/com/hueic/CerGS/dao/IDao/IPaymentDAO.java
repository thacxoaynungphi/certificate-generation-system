/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao.IDao;

import com.hueic.CerGS.entity.Payment;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public interface IPaymentDAO {

    boolean create(Payment pay);

    boolean delete(int id);

    ArrayList<Payment> readByAll();

    Payment readByID(int id);

    ArrayList<Payment> readByStudentId(String studentID);

    float getTotalDiposit(String studentId);

    boolean update(Payment pay);

}
