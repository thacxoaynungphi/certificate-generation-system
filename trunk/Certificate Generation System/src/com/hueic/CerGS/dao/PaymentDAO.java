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

/**
 *
 * @author Wind
 */
public class PaymentDAO extends BaseDAO implements IPaymentDAO {

    public PaymentDAO() {
        db = new Configure();
    }

    public ArrayList<Payment> readByAll() {
        setLastError("");
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
        setLastError("");
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
        setLastError("");
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

    public ArrayList<Payment> readByCourseId(String courseId) {
        setLastError("");
        ArrayList<Payment> payList = new ArrayList<Payment>();
        Payment pay = null;
        try {
            con = db.getConnection();
            String sql = "select * from Payment where StudentId in (select StudentId from Register where CourseId = ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, courseId);

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

    public ArrayList<Payment> readByStudentIdOfPerson(String studentIDOfPerson, String courseId) {
        setLastError("");
        ArrayList<Payment> payList = new ArrayList<Payment>();
        Payment pay = null;
        try {
            con = db.getConnection();
            if (courseId.length() == 0) {
                String sql = "select * from Payment where StudentId in (select StudentId from Register where PersonId = ?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, studentIDOfPerson);
            } else {
                String sql = "select * from Payment where StudentId in (select StudentId from Register where PersonId = ? and CourseId = ?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, studentIDOfPerson);
                pst.setString(2, courseId);
            }
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

    public float getCurrentTotalDiposit(Payment pay) {
        setLastError("");
        float money = 0.0f;
        con = db.getConnection();
        String sqlcommand = "select sum(Money) from Payment where StudentId = ? and Payday <= ?";
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, pay.getStudentId());
            pst.setDate(2, pay.getPayday());
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

    public float getTotalDiposit(String studentCourseId) {
        setLastError("");
        float money = 0.0f;
        con = db.getConnection();
        String sqlcommand = "select sum([Money]) from Payment where StudentId = ?";
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, studentCourseId);
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
        setLastError("");
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
        setLastError("");
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "select * from Payment where id = ?";

        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, pay.getId());

            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateFloat("Money", pay.getMoney());
                rs.updateDate("Payday", (Date) pay.getPayday());
                rs.updateRow();

                setLastError("Update fee successful");
                status = true;
            } else {
                setLastError("Update fee unsuccessful");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
            return status;
        }
    }

    public boolean delete(int id) {
        setLastError("");
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
