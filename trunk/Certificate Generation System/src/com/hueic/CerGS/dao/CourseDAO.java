/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Course;
import com.hueic.CerGS.util.Configure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HuuBien
 * Version 1.0
 * Date: 13/3/2011
 *
 */
public class CourseDAO extends BaseDAO {

    public CourseDAO() {
        db = new Configure();
    }

    public ArrayList<Course> readByAll() {
        ArrayList<Course> result = new ArrayList<Course>();
        con = db.getConnection();
        String sqlcommand = "select * from Course";
        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getString("Id"));
                course.setName(rs.getString("Name"));
                course.setStatus(rs.getInt("Status"));
                result.add(course);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
            return result;
        }

    }

    public Course readById(String id) {
        Course course = null;
        con = db.getConnection();
        String sqlcommand = "select * from Course where Id = ?";
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                course = new Course();
                course.setId(rs.getString("Id"));
                course.setName(rs.getString("Name"));
                course.setTotalFees(rs.getFloat("TotalFees"));
                course.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
        }
        return course;
    }

    public Course readByName(String name) {
        Course course = null;
        con = db.getConnection();
        String sqlcommand = "select * from Course where name like ?";
        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, name);
            rs = pst.executeQuery();
            if (rs.first()) {
                course = new Course();
                course.setId(rs.getString("Id"));
                course.setName(rs.getString("Name"));
                course.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
            return course;
        }
    }

    public boolean create(Course course) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "insert into Course values(?, ?, ?)";
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, course.getId());
            pst.setString(2, course.getName());
            pst.setInt(3, course.getStatus());
            if (pst.execute()) {
                status = true;
                setLastError("Add Course successful.");
            } else {
                status = false;
                setLastError("Add Course unsuccessful.");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
            return status;
        }
    }

    public boolean update(Course course) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "select * from Course where id = ?";
        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, course.getId());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString("Name", course.getName());
                rs.updateInt("Status", course.getStatus());
                rs.updateFloat("TotalFees", course.getTotalFees());
                rs.updateRow();
                setLastError("Update Course successful");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean delete(String id) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "delete from Course where id like ?";
        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, id);
            if (pst.execute()) {
                setLastError("Delete Course successful");
            } else {
                setLastError("Delete Course unsuccessful");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
            return status;
        }
    }
}
