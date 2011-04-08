/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.dao.IDao.IRegisterDAO;
import com.hueic.CerGS.entity.Register;
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
                regis.setStudentId(rs.getString(1));
                regis.setCourseId(rs.getString(2));
                regis.setFeesStructe(rs.getInt(3));
                regis.setRegisDate(rs.getDate(4));
                regis.setStudentCourseId(rs.getString(5));
                list.add(regis);
            }
        } catch (Exception ex) {
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
            String sql = "select * from Register where StudentId = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, studentId);

            rs = pst.executeQuery();
            while (rs.next()) {
                regis = new Register();

                regis.setStudentId(studentId);
                regis.setCourseId(rs.getString(2));
                regis.setFeesStructe(rs.getInt(3));
                regis.setRegisDate(rs.getDate(4));
                regis.setStudentCourseId(rs.getString(5));

                listRegister.add(regis);
            }
        } catch (Exception ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return listRegister;
    }

    public Register readById(String studentId, String courseId) {
        Register regis = null;
        try {
            con = db.getConnection();
            String sql = "select * from Register where StudentId = ? and CourseId = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, studentId);
            pst.setString(2, courseId);

            rs = pst.executeQuery();
            if (rs.next()) {
                regis = new Register();
                regis.setStudentId(studentId);
                regis.setCourseId(courseId);
                regis.setFeesStructe(rs.getInt(3));
                regis.setRegisDate(rs.getDate(4));
                regis.setStudentCourseId(rs.getString(5));
            }
        } catch (Exception ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        if (regis != null) {
            System.out.println(regis.getStudentCourseId());
        }
        return regis;
    }

    public Register readByStudentCourseId(String studentCourseID) {
        Register regis = null;
        try {
            con = db.getConnection();
            String sql = "select * from Register where StudentCourseId = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, studentCourseID);

            rs = pst.executeQuery();
            if (rs.next()) {
                regis = new Register();
                regis.setStudentId(rs.getString(1));
                regis.setCourseId(rs.getString(2));
                regis.setFeesStructe(rs.getInt(3));
                regis.setRegisDate(rs.getDate(4));
                regis.setStudentCourseId(studentCourseID);
            }
        } catch (Exception ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
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
                regis.setStudentId(rs.getString(1));
                regis.setCourseId(rs.getString(2));
                regis.setFeesStructe(rs.getInt(3));
                regis.setRegisDate(rs.getDate(4));
                regis.setStudentCourseId(rs.getString(5));
                resList.add(regis);
            }
        } catch (Exception ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return resList;
    }

    public boolean create(Register regis) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "insert into Register (StudentId,CourseId, FeesStructe, RegistrationDate, StudentCourseId)" + " values (?,?,?,?,?); ";
            pst = con.prepareStatement(sql);

            pst.setString(1, regis.getStudentId());
            pst.setString(2, regis.getCourseId());
            pst.setInt(3, regis.getFeesStructe());
            pst.setDate(4, regis.getRegisDate());
            pst.setString(5, regis.getStudentCourseId());

            if (pst.executeUpdate() > 0) {
                setLastError("Add Register Successfully");
                status = true;
            } else {
                setLastError("Add Register unuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean update(Register res) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "select * from Register where StudentCourseId = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, res.getStudentCourseId());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString(2, res.getCourseId());
                rs.updateInt(3, res.getFeesStructe());
                rs.updateDate(4, res.getRegisDate());
                try {
                    rs.updateRow();
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
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

    public boolean delete(String studentId, String courseId) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "delete from Register where StudentId = ? and CourseId = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, studentId);
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

    public boolean delete(String studentCourseId) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "delete from Register where StudentCourseId = ? ";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, studentCourseId);

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
