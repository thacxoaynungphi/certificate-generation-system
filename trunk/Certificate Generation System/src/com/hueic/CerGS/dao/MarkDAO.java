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
        ArrayList<Mark> result = new ArrayList<Mark>();
        con = db.getConnection();
        String sqlcommand = "select * from Scores";

        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();

            while (rs.next()) {
                Mark scores = new Mark();
                scores.setId(rs.getInt("Id"));
                scores.setStudentId(rs.getString("StudentId"));
                scores.setSubjectId(rs.getString("SubjectId"));
                scores.setMark(rs.getFloat("Score"));
                result.add(scores);
            }

            setLastError("read data successful");
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
            return result;
        }
    }

    public Mark readByID(int id) {
        Mark result = new Mark();
        con = db.getConnection();
        String sqlcommand = "select * from Scores where id like ?";

        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.first()) {
                result.setId(rs.getInt("Id"));
                result.setStudentId(rs.getString("StudentId"));
                result.setSubjectId(rs.getString("SubjectId"));
                result.setMark(rs.getFloat("Score"));
            }

            setLastError("read data successful");
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
            return result;
        }
    }

    public Mark readByStudentID(String studentId) {
        Mark result = new Mark();
        con = db.getConnection();
        String sqlcommand = "select * from Scores where Studentid like ?";

        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, studentId);
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

    public boolean create(Mark scores) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "insert into Scores values(?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setInt(1, scores.getId());
            pst.setString(2, scores.getStudentId());
            pst.setString(3, scores.getSubjectId());
            pst.setFloat(4, scores.getMark());
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

    public boolean update(Mark scores) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "select * from Scores where id like ?";

        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, scores.getId());

            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString("StudentId", scores.getStudentId());
                rs.updateString("SubjectId", scores.getSubjectId());
                rs.updateFloat("Score1L1", scores.getMark());
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

    public boolean delete(Mark scores) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "delete from Scores where id like ?";

        try {
            pst = con.prepareStatement(sqlcommand,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, scores.getId());

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
}
