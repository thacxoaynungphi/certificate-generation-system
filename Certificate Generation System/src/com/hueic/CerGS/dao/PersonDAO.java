/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Person;
import com.hueic.CerGS.util.Configure;
import com.hueic.CerGS.util.PassEncryption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhchung
 */
public class PersonDAO {

    private Configure db;
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String lastError = "";
    private PassEncryption passEncryption = null;

    public PersonDAO() {
        db = new Configure();
        passEncryption = new PassEncryption();
    }

    public ArrayList<Person> ReadByAll() {
        ArrayList<Person> list = new ArrayList<Person>();
        con = db.getConnection();
        String sql = "select * from Person";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getString("Id"));
                person.setFirstName(rs.getString("FirstName"));
                person.setLastName(rs.getString("LastName"));
                person.setBirthDay(rs.getString("Birthday"));
                person.setGender(rs.getString("Gender"));
                person.setPhone(rs.getString("Phone"));
                person.setEmail(rs.getString("Email"));
                person.setAddress(rs.getString("Address"));
                person.setImage(rs.getString("Image"));
                person.setStatus(rs.getInt("Status"));
                list.add(person);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public Person ReadByID(String id) {
        Person person = null;
        try {
            con = db.getConnection();
            String sql = "select * from Person where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                person = new Person();
                person.setId(rs.getString("Id"));
                person.setFirstName(rs.getString("FirstName"));
                person.setLastName(rs.getString("LastName"));
                person.setBirthDay(rs.getString("Birthday"));
                person.setGender(rs.getString("Gender"));
                person.setPhone(rs.getString("Phone"));
                person.setEmail(rs.getString("Email"));
                person.setAddress(rs.getString("Address"));
                person.setImage(rs.getString("Image"));
                person.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        }
        return person;
    }

    public boolean Create(Person person) {
        try {
            con = db.getConnection();
            String sql = "insert into Person(Id,FirstName,LastName,Birthday,Gender,Phone,Email,Address,Image,Status)" + " values (?,?,?,?,?,?,?); ";
            pst = con.prepareStatement(sql);
            pst.setString(1, person.getId());
            pst.setString(2, person.getFirstName());
            pst.setString(3, person.getLastName());
            pst.setString(4, person.getBirthDay());
            pst.setString(5, person.getGender());
            pst.setString(6, person.getPhone());
            pst.setString(7, person.getEmail());
            pst.setString(8, person.getAddress());
            pst.setString(9, person.getImage());
            pst.setInt(10, person.getStatus());

            if(pst.executeUpdate() > 0)
            {
                setLastError("Add Person Successfully");
                db.closeConnection();
                return true;
            }
        } catch (SQLException ex) {
           setLastError("SQL Error!");
           db.closeConnection();
           return  false;
        }

        setLastError("Add Fail!");
        db.closeConnection();
        return  false;
    }


    public boolean Update(Person person)
    {
        try {
            con = db.getConnection();
            String sql = "select * from Person where Id = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, person.getId());
            rs.first();
            rs.updateString(2,person.getFirstName());
            rs.updateString(3, person.getLastName());
            rs.updateString(4, person.getBirthDay());
            rs.updateString(5, person.getGender());
            rs.updateString(6, person.getPhone());
            rs.updateString(7, person.getEmail());
            rs.updateString(8, person.getAddress());
            rs.updateString(9, person.getImage());
            rs.updateInt(10, person.getStatus());
            rs.updateRow();
            db.closeConnection();
            setLastError("Update Person successfully");
            return true;
        } catch (SQLException ex) {
            setLastError("SQL Error!");
            db.closeConnection();
            return false;
        }
        
    }

    /**
     * @return the lastError
     */
    public String getLastError() {
        return lastError;
    }

    /**
     * @param lastError the lastError to set
     */
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }
}
