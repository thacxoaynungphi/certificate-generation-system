/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Certificate;
import com.hueic.CerGS.util.Configure;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public class CertificateDAO {

    private Configure db;
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String lastError = "";

    public CertificateDAO() {
        db = new Configure();
    }

    public ArrayList<Certificate> ReadByAll() {
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
                cer.setSourse(rs.getFloat(3));
                cer.setGrader(rs.getString(4));
                cer.setDegreeDay(rs.getString(5));
                list.add(cer);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public Certificate ReadById(int id) {
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
                cer.setSourse(rs.getFloat(3));
                cer.setGrader(rs.getString(4));
                cer.setDegreeDay(rs.getString(5));
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        }
        return cer;
    }

    public ArrayList<Certificate> ReadByStudentId(String studentID) {
        ArrayList<Certificate> list = new ArrayList<Certificate>();
        con = db.getConnection();
        String sql = "select * from Certificate where StudentId = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, studentID);
            rs = pst.executeQuery();
            while (rs.next()) {
                Certificate cer = new Certificate();
                cer.setId(rs.getInt(1));
                cer.setStudentID(rs.getString(2));
                cer.setSourse(rs.getFloat(3));
                cer.setGrader(rs.getString(4));
                cer.setDegreeDay(rs.getString(5));
                list.add(cer);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public boolean Create(Certificate cer) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "insert into Certificate (Id,StudentId,Course,Crade,DegreeDay)" + " values (?,?,?,?,?); ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, cer.getId());
            pst.setString(2, cer.getStudentID());
            pst.setFloat(3, cer.getSourse());
            pst.setString(4, cer.getGrader());
            pst.setString(5, cer.getDegreeDay());
            if (pst.executeUpdate() > 0) {
                setLastError("Add Certificate Successfully");
                status = true;
            } else {
                setLastError("Add Certificate unuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
    
    public boolean Update(Certificate cer)
    {
         boolean status = false;
        try {
            con = db.getConnection();
            String sql = "select * from Certificate where Id = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, cer.getId());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString(2, cer.getStudentID());
                rs.updateFloat(3, cer.getSourse());
                rs.updateString(4, cer.getGrader());
                rs.updateString(5, cer.getDegreeDay());
                rs.updateRow();
                db.closeConnection();
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

    public boolean  Delete(int id)
    {
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
    
    /**
     * @return the lastError
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * @param lastError the lastError to set
     */
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }
}
