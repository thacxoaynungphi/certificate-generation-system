/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.dao.IDao.ICertificateDAO;
import com.hueic.CerGS.entity.Certificate;
import com.hueic.CerGS.util.Configure;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public class CertificateDAO extends BaseDAO implements ICertificateDAO {

    public CertificateDAO() {
        db = new Configure();
    }

    public ArrayList<Certificate> readByAll() {
        ArrayList<Certificate> list = new ArrayList<Certificate>();
        con = db.getConnection();
        String sql = "select * from Certificate";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Certificate cer = new Certificate();
                cer.setId(rs.getInt(1));
                cer.setStudentID(rs.getString(2));
                cer.setMark(rs.getFloat(3));
                cer.setDegreeDay(rs.getDate(4));
                list.add(cer);
            }
            setLastError("Read All successfully");
        } catch (Exception ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public Certificate readById(int id) {
        Certificate cer = null;
        try {
            con = db.getConnection();
            String sql = "select * from Certificate where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                cer = new Certificate();
                cer.setId(rs.getInt(1));
                cer.setStudentID(rs.getString(2));
                cer.setMark(rs.getFloat(3));
                cer.setDegreeDay(rs.getDate(4));
            }
            setLastError("Read  successfully");
        } catch (Exception ex) {
            setLastError("SQL Error!");
        }
        return cer;
    }

    public Certificate readByStudentId(String studentID) {
        Certificate cer = null;
        con = db.getConnection();
        String sql = "select * from Certificate where StudentId = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, studentID);
            rs = pst.executeQuery();
            if (rs.next()) {
                cer = new Certificate();
                cer.setId(rs.getInt(1));
                cer.setStudentID(rs.getString(2));
                cer.setMark(rs.getFloat(3));
                cer.setDegreeDay(rs.getDate(4));
            }
        } catch (Exception ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return cer;
    }

    public boolean create(Certificate cer) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "insert into Certificate (Id,StudentId,Mark,DegreeDay) values (?,?,?,?); ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, cer.getId());
            pst.setString(2, cer.getStudentID());
            pst.setFloat(3, cer.getMark());
            pst.setDate(4, cer.getDegreeDay());
            if (pst.executeUpdate() > 0) {
                setLastError("Add Certificate Successfully");
                status = true;
            } else {
                setLastError("Add Certificate unuccessfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean update(Certificate cer) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "select * from Certificate where Id = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, cer.getId());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString(2, cer.getStudentID());
                rs.updateFloat(3, cer.getMark());
                rs.updateDate(4, new Date(cer.getDegreeDay().getTime()));
                rs.updateRow();
                setLastError("Update Certificate successfully");
                status = true;
            } else {
                setLastError("Update Certificate unsuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean delete(int id) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "delete from Certificate where Id = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id);
            if (pst.executeUpdate() > 0) {
                setLastError("Delete Certificate successfully!");
                status = true;
            } else {
                setLastError("Delete Certificate unsuccessfully!");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
}
