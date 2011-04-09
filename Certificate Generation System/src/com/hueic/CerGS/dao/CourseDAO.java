/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.dao.IDao.ICourseDAO;
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
public class CourseDAO extends BaseDAO implements ICourseDAO {

    public CourseDAO() {
        db = new Configure();
    }

    public ArrayList<Course> readByAll() {
        ArrayList<Course> result = new ArrayList<Course>();
        con = db.getConnection();
        String sqlcommand = "select * from Course";
        try {
            pst = con.prepareStatement(sqlcommand);
            rs = pst.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getString(1));
                course.setName(rs.getString(2));
                course.setTotalFees(rs.getFloat(3));
                course.setStatus(rs.getInt(4));
                result.add(course);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
            return result;
        }
    }

    public ArrayList<Course> readCourseRegisterByStudentIdOfPerson(String studentIdOfPerson) {
        ArrayList<Course> result = new ArrayList<Course>();
        con = db.getConnection();
        String sqlcommand = "select * from Course where Id in (select CourseId from Register where PersonId = ?)";
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, studentIdOfPerson);
            rs = pst.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getString(1));
                course.setName(rs.getString(2));
                course.setTotalFees(rs.getFloat(3));
                course.setStatus(rs.getInt(4));
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
                course.setId(rs.getString(1));
                course.setName(rs.getString(2));
                course.setTotalFees(rs.getFloat(3));
                course.setStatus(rs.getInt(4));
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } catch (Exception ex) {
            setLastError("Data not valid");
        } finally {
            db.closeConnection();
        }
        return course;
    }

    public Course readByName(String name) {
        Course course = null;
        con = db.getConnection();
        String sqlcommand = "select * from Course where name = ?";
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, name);
            rs = pst.executeQuery();
            if (rs.first()) {
                course = new Course();
                course.setId(rs.getString(1));
                course.setName(rs.getString(2));
                course.setTotalFees(rs.getFloat(3));
                course.setStatus(rs.getInt(4));
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
        String sqlcommand = "insert into Course values(?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, course.getId());
            pst.setString(2, course.getName());
            pst.setFloat(3, course.getTotalFees());
            pst.setInt(4, course.getStatus());
            if (pst.executeUpdate() != 0) {
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
        String sqlcommand = "select * from Course where Id = ?";
        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, course.getId());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString(2, course.getName());
                rs.updateFloat(3, course.getTotalFees());
                rs.updateInt(4, course.getStatus());
                rs.updateRow();
                status = true;
                setLastError("Update Course successful");
            }
        } catch (SQLException ex) {
            setLastError(ex.toString());
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean delete(String id) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "delete from Course where id = ?";
        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, id);
            if (pst.executeUpdate() != 0) {
                status = true;
                setLastError("Delete Course successful");
            } else {
                setLastError("Delete Course unsuccessful");
            }
        } catch (SQLException ex) {
            setLastError(ex.toString());
        } finally {
            db.closeConnection();
            return status;
        }
    }
}
