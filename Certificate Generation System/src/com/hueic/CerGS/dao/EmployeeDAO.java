/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Employee;
import com.hueic.CerGS.entity.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public class EmployeeDAO extends BaseDAO {

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
                emp.setBirthDay(rs.getString(4));
                emp.setGender(rs.getString(5));
                emp.setPhone(rs.getString(6));
                emp.setEmail(rs.getString(7));
                emp.setAddress(rs.getString(8));
                emp.setImage(rs.getString(9));
                emp.setStatus(rs.getInt(10));
                emp.setBeginWork(rs.getString(11));
                list.add(emp);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return list;
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
                emp.setBirthDay(rs.getString(4));
                emp.setGender(rs.getString(5));
                emp.setPhone(rs.getString(6));
                emp.setEmail(rs.getString(7));
                emp.setAddress(rs.getString(8));
                emp.setImage(rs.getString(9));
                emp.setStatus(rs.getInt(10));
                emp.setBeginWork(rs.getString(11));
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
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
                pst.setString(2, emp.getBeginWork());
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
                    rs.updateString(2, emp.getBeginWork());
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
