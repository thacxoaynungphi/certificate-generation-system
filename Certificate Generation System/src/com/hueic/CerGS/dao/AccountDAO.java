/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Account;
import com.hueic.CerGS.util.Configure;
import com.hueic.CerGS.util.PassEncryption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhchung
 */
public class AccountDAO extends BaseDAO {

    PassEncryption passEncryption = null;

    public AccountDAO() {
        db = new Configure();
        passEncryption = new PassEncryption();
    }

    public ArrayList<Account> readByAll() {
        ArrayList<Account> list = new ArrayList<Account>();
        con = db.getConnection();
        String sql = "select * from Account";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString(1));
                account.setPassword(rs.getString(2));
                account.setPermission(rs.getInt(3));
                list.add(account);
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public boolean login(Account acc) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "select * from Account where username = ? and password = ? and permission = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, acc.getUsername());
            pst.setString(2, passEncryption.encryptPass(acc.getPassword()));
            pst.setInt(3, acc.getPermission());
            rs = pst.executeQuery();
            if (rs.next()) {
                status = true;
                setLastError("Login successfully");
            } else {
                setLastError("Login unsuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean changePass(Account acc, String oldPass) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "select * from Account where username = ? add password = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, acc.getUsername());
            pst.setString(2, acc.getPassword());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString(2, passEncryption.encryptPass(acc.getPassword()));
                rs.updateRow();
                setLastError("Change Password successfully");
                status = true;
            } else {
                setLastError("Change Password unsuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean create(Account acc) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "insert into Account (username,password,permmison) " + " values (?,?,?);";
            pst = con.prepareStatement(sql);
            pst.setString(1, acc.getUsername());
            pst.setString(2, acc.getPassword());
            pst.setInt(3, acc.getPermission());
            if (pst.executeUpdate() > 0) {
                setLastError("Create Account suceessfully");
                status = true;
            } else {
                setLastError("Create Account unsuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean update(Account acc) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "select * from Account where username = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, acc.getUsername());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString(2, acc.getPassword());
                rs.updateInt(3, acc.getPermission());
                rs.updateRow();
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

    public boolean delete(Account acc) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "delete from Account where username = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, acc.getUsername());
            if (pst.executeUpdate() > 0) {
                setLastError("Delete Account successfully");
                status = true;
            } else {
                setLastError("Delete Account unsuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
}
