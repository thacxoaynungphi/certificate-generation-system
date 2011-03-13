/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao;

import com.hueic.CerGS.util.Configure;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wind
 */
public class ClassDAO extends BaseDAO {

    public ClassDAO(){
        db = new Configure();
    }

    public ArrayList<com.hueic.CerGS.entity.Class> readByAll(){
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

    public ArrayList<com.hueic.CerGS.entity.Class> readByID(String id){
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

    public boolean create(com.hueic.CerGS.entity.Class cl){
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "insert into Class values(?, ?, ?, ?, ?, ?, ?)";
        try{
            pst = con.prepareCall(sqlcommand);
            pst.setString(1, cl.getId());
            pst.setString(2, cl.getName());
            pst.setFloat(3, cl.getTotalFees());
            pst.setString(4, cl.getCourseId());
            pst.setString(5, cl.getStartDate());
            pst.setInt(6, cl.getFeesStructe());
            pst.setInt(7, cl.getStatus());

            if(pst.execute()){
                setLastError("Add Class to Database successful");
                status = true;
            }else{
                setLastError("Add Class to Database unsuccessful");
                status = false;
            }
        }catch(SQLException ex){
            setLastError("SQL Error!!!");
        }finally{
            db.closeConnection();
        }
        return status;
    }

    public boolean update(com.hueic.CerGS.entity.Class cl){
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "select * from Class where Id like ?";
        try{
            pst = con.prepareCall(sqlcommand);
            rs = pst.executeQuery();

            if(rs.first()){
                rs.updateString("Id", cl.getId());
                rs.updateString("Name", cl.getName());
                rs.updateFloat("TotalFees", cl.getTotalFees());
                rs.updateString("CourseId", cl.getCourseId());
                rs.updateString("StartDate", cl.getStartDate());
                rs.updateInt("FeesStructe", cl.getFeesStructe());
                rs.updateInt("Status", cl.getStatus());
                rs.updateRow();
                
                setLastError("Update Information Class successful");
                status = true;
            } else {
                setLastError("Update Information Class unsuccessful");
                status = false;
            }
        }catch(SQLException ex){
            setLastError("SQL Error!!!");
        }finally{
            db.closeConnection();
            return status;
        }
    }

    public boolean delete(com.hueic.CerGS.entity.Class cl){
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "delete from Class where Id like ?";
        try{
            pst = con.prepareCall(sqlcommand);
            if(pst.execute()){
                status = true;
                setLastError("Delete class successful");
            }else {
                setLastError("Delete class unsuccessful");
            }
        }catch(SQLException ex){
            setLastError("SQL Error!!!");
        }finally{
            db.closeConnection();
            return status;
        }
    }
}
