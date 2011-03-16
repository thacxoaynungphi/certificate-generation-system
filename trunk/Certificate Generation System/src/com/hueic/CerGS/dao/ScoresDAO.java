/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Scores;
import com.hueic.CerGS.util.Configure;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wind
 */
public class ScoresDAO extends BaseDAO {

    public ScoresDAO() {
        db = new Configure();
    }

    public ArrayList<Scores> readByAll() {
        ArrayList<Scores> result = new ArrayList<Scores>();
        con = db.getConnection();
        String sqlcommand = "select * from Scores";

        try {
            pst = con.prepareCall(sqlcommand);
            rs = pst.executeQuery();

            while (rs.next()) {
                Scores scores = new Scores();
                scores.setId(rs.getInt("Id"));
                scores.setStudentId(rs.getString("StudentId"));
                scores.setSubjectId(rs.getString("SubjectId"));
                scores.setScore(rs.getFloat("Score"));
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

    public ArrayList<Scores> readByID(int id) {
        ArrayList<Scores> result = new ArrayList<Scores>();
        con = db.getConnection();
        String sqlcommand = "select * from Scores where id like ?";

        try {
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                Scores scores = new Scores();
                scores.setId(rs.getInt("Id"));
                scores.setStudentId(rs.getString("StudentId"));
                scores.setSubjectId(rs.getString("SubjectId"));
                scores.setScore(rs.getFloat("Score"));

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

    public boolean create(Scores scores) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "insert into Scores values(?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, scores.getId());
            pst.setString(2, scores.getStudentId());
            pst.setString(3, scores.getSubjectId());
            pst.setFloat(4, scores.getScore());
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

    public boolean update(Scores scores) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "select * from Scores where id like ?";

        try {
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, scores.getId());

            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString("StudentId", scores.getStudentId());
                rs.updateString("SubjectId", scores.getSubjectId());
                rs.updateFloat("Score1L1", scores.getScore());
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

    public boolean delete(Scores scores) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "delete from Scores where id like ?";

        try {
            pst = con.prepareCall(sqlcommand);
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
