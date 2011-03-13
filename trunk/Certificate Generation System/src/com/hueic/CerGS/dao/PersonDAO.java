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

    public Person ReadByID(String id)
    {
        Person person = null;
        try
        {
            con = db.getConnection();
            String sql = "select * from Person where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if(rs.next())
            {
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
        }
        catch(SQLException ex)
        {
            setLastError("SQL Error!");
        }
        return person;
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
