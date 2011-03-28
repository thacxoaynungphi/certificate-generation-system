/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.dao.inteface.IRegisterDAO;
import com.hueic.CerGS.entity.Register;
import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wind
 */
public class RegisterDAO extends BaseDAO implements IRegisterDAO {

    public ArrayList<Register> readByAll() {
        ArrayList<Register> list = new ArrayList<Register>();
        con = db.getConnection();
        String sql = "select * from Register";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Register regis = new Register();
                regis.setId(rs.getString("Id"));
                regis.setCourseId(rs.getString("CourseId"));
                regis.setFeeStructe(rs.getInt("FeesStructe"));
                regis.setRegisDate(rs.getDate("RegistrationDate"));
                regis.setStudentId(rs.getString("StudentId"));
                list.add(regis);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public ArrayList<Register> readByStudentIdOfPerson(String studentId) {
        ArrayList<Register> listRegister = new ArrayList<Register>();
        Register regis = null;
        try {
            con = db.getConnection();
            String sql = "select * from Register where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, studentId);

            rs = pst.executeQuery();
            while (rs.next()) {
                regis = new Register();

                regis.setId(rs.getString("Id"));
                regis.setCourseId(rs.getString("CourseId"));
                regis.setFeeStructe(rs.getInt("FeesStructe"));
                regis.setRegisDate(rs.getDate("RegistrationDate"));
                regis.setStudentId(rs.getString("StudentId"));

                listRegister.add(regis);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        }
        return listRegister;
    }

    public ArrayList<Register> readById(String id, String courseId) {
        ArrayList<Register> listRegis = new ArrayList<Register>();
        Register regis = null;
        try {
            con = db.getConnection();
            String sql = "select * from Register where Id = ? and CourseId = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, courseId);

            rs = pst.executeQuery();
            while (rs.next()) {
                regis = new Register();

                regis.setId(rs.getString("Id"));
                regis.setCourseId(rs.getString("CourseId"));
                regis.setFeeStructe(rs.getInt("FeesStructe"));
                regis.setRegisDate(rs.getDate("RegistrationDate"));
                regis.setStudentId(rs.getString("StudentId"));

                listRegis.add(regis);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        }
        return listRegis;
    }

    public Register readByStudentId(String studentID) {
        Register regis = null;
        try {
            con = db.getConnection();
            String sql = "select * from Register where StudentId = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, studentID);

            rs = pst.executeQuery();
            if (rs.next()) {
                regis = new Register();
                regis.setId(rs.getString("Id"));
                regis.setCourseId(rs.getString("CourseId"));
                regis.setFeeStructe(rs.getInt("FeesStructe"));
                regis.setRegisDate(rs.getDate("RegistrationDate"));
                regis.setStudentId(rs.getString("StudentId"));
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        }
        return regis;
    }

    public ArrayList<Register> readByCourseId(String courseId) {
        ArrayList<Register> resList = new ArrayList<Register>();
        Register regis = null;
        try {
            con = db.getConnection();
            String sql = "select * from Register where CourseId = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, courseId);

            rs = pst.executeQuery();
            while (rs.next()) {
                regis = new Register();
                regis.setId(rs.getString("Id"));
                regis.setCourseId(rs.getString("CourseId"));
                regis.setFeeStructe(rs.getInt("FeesStructe"));
                java.util.Date date = (java.util.Date) rs.getDate("RegistrationDate");
                regis.setRegisDate(date);
                regis.setStudentId(rs.getString("StudentId"));
                resList.add(regis);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        }
        return resList;
    }

    public boolean create(Register regis) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "insert into Register (Id,CourseId, FeesStructe, RegistrationDate, StudentId)" + " values (?,?,?,?,?); ";
            pst = con.prepareStatement(sql);

            pst.setString(1, regis.getId());
            pst.setString(2, regis.getCourseId());
            pst.setInt(3, regis.getFeeStructe());
            pst.setDate(4, (Date) regis.getRegisDate());
            pst.setString(5, regis.getStudentId());

            if (pst.executeUpdate() > 0) {
                setLastError("Add Register Successfully");
                status = true;
            } else {
                setLastError("Add Register unuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean update(Register res) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "select * from Register where Id = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, res.getId());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateInt("FeesStructe", res.getFeeStructe());
                rs.updateDate("RegistrationDate", (Date) res.getRegisDate());
                rs.updateString("StudentId", res.getStudentId());

                rs.updateRow();
                db.closeConnection();
                setLastError("Update Register successfully");
                status = true;
            } else {
                setLastError("Update Register unsuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean delete(String id, String courseId) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "delete from Register where Id = ? and CourseId = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, id);
            pst.setString(2, courseId);

            if (pst.executeUpdate() > 0) {
                setLastError("Delete Register successfully!");
                status = true;
            } else {
                setLastError("Delete Register unsuccessfully!");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean delete(String studentId) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "delete from Register where StudentId = ? ";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, studentId);

            if (pst.executeUpdate() > 0) {
                setLastError("Delete Register successfully!");
                status = true;
            } else {
                setLastError("Delete Register unsuccessfully!");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
}
