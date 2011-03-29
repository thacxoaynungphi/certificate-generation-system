/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.dao.inteface.ISubjectDAO;
import com.hueic.CerGS.entity.Subject;
import com.hueic.CerGS.util.Configure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhchung
 */
public class SubjectDAO extends BaseDAO implements ISubjectDAO {

    public SubjectDAO() {
        db = new Configure();
    }

    public ArrayList<Subject> readByAll() {
        ArrayList<Subject> list = new ArrayList<Subject>();
        con = db.getConnection();
        String sql = "select * from Subject";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setId(rs.getString(1));
                sub.setName(rs.getString(2));
                sub.setCoefficient(rs.getInt(3));
                sub.setCourseID(rs.getString(4));
                sub.setStatus(rs.getInt(5));
                list.add(sub);
            }
        } catch (Exception ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public ArrayList<Subject> readByCourseId(String id) {
        ArrayList<Subject> list = new ArrayList<Subject>();
        con = db.getConnection();
        String sql = "select * from Subject where CourseId = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Subject sub = new Subject();
                sub.setId(rs.getString(1));
                sub.setName(rs.getString(2));
                sub.setCoefficient(rs.getInt(3));
                sub.setCourseID(rs.getString(4));
                sub.setStatus(rs.getInt(5));
                list.add(sub);
            }
        } catch (Exception ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public Subject readByID(String id) {
        Subject sub = null;
        try {
            con = db.getConnection();
            String sql = "select * from Subject where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                sub = new Subject();
                sub.setId(rs.getString(1));
                sub.setName(rs.getString(2));
                sub.setCoefficient(rs.getInt(3));
                sub.setCourseID(rs.getString(4));
                sub.setStatus(rs.getInt(5));
            }
        } catch (Exception ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return sub;
    }

    public boolean create(Subject sub) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "insert into Subject(Id,Name,Coefficient,CourseId,Status,Fees)" + " values (?,?,?,?,?); ";
            pst = con.prepareStatement(sql);
            pst.setString(1, sub.getId());
            pst.setString(2, sub.getName());
            pst.setInt(3, sub.getCoefficient());
            pst.setString(4, sub.getCourseID());
            pst.setInt(5, sub.getStatus());
            if (pst.executeUpdate() > 0) {
                setLastError("Add Subject Successfully");
                status = true;
            } else {
                setLastError("Add Subject unuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean update(Subject sub) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "select * from Subject where Id = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, sub.getId());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString(2, sub.getName());
                rs.updateInt(3, sub.getCoefficient());
                rs.updateString(4, sub.getCourseID());
                rs.updateInt(5, sub.getStatus());
                rs.updateRow();
                db.closeConnection();
                setLastError("Update Subject successfully");
                status = true;
            } else {
                setLastError("Update Subject unsuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean delete(String id) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "delete from Subject where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            if (pst.executeUpdate() > 0) {
                setLastError("Delete Subject successfully!");
                status = true;
            } else {
                setLastError("Delete Subject unsuccessfully!");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
}
