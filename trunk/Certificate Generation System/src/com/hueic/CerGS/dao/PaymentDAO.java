/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.dao.IDao.IPaymentDAO;
import com.hueic.CerGS.entity.Payment;
import com.hueic.CerGS.util.Configure;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wind
 */
public class PaymentDAO extends BaseDAO implements IPaymentDAO {

    public PaymentDAO() {
        db = new Configure();
    }

    public ArrayList<Payment> readByAll() {
        ArrayList<Payment> result = new ArrayList<Payment>();
        con = db.getConnection();
        String sqlcommand = "select * from Payment";

        try {
            pst = con.prepareStatement(sqlcommand);
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

    public Payment readByID(int id) {
        con = db.getConnection();
        String sqlcommand = "select * from Payment where id = ?";
        Payment pay = null;
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                pay = new Payment();
                pay.setId(rs.getInt("Id"));
                pay.setStudentId(rs.getString("StudentId"));
                pay.setMoney(rs.getFloat("Money"));
                pay.setPayday(rs.getDate("Payday"));

            }

            setLastError("read data successful");

        } catch (SQLException ex) {
            setLastError("SQL Error");
        } catch (Exception ex) {
            setLastError(ex.toString());
        } finally {
            db.closeConnection();

        }
        return pay;
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
        } catch (Exception ex) {
            setLastError("Data not valid");
        }
        return payList;
    }

    public float getTotalDiposit(String studentId) {
        float money = 0.0f;
        con = db.getConnection();
        String sqlcommand = "select sum(Money) from Payment where StudentId = ?";
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, studentId);
            rs = pst.executeQuery();
            if (rs.next()) {
                money = rs.getFloat(1);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
        }
        return money;
    }

    public boolean create(Payment pay) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "insert into Payment(StudentId,Money,Payday) values(?, ?, ?)";

        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, pay.getStudentId());
            pst.setFloat(2, pay.getMoney());
            pst.setDate(3, (Date) pay.getPayday());
            if (pst.executeUpdate() > 0) {
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
        String sqlcommand = "select * from Payment where id = ?";

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

                setLastError("Update fee successful");
                status = true;
            } else {
                setLastError("Update fee unsuccessful");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
            return status;
        }
    }

    public boolean delete(int id) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "delete from Payment where id = ?";
        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id);
            if (pst.executeUpdate() > 0) {
                setLastError("Delete fee successful");
                status = true;
            } else {
                setLastError("Delete fee unsuccessful");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
}
