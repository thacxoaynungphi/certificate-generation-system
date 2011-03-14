/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.FeesStructe;
import com.hueic.CerGS.util.Configure;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wind
 */
public class FeesStructeDAO extends BaseDAO{

    public FeesStructeDAO(){
        db = new Configure();
    }

    public ArrayList<FeesStructe> readByAll(){
        ArrayList<FeesStructe> result = new ArrayList<FeesStructe>();
        con = db.getConnection();
        String sqlcommand = "select * from FeesStructe";

        try{
            pst = con.prepareCall(sqlcommand);
            rs = pst.executeQuery();

            while(rs.next()){
                FeesStructe fee = new FeesStructe();
                fee.setId(rs.getInt("Id"));
                fee.setName(rs.getString("Name"));

                result.add(fee);
            }

            setLastError("read data successful");
        }catch(SQLException ex){
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
            return result;
        }
    }

    public ArrayList<FeesStructe> readByID(int id){
        ArrayList<FeesStructe> result = new ArrayList<FeesStructe>();
        con = db.getConnection();
        String sqlcommand = "select * from FeesStructe where id like ?";

        try{
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while(rs.next()){
                FeesStructe fee = new FeesStructe();
                fee.setId(rs.getInt("Id"));
                fee.setName(rs.getString("Name"));

                result.add(fee);
            }

            setLastError("read data successful");
        }catch(SQLException ex){
            setLastError("SQL Error");
        } finally {
            db.closeConnection();
            return result;
        }
    }

    public boolean create(FeesStructe fee){
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "insert into FeesStructe values(?, ?)";

        try{
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, fee.getId());
            pst.setString(2, fee.getName());

            if(pst.execute()){
                setLastError("Add fee successful");
                status = true;
            }else {
                setLastError("Add fee unsuccessful");
            }
        }catch(SQLException ex){
            setLastError("SQL Error!!!");
        }finally{
            db.closeConnection();
            return status;
        }
    }

    public boolean update(FeesStructe fee){
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "select * from FeesStructe where id like ?";

        try{
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, fee.getId());

            rs = pst.executeQuery();
            if(rs.first()){
                rs.updateInt("Id", fee.getId());
                rs.updateString("Name", fee.getName());
                rs.updateRow();

                setLastError("Add fee successful");
                status = true;
            }else {
                setLastError("Add fee unsuccessful");
            }
        }catch(SQLException ex){
            setLastError("SQL Error!!!");
        }finally{
            db.closeConnection();
            return status;
        }
    }

    public boolean delete(FeesStructe fee){
        boolean status = false;
        con = db.getConnection();
        String sqlcommand = "delete from FeesStructe where id like ?";

        try{
            pst = con.prepareCall(sqlcommand);
            pst.setInt(1, fee.getId());

            if(pst.execute()){
                setLastError("Add fee successful");
                status = true;
            }else {
                setLastError("Add fee unsuccessful");
            }
        }catch(SQLException ex){
            setLastError("SQL Error!!!");
        }finally{
            db.closeConnection();
            return status;
        }
    }
}
