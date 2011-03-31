/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component;

import com.hueic.CerGS.entity.Account;
import com.hueic.CerGS.entity.Configure;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhchung
 */
public class ConfigureDB {

    String fileName = "src/com/hueic/CerGS/temp/ConfigureDB.properties";
    //thuc hien lay du lieu tu trong file luu tai khoan

    public Configure getInfo() {
        Configure config = null;
        File file = new File(fileName);
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                Properties properties = new Properties();
                properties.load(fis);
                if (properties.size() != 0) {
                    config = new Configure();
                    config.setDatabase(properties.getProperty("database"));
                    config.setSever(properties.getProperty("server"));
                    config.setPort(properties.getProperty("port"));
                    config.setUsername(properties.getProperty("username"));
                    config.setPassword(properties.getProperty("password"));
                }
            } catch (Exception ex) {
                Logger.getLogger(RememberAccount.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(RememberAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return config;
    }

    public void writeFile(Configure config) {
        FileOutputStream fos = null;
        try {
            Properties properties = new Properties();
            properties.setProperty("password", config.getPassword());
            properties.setProperty("username", config.getUsername());
            properties.setProperty("port", config.getPort());
            properties.setProperty("server", config.getSever());
            properties.setProperty("database", config.getDatabase());
            File file = new File(fileName);
            fos = new FileOutputStream(file, false);
            properties.store(fos, null);
        } catch (IOException ex) {
            Logger.getLogger(RememberAccount.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(RememberAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //xoa cac du lieu tai khoan da dang nhap vo trong tai khoan
    public void clear() {
        FileInputStream fis = null;
        try {
            File file = new File(fileName);
            fis = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fis);
            properties.clear();
        } catch (IOException ex) {
            Logger.getLogger(RememberAccount.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(RememberAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
