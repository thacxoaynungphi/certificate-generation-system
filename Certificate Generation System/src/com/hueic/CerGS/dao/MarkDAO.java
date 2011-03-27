/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Mark;
import com.hueic.CerGS.util.Configure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HuuBien
 */
public class MarkDAO extends BaseDAO {

    public MarkDAO() {
        db = new Configure();
    }

    public ArrayList<Mark> readByAll() {
        ArrayList<Mark> listMark = new ArrayList<Mark>();
        con = db.getConnection();
        String sqlcommand = "select * from Mark";

        try {
            pst = con.prepareStatement(sqlcommand);
            rs = pst.executeQuery();
            Mark mark = null;
            while (rs.next()) {
                mark = new Mark();
                mark.setId(rs.getInt(1));
                mark.setStudentId(rs.getString(2));
                mark.setSubjectId(rs.getString(3));
                mark.setMark(rs.getFloat(4));
                listMark.add(mark);
            }
            setLastError("Read data successful");
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
        }
        return listMark;
    }

    public Mark readByID(int id) {
        Mark result = new Mark();
        con = db.getConnection();
        String sqlcommand = "select * from Mark where id like ?";

        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.first()) {
                result.setId(rs.getInt("Id"));
                result.setStudentId(rs.getString("StudentId"));
                result.setSubjectId(rs.getString("SubjectId"));
                result.setMark(rs.getFloat("Mark"));
            }

            setLastError("read data successful");
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
            return result;
        }
    }

    public ArrayList<Mark> readBYCourseID(String courseId) {
        ArrayList<Mark> result = new ArrayList<Mark>();
        con = db.getConnection();
        String sqlcommand = "select m.* from Mark m inner join Register r on m.StudentId = r.StudentId  where r.CourseId = ?";
        Mark mark = null;
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, courseId);
            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("Hi");
                mark = new Mark();
                mark.setId(rs.getInt("Id"));
                mark.setStudentId(rs.getString("StudentId"));
                mark.setSubjectId(rs.getString("SubjectId"));
                mark.setMark(rs.getFloat("Mark"));

                result.add(mark);
            }

            setLastError("read data successful");
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
        }
        return result;
    }

    public ArrayList<Mark> readByStudentID(String studentId) {
        ArrayList<Mark> result = new ArrayList<Mark>();
        con = db.getConnection();
        String sqlcommand = "select * from Mark where Studentid like ?";
        Mark mark = null;
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, studentId);
            rs = pst.executeQuery();

            while (rs.next()) {
                mark = new Mark();
                mark.setId(rs.getInt("Id"));
                mark.setStudentId(rs.getString("StudentId"));
                mark.setSubjectId(rs.getString("SubjectId"));
                mark.setMark(rs.getFloat("Mark"));

                result.add(mark);
            }

            setLastError("read data successful");
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
        }
        return result;
    }

    public boolean create(Mark Marks) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "insert into Mark values(?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setInt(1, Marks.getId());
            pst.setString(2, Marks.getStudentId());
            pst.setString(3, Marks.getSubjectId());
            pst.setFloat(4, Marks.getMark());
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

    public boolean update(Mark Marks) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "select * from Mark where id like ?";

        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, Marks.getId());

            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString("StudentId", Marks.getStudentId());
                rs.updateString("SubjectId", Marks.getSubjectId());
                rs.updateFloat("Mark1L1", Marks.getMark());
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

    public boolean delete(Mark Marks) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "delete from Mark where id like ?";

        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, Marks.getId());

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

    public float getStudentMark(String studentID) {
        float totalMark = 0.0f;
        float avgMark = 0.0f;
        int total = 0;
        ArrayList<Mark> markList = readByStudentID(studentID);
        SubjectDAO subDAO = new SubjectDAO();

        for (Mark mark : markList) {
            totalMark += mark.getMark();
            total += subDAO.readByID(mark.getSubjectId()).getCoefficient();
        }

        avgMark = totalMark / total;

        return avgMark;
    }
}
