/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Employee;
import com.hueic.CerGS.entity.Person;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhchung
 */
public class EmployeeDAO extends BaseDAO {

    public EmployeeDAO() {
        super();
    }

    public ArrayList<Employee> readByAll() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        con = db.getConnection();
        String sql = "select e.Id,p.FirstName,p.LastName,p.BirthDay,p.Gender,p.Phone,p.Email,p.Address,p.Image,p.Status,e.BeginWork from Employee e inner join Person p on e.Id = p.Id";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getString(1));
                emp.setFirstName(rs.getString(2));
                emp.setLastName(rs.getString(3));
                emp.setBirthDay(rs.getDate(4));
                emp.setGender(rs.getInt(5));
                emp.setPhone(rs.getString(6));
                emp.setEmail(rs.getString(7));
                emp.setAddress(rs.getString(8));
                emp.setImage(rs.getString(9));
                emp.setStatus(rs.getInt(10));
                emp.setBeginWork(rs.getDate(11));
                list.add(emp);
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public ArrayList<Employee> readByCommand(String fname, String lname, Date startDate, Date endDate, int gender) {
        ArrayList<Employee> listEmp = new ArrayList<Employee>();

        try {
            con = db.getConnection();
            String sqlCommand = "select s.Id,p.FirstName,p.LastName,p.BirthDay,p.Gender,p.Phone,p.Email,p.Address,p.Image,p.Status,e.BeginWork"
                    + " from Student s inner join Person p on s.Id = p.Id where ";
            if(fname.length() != 0) sqlCommand += " s.FirstName =  " + fname;
            if(lname.length() != 0) sqlCommand += " and s.LastName =  " + lname;
            if(startDate != null) sqlCommand += " and s.birthday > ? ";
            if(endDate != null) sqlCommand += " and s.birthday < ? and ";

            sqlCommand +=  " gender = " + gender;

            pst = con.prepareStatement(sqlCommand);
            if(startDate != null){
                pst.setDate(1, (java.sql.Date) startDate);
                if(endDate != null){
                    pst.setDate(2, (java.sql.Date) endDate);
                }
            }
            else{
                if(endDate != null){
                     pst.setDate(1, (java.sql.Date) endDate);
                }
            }

            rs = pst.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee();

                emp.setId(rs.getString(1));
                emp.setFirstName(rs.getString(2));
                emp.setLastName(rs.getString(3));
                emp.setBirthDay(rs.getDate(4));
                emp.setGender(rs.getInt(5));
                emp.setPhone(rs.getString(6));
                emp.setEmail(rs.getString(7));
                emp.setAddress(rs.getString(8));
                emp.setImage(rs.getString(9));
                emp.setStatus(rs.getInt(10));
                emp.setBeginWork(rs.getDate(11));

                listEmp.add(emp);
            }

        } catch (Exception ex) {
            setLastError("SQL Error!");
        }

        return listEmp;
    }
    public Employee readByID(String id) {
        Employee emp = null;
        try {
            con = db.getConnection();
            String sql = "select e.Id,p.FirstName,p.LastName,p.BirthDay,p.Gender,p.Phone,p.Email,p.Address,p.Image,p.Status,e.BeginWork from Employee e inner join Person p on e.Id = p.Id  where e.Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                emp = new Employee();
                emp.setId(rs.getString(1));
                emp.setFirstName(rs.getString(2));
                emp.setLastName(rs.getString(3));
                emp.setBirthDay(rs.getDate(4));
                emp.setGender(rs.getInt(5));
                emp.setPhone(rs.getString(6));
                emp.setEmail(rs.getString(7));
                emp.setAddress(rs.getString(8));
                emp.setImage(rs.getString(9));
                emp.setStatus(rs.getInt(10));
                emp.setBeginWork(rs.getDate(11));
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emp;
    }

    public boolean create(Employee emp) {
        boolean status = false;
        Person person = emp;
        PersonDAO personDAO = new PersonDAO();
        if (personDAO.create(person)) {
            try {
                con = db.getConnection();
                String sql = "insert into Employee(Id,BeginWork)" + " values (?,?); ";
                pst = con.prepareStatement(sql);
                pst.setString(1, emp.getId());
                pst.setDate(2, (java.sql.Date) emp.getBeginWork());
                if (pst.executeUpdate() > 0) {
                    setLastError("Add Employee Successfully");
                    status = true;
                } else {
                    setLastError("Add Employee unuccessfully");
                }
            } catch (SQLException ex) {
                setLastError("SQL Error!");
            } finally {
                db.closeConnection();
            }
        } else {
            setLastError("Add Employee unuccessfully");
        }
        return status;
    }

    public boolean update(Employee emp) {
        boolean status = false;
        Person person = emp;
        PersonDAO personDAO = new PersonDAO();
        if (personDAO.update(person)) {
            try {
                con = db.getConnection();
                String sql = "select * from Employee where Id = ?";
                pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                pst.setString(1, person.getId());
                rs = pst.executeQuery();
                if (rs.first()) {
                    rs.updateDate(2, (java.sql.Date) emp.getBeginWork());
                    rs.updateRow();
                    setLastError("Update Employee successfully");
                    status = true;
                } else {
                    setLastError("Update Employee unsuccessfully");
                }
            } catch (SQLException ex) {
                setLastError("SQL Error!");
            } finally {
                db.closeConnection();
            }
        } else {
            setLastError("Update Employee unsuccessfully");
        }
        return status;
    }

    public boolean delete(String id) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "delete from Employee where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            if (pst.executeUpdate() > 0) {
                PersonDAO personDAO = new PersonDAO();
                if (personDAO.delete(id)) {
                    setLastError("Delete Employee successfully!");
                    status = true;
                    //TODO: chua thuc hien kiem tra giao dich
                }
            } else {
                setLastError("Delete Employee unsuccessfully!");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
}
