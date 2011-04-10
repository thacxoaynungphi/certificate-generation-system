/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.util;

import com.hueic.CerGS.component.ConfigureDB;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class Configure {

    Connection con = null;
    ConfigureDB configureDB = new ConfigureDB();

    public Configure() {
    }

    public Connection getConnection() {
        com.hueic.CerGS.entity.Configure config = new com.hueic.CerGS.entity.Configure();
        config = configureDB.getInfo();
        String url = "jdbc:sqlserver://" + config.getSever() + ":" + config.getPort() + ";databaseName=" + config.getDatabase() + "";
        String user = config.getUsername();
        String password = config.getPassword();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = java.sql.DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Error connect database", "Error Connect", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return con;
    }

    public void closeConnection() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
        }
    }
}
