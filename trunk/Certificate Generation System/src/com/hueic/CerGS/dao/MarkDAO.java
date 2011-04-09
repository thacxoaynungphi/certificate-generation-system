/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.dao.IDao.IMarkDAO;
import com.hueic.CerGS.entity.Mark;
import com.hueic.CerGS.entity.Register;
import com.hueic.CerGS.entity.Subject;
import com.hueic.CerGS.util.Configure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HuuBien
 */
public class MarkDAO extends BaseDAO implements IMarkDAO {

    private SubjectDAO subjectDAO;
    private RegisterDAO registerDAO;

    public MarkDAO() {
        subjectDAO = new SubjectDAO();
        registerDAO = new RegisterDAO();
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
        } catch (Exception ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
        }
        return listMark;
    }

    public Mark readByID(int id) {
        Mark result = new Mark();
        con = db.getConnection();
        String sqlcommand = "select * from Mark where id = ?";

        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.first()) {
                result.setId(rs.getInt(1));
                result.setStudentId(rs.getString(2));
                result.setSubjectId(rs.getString(3));
                result.setMark(rs.getFloat(4));
            }

            setLastError("Read data successful");
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
                mark = new Mark();
                mark.setId(rs.getInt("Id"));
                mark.setStudentId(rs.getString("StudentId"));
                mark.setSubjectId(rs.getString("SubjectId"));
                mark.setMark(rs.getFloat("Mark"));

                result.add(mark);
            }

            setLastError("Read data successful");
        } catch (Exception ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
        }
        return result;
    }

    public ArrayList<Mark> readByStudentID(String studentId) {
        ArrayList<Mark> result = new ArrayList<Mark>();
        con = db.getConnection();
        String sqlcommand = "select * from Mark where StudentId = ? ";
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
            setLastError("Read data successful");
        } catch (Exception ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
        }
        return result;
    }

    public ArrayList<Mark> readByStudentIDOfPerson(String studentIdOfPerson, String courseId) {
        ArrayList<Mark> result = new ArrayList<Mark>();
        con = db.getConnection();
        Mark mark = null;
        try {
            if (courseId.length() == 0) {
                String sqlcommand = "select * from Mark where StudentId in (select StudentId from Register where PersonId =  ?)";
                pst = con.prepareStatement(sqlcommand);
                pst.setString(1, studentIdOfPerson);
            } else {
                String sqlcommand = "select * from Mark where StudentId in (select StudentId from Register where PersonId =  ? and CourseId = ? )";
                pst = con.prepareStatement(sqlcommand);
                pst.setString(1, studentIdOfPerson);
                pst.setString(2, courseId);
            }
            rs = pst.executeQuery();
            while (rs.next()) {
                mark = new Mark();
                mark.setId(rs.getInt("Id"));
                mark.setStudentId(rs.getString("StudentId"));
                mark.setSubjectId(rs.getString("SubjectId"));
                mark.setMark(rs.getFloat("Mark"));
                result.add(mark);
            }
            setLastError("Read data successful");
        } catch (Exception ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
        }
        return result;
    }

    public boolean isCompleteCourse(String courseId, String studentId) {
        boolean status = true;
        con = db.getConnection();
        String sqlcommand = "select * from Subject s where s.CourseId = ? and s.Id not in (select m.SubjectId from Mark m where m.StudentId = ?) ";
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, courseId);
            pst.setString(2, studentId);
            rs = pst.executeQuery();

            while (rs.next()) {
                status = false;
            }
            setLastError("Read data successful");
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public float avgMark(String studentId) {
        float dtb = 0.0f;
        con = db.getConnection();
        String sqlcommand = "select avg(Mark) from Mark m where m.StudentId = ? ";
        try {
            pst = con.prepareStatement(sqlcommand);
            pst.setString(1, studentId);
            rs = pst.executeQuery();

            while (rs.next()) {
                dtb = rs.getFloat(1);
            }
            setLastError("read data successful");
        } catch (SQLException ex) {
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
        }
        return dtb;
    }

    public String getGrades(float mark) {
        String grades = "";
        if (mark < 40) {
            grades = "Unpass";
        } else if (mark < 50) {
            grades = "C";
        } else if (mark < 60) {
            grades = "B";
        } else if (mark < 75) {
            grades = "A";
        } else if (mark > 75) {
            grades = "Distinction";
        }

        return grades;
    }

    public boolean create(Mark mark) {
        boolean status = false;
        Register register = registerDAO.readByStudentCourseId(mark.getStudentId());
        Subject subject = subjectDAO.readByID(mark.getSubjectId());

        if (subject.getCourseID().equalsIgnoreCase(register.getCourseId())) {
            con = db.getConnection();
            String sqlcommand = "insert into Mark(StudentId,SubjectId,Mark) values(?, ?, ?)";
            try {
                pst = con.prepareStatement(sqlcommand);
                pst.setString(1, mark.getStudentId());
                pst.setString(2, mark.getSubjectId());
                pst.setFloat(3, mark.getMark());
                if (pst.executeUpdate() > 0) {
                    setLastError("Add mark successful");
                    status = true;
                } else {
                    setLastError("Add mark unsuccessful");
                }
            } catch (SQLException ex) {
                setLastError("SQL Error!!!");
            } finally {
                db.closeConnection();
            }
        } else {
            setLastError(String.format("Student not learning subject " + subject.getName()));
        }
        return status;
    }

    public boolean update(Mark mark) {
        boolean status = false;

        con = db.getConnection();
        String sqlcommand = "select * from Mark m where m.Id = ? and m.SubjectId in (select s.SubjectId from SubjectId where s.CourseId = (select r.CourseId from Register r where r.StudentId = m.StudentId))";

        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, mark.getId());

            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString("StudentId", mark.getStudentId());
                rs.updateString("SubjectId", mark.getSubjectId());
                rs.updateFloat("Mark", mark.getMark());
                rs.updateRow();
                setLastError("Update mark successful");
                status = true;
            } else {
                setLastError("Update mark unsuccessful");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();

        }
        return status;
    }

    public boolean delete(int id) {
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "delete from Mark where Id = ?";
        try {
            pst = con.prepareStatement(sqlcommand, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, id);
            if (pst.executeUpdate() > 0) {
                setLastError("Delete mark successful");
                status = true;
            } else {
                setLastError("Delete mark unsuccessful");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!!!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
}
