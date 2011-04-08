/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.dao.IDao.IBaseDAO;
import com.hueic.CerGS.util.Configure;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author nhchung
 */
public class BaseDAO implements IBaseDAO {

    protected Configure db;
    protected Connection con = null;
    protected ResultSet rs = null;
    protected PreparedStatement pst = null;
    protected String lastError = "";

    public BaseDAO() {
        db = new Configure();
    }

    public int readIdentity(String tableName) {
        con = db.getConnection();
        int result = -1;
        String sql = "SELECT IDENT_CURRENT(?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, tableName);
            rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            setLastError("Read All successfully");
        } catch (Exception ex) {
            setLastError("Read All unsuccessfully");
        } finally {
            db.closeConnection();
        }
        return result;
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
