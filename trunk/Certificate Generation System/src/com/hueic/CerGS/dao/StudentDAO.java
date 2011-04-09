/*
 * To change this tstudentlate, choose Tools | Tstudentlates
 * and open the tstudentlate in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.dao.IDao.IStudentDAO;
import com.hueic.CerGS.entity.Student;
import com.hueic.CerGS.entity.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author nhchung
 */
public class StudentDAO extends BaseDAO implements IStudentDAO {

    public ArrayList<Student> readByAll() {
        ArrayList<Student> list = new ArrayList<Student>();
        con = db.getConnection();
        String sql = "select s.Id,p.FirstName,p.LastName,p.BirthDay,p.Gender,p.Phone,p.Email,p.Address,p.Image,p.Status from Student s inner join Person p on s.Id = p.Id order by (s.Id) asc";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString(1));
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setBirthDay(rs.getDate(4));
                student.setGender(rs.getInt(5));
                student.setPhone(rs.getString(6));
                student.setEmail(rs.getString(7));
                student.setAddress(rs.getString(8));
                student.setImage(rs.getString(9));
                student.setStatus(rs.getInt(10));
                list.add(student);
            }
        } catch (Exception ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public Student readByID(String id) {
        Student student = null;
        try {
            con = db.getConnection();
            String sql = "select s.Id,p.FirstName,p.LastName,p.BirthDay,p.Gender,p.Phone,p.Email,p.Address,p.Image,p.Status from Student s inner join Person p on s.Id = p.Id  where s.Id = ? order by (s.Id) asc";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getString(1));
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setBirthDay(rs.getDate(4));
                student.setGender(rs.getInt(5));
                student.setPhone(rs.getString(6));
                student.setEmail(rs.getString(7));
                student.setAddress(rs.getString(8));
                student.setImage(rs.getString(9));
                student.setStatus(rs.getInt(10));
            }
        } catch (Exception ex) {
            setLastError("SQL Error!");
        }
        return student;
    }

    public String convertDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String str = calendar.get(Calendar.MONTH) + 1 + "/" + calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.YEAR);
        return str;
    }

    public boolean create(Student student) {
        boolean status = false;
        Person person = student;
        PersonDAO personDAO = new PersonDAO();
        if (personDAO.create(person)) {
            try {
                con = db.getConnection();
                String sql = "insert into Student(Id)" + " values (?); ";
                pst = con.prepareStatement(sql);
                pst.setString(1, student.getId());
                if (pst.executeUpdate() > 0) {
                    setLastError("Add Student Successfully");
                    status = true;
                } else {
                    setLastError("Add Student unuccessfully");
                }
            } catch (SQLException ex) {
                setLastError("SQL Error!");
            } finally {
                db.closeConnection();
            }
        } else {
            setLastError("Add Student unuccessfully");
        }
        return status;
    }

    public boolean update(Student student) {
        boolean status = false;
        Person person = student;
        PersonDAO personDAO = new PersonDAO();
        if (personDAO.update(person)) {
            setLastError("Update Student successfully");
            status = true;
        } else {
            setLastError("Update Student unsuccessfully");
        }

        return status;
    }

    public boolean delete(String id) {
        boolean status = false;

        try {
            con = db.getConnection();
            String sql = "delete from Student where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);

            if (pst.executeUpdate() > 0) {
                PersonDAO personDAO = new PersonDAO();
                if (personDAO.delete(id)) {
                    setLastError("Delete Student successfully!");
                    status = true;
                    //TODO: chua thuc hien kiem tra giao dich
                }
            } else {
                setLastError("Delete Student unsuccessfully!");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
}
