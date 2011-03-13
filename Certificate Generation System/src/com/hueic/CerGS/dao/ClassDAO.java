/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao;

import com.hueic.CerGS.util.Configure;
import com.hueic.CerGS.util.PassEncryption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wind
 */
public class ClassDAO {
    private Configure db;
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String lastError = "";
    private PassEncryption passEncryption = null;

    public ClassDAO(){
        db = new Configure();
        passEncryption = new PassEncryption();
    }

    public ArrayList<com.hueic.CerGS.entity.Class> ReadByAll(){
        ArrayList<com.hueic.CerGS.entity.Class> result = new ArrayList<com.hueic.CerGS.entity.Class>();
        con = db.getConnection();
        String sqlCommand = "select * from Class";

        try{
            pst = con.prepareCall(sqlCommand);
            rs = pst.executeQuery();

            while(rs.next()){
                com.hueic.CerGS.entity.Class cl = new com.hueic.CerGS.entity.Class();

                cl.setId(rs.getString("Id"));
                cl.setName(rs.getString("Name"));
                cl.setTotalFees(rs.getFloat("TotalFees"));
                cl.setCourseId(rs.getString("CourseId"));
                cl.setStartDate(rs.getString("StartDate"));
                cl.setFeesStructe(rs.getInt("FeesStructe"));
                cl.setStatus(rs.getInt("Status"));

                result.add(cl);
            }
        }catch(SQLException ex){
            setLastError("SQL Error!!!");
        }finally{
            db.closeConnection();
            return result;
        }
    }

    public ArrayList<com.hueic.CerGS.entity.Class> ReadByID(String id){
        ArrayList<com.hueic.CerGS.entity.Class> result = new ArrayList<com.hueic.CerGS.entity.Class>();
        con = db.getConnection();
        String sqlcommand = "select * from Class where id like ?";
        try{
            pst = con.prepareCall(sqlcommand);
            pst.setString(1, id);
            rs = pst.executeQuery();

            while(rs.next()){
                com.hueic.CerGS.entity.Class cl = new com.hueic.CerGS.entity.Class();

                cl.setId(rs.getString("Id"));
                cl.setName(rs.getString("Name"));
                cl.setTotalFees(rs.getFloat("TotalFees"));
                cl.setCourseId(rs.getString("CourseId"));
                cl.setStartDate(rs.getString("StartDate"));
                cl.setFeesStructe(rs.getInt("FeesStructe"));
                cl.setStatus(rs.getInt("Status"));

                result.add(cl);
            }
        } catch(SQLException ex){
            setLastError("SQL Error!!!");
        }finally{
            db.closeConnection();
            return result;
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
