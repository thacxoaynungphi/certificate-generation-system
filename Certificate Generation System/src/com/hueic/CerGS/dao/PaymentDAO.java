/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Payment;
import com.hueic.CerGS.util.Configure;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wind
 */
public class PaymentDAO extends BaseDAO {

    public PaymentDAO() {
        db = new Configure();
    }

    public ArrayList<Payment> readByAll() {
        ArrayList<Payment> result = new ArrayList<Payment>();
        con = db.getConnection();
        String sqlcommand = "select * from Payment";

        try {
            pst = con.prepareCall(sqlcommand);
            rs = pst.executeQuery();

            while (rs.next()) {
                Payment pay = new Payment();
                pay.setId(rs.getInt("Id"));
                pay.setStudentId(rs.getString("StudentId"));
                pay.setSubjectId(rs.getString("SubjectId"));
                pay.setMoney(rs.getFloat("Money"));
                pay.setPayday(rs.getString("Payday"));

                result.add(pay);
            }

            setLastError("read data successful");
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
            return result;
        }
    }

    public ArrayList<Payment> readByID(int id) {
        ArrayList<Payment> result = new ArrayList<Payment>();
        con = db.getConnection();
        String sqlcommand = "select * from Payment where id like ?";

        try {
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                Payment pay = new Payment();
                pay.setId(rs.getInt("Id"));
                pay.setStudentId(rs.getString("StudentId"));
                pay.setSubjectId(rs.getString("SubjectId"));
                pay.setMoney(rs.getFloat("Money"));
                pay.setPayday(rs.getString("Payday"));

                result.add(pay);
            }

            setLastError("read data successful");
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
            return result;
        }
    }

    public boolean create(Payment pay) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "insert into Payment values(?, ?, ?, ?, ?)";

        try {
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, pay.getId());
            pst.setString(2, pay.getStudentId());
            pst.setString(3, pay.getSubjectId());
            pst.setFloat(4, pay.getMoney());
            pst.setString(5, pay.getPayday());

            if (pst.execute()) {
                setLastError("Add fee successful");
                status = true;
            } else {
                setLastError("Add fee unsuccessful");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
            return status;
        }
    }

    public boolean update(Payment pay) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "select * from Payment where id like ?";

        try {
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, pay.getId());

            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateInt("Id", pay.getId());
                rs.updateString("StudentId", pay.getStudentId());
                rs.updateString("SubjectId", pay.getSubjectId());
                rs.updateFloat("Money", pay.getMoney());
                rs.updateString("Payday", pay.getPayday());
                rs.updateRow();

                setLastError("Add fee successful");
                status = true;
            } else {
                setLastError("Add fee unsuccessful");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
            return status;
        }
    }

    public boolean delete(Payment pay) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "delete from Payment where id like ?";

        try {
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, pay.getId());

            if (pst.execute()) {
                setLastError("Add fee successful");
                status = true;
            } else {
                setLastError("Add fee unsuccessful");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
            return status;
        }
    }
}
