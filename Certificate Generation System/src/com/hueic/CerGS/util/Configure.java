/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhchung
 */
public class Configure {
    Connection con = null;
    public Connection getConnection() {
        //String url = "jdbc:sqlserver://localhost:1433;databaseName=CertificateGenerationSystem";
        String url = "jdbc:odbc:CertificateGenerationSystem";
        String user = "sa";
        String password = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = java.sql.DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void closeConnection() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Configure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
