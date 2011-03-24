/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Payment;
import com.hueic.CerGS.util.Configure;
import java.sql.Date;
import java.sql.ResultSet;
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
            pst = con.prepareStatement(sqlcommand,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
            while (rs.next()) {
                Payment pay = new Payment();
                pay.setId(rs.getInt("Id"));
                pay.setStudentId(rs.getString("StudentId"));
                pay.setMoney(rs.getFloat("Money"));
                pay.setPayday(rs.getDate("Payday"));
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
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                Payment pay = new Payment();
                pay.setId(rs.getInt("Id"));
                pay.setStudentId(rs.getString("StudentId"));
                pay.setMoney(rs.getFloat("Money"));
                pay.setPayday(rs.getDate("Payday"));

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

    public ArrayList<Payment> readByStudentId(String studentID) {
        ArrayList<Payment> payList = new ArrayList<Payment>();
        Payment pay = null;
        try {
            con = db.getConnection();
            String sql = "select * from Payment where StudentId = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, studentID);

            rs = pst.executeQuery();
            while (rs.next()) {
                pay = new Payment();

                pay.setId(rs.getInt("Id"));
                pay.setStudentId(rs.getString("StudentId"));
                pay.setMoney(rs.getFloat("Money"));
                pay.setPayday(rs.getDate("Payday"));

                payList.add(pay);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        }
        return payList;
    }

    public boolean create(Payment pay) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "insert into Payment values(?, ?, ?, ?, ?)";

        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, pay.getId());
            pst.setString(2, pay.getStudentId());
            pst.setFloat(3, pay.getMoney());
            pst.setDate(4, (Date) pay.getPayday());

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
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, pay.getId());

            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateInt("Id", pay.getId());
                rs.updateString("StudentId", pay.getStudentId());
                rs.updateFloat("Money", pay.getMoney());
                rs.updateDate("Payday", (Date) pay.getPayday());
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
            pst = con.prepareStatement(sqlcommand,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
