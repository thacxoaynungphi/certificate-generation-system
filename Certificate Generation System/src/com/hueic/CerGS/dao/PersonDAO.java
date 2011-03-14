/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Person;
import com.hueic.CerGS.util.Configure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhchung
 */
public class PersonDAO extends BaseDAO {
    
    public PersonDAO() {
        db = new Configure();
    }

    public ArrayList<Person> readByAll() {
        ArrayList<Person> list = new ArrayList<Person>();
        con = db.getConnection();
        String sql = "select * from Person";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getString(1));
                person.setFirstName(rs.getString(2));
                person.setLastName(rs.getString(3));
                person.setBirthDay(rs.getString(4));
                person.setGender(rs.getInt(5));
                person.setPhone(rs.getString(6));
                person.setEmail(rs.getString(7));
                person.setAddress(rs.getString(8));
                person.setImage(rs.getString(9));
                person.setStatus(rs.getInt(10));
                list.add(person);
            }
        } catch (Exception ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public Person readByID(String id) {
        Person person = null;
        try {
            con = db.getConnection();
            String sql = "select * from Person where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                person = new Person();
                person.setId(rs.getString(1));
                person.setFirstName(rs.getString(2));
                person.setLastName(rs.getString(3));
                person.setBirthDay(rs.getString(4));
                person.setGender(rs.getInt(5));
                person.setPhone(rs.getString(6));
                person.setEmail(rs.getString(7));
                person.setAddress(rs.getString(8));
                person.setImage(rs.getString(9));
                person.setStatus(rs.getInt(10));
            }
        } catch (Exception ex) {
          setLastError("SQL Error!");
        }
        return person;
    }

    public boolean create(Person person) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "insert into Person(Id,FirstName,LastName,Birthday,Gender,Phone,Email,Address,Image,Status)" + " values (?,?,?,?,?,?,?); ";
            pst = con.prepareStatement(sql);
            pst.setString(1, person.getId());
            pst.setString(2, person.getFirstName());
            pst.setString(3, person.getLastName());
            pst.setString(4, person.getBirthDay());
            pst.setInt(5, person.getGender());
            pst.setString(6, person.getPhone());
            pst.setString(7, person.getEmail());
            pst.setString(8, person.getAddress());
            pst.setString(9, person.getImage());
            pst.setInt(10, person.getStatus());
            if (pst.executeUpdate() > 0) {
                setLastError("Add Person Successfully");
                status = true;
            } else {
                setLastError("Add Person unuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean update(Person person) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "select * from Person where Id = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, person.getId());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString(2, person.getFirstName());
                rs.updateString(3, person.getLastName());
                rs.updateString(4, person.getBirthDay());
                rs.updateInt(5, person.getGender());
                rs.updateString(6, person.getPhone());
                rs.updateString(7, person.getEmail());
                rs.updateString(8, person.getAddress());
                rs.updateString(9, person.getImage());
                rs.updateInt(10, person.getStatus());
                rs.updateRow();
                db.closeConnection();//du code ne
                setLastError("Update Person successfully");
                status = true;
            } else {
                setLastError("Update Person unsuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean delete(String Id) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "delete from Person where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, Id);
            if (pst.executeUpdate() > 0) {
                setLastError("Delete Person successfully!");
                status = true;
            } else {
                setLastError("Delete Person unsuccessfully!");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
}