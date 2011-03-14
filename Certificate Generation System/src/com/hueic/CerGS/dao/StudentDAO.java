/*
 * To change this tstudentlate, choose Tools | Tstudentlates
 * and open the tstudentlate in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Student;
import com.hueic.CerGS.entity.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhchung
 */
public class StudentDAO extends BaseDAO {

    public ArrayList<Student> readByAll() {
        ArrayList<Student> list = new ArrayList<Student>();
        con = db.getConnection();
        String sql = "select s.Id,p.FirstName,p.LastName,p.BirthDay,p.Gender,p.Phone,p.Email,p.Address,p.Image,p.Status,s.ClassId,s.CurrentClass,s.RegistrationDate from Student s inner join Person p on s.Id = p.Id";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString(1));
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setBirthDay(rs.getString(4));
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
            String sql = "select s.Id,p.FirstName,p.LastName,p.BirthDay,p.Gender,p.Phone,p.Email,p.Address,p.Image,p.Status,s.ClassId,s.CurrentClass,s.RegistrationDate from Student s inner join Person p on s.Id = p.Id  where s.Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getString(1));
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setBirthDay(rs.getString(4));
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

    public boolean create(Student student) {
        boolean status = false;
        Person person = student;
        PersonDAO personDAO = new PersonDAO();
        if (personDAO.create(person)) {
            try {
                con = db.getConnection();
                String sql = "insert into Student(Id,ClassId,CurrentClass,RegistrationDate)" + " values (?,?,?,?); ";
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
            try {
                con = db.getConnection();
                String sql = "select * from Student where Id = ?";
                pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pst.setString(1, person.getId());
                rs = pst.executeQuery();
                if (rs.first()) {
//                    rs.updateString(2, student.getClassID());
//                    rs.updateString(3, student.getCurrentClass());
//                    rs.updateString(4, student.getRegistrationDate());
                    rs.updateRow();
                    setLastError("Update Student successfully");
                    status = true;
                } else {
                    setLastError("Update Student unsuccessfully");
                }
            } catch (SQLException ex) {
                setLastError("SQL Error!");
            } finally {
                db.closeConnection();
            }
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
