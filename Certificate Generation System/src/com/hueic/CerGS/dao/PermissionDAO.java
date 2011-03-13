/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Permission;
import com.hueic.CerGS.util.Configure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nhchung
 */
public class PermissionDAO  extends BaseDAO{

    public PermissionDAO() {
        db = new Configure();
    }

    public ArrayList<Permission> ReadByAll() {
        ArrayList<Permission> list = new ArrayList<Permission>();
        con = db.getConnection();
        String sql = "select * from Permission";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Permission per = new Permission();
                per.setId(rs.getInt(1));
                per.setName(rs.getString(2));
                list.add(per);
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return list;
    }

    public Permission ReadByID(int id) {
        Permission per = null;
        try {
            con = db.getConnection();
            String sql = "select * from Permission where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                per = new Permission();
                per.setId(rs.getInt(1));
                per.setName(rs.getString(2));
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        }
        return per;
    }

    public Permission ReadByName(String name)
    {
         Permission per = null;
        try {
            con = db.getConnection();
            String sql = "select * from Permission where Name = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            rs = pst.executeQuery();
            if (rs.next()) {
                per = new Permission();
                per.setId(rs.getInt(1));
                per.setName(rs.getString(2));
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        }
        return per;
    }

    public boolean Create(Permission per) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "insert into per(Id,Name)" + " values (?,?); ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, per.getId());
            pst.setString(2, per.getName());
            if (pst.executeUpdate() > 0) {
                setLastError("Add Permission Successfully");
                status = true;
            } else {
                setLastError("Add Permission unuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean Update(Permission per) {
        boolean status = false;
        try {
            con = db.getConnection();
            String sql = "select * from per where Id = ?";
            pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setInt(1, per.getId());
            rs = pst.executeQuery();
            if (rs.first()) {
                rs.updateString(2, per.getName());
                db.closeConnection();
                setLastError("Update Permission successfully");
                status = true;
            } else {
                setLastError("Update Permission unsuccessfully");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }

    public boolean Delete(int id)
    {
          boolean status = false;
        try {
            con = db.getConnection();
            String sql = "delete from Permission where Id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            if (pst.executeUpdate() > 0) {
                setLastError("Delete Permission successfully!");
                status = true;
            } else {
                setLastError("Delete Permission unsuccessfully!");
            }
        } catch (SQLException ex) {
            setLastError("SQL Error!");
        } finally {
            db.closeConnection();
        }
        return status;
    }
}