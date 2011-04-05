/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component;

import com.hueic.CerGS.entity.Account;
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
public class RememberAccount {

    String fileName;

    public RememberAccount() {
        fileName = System.getProperty("user.dir") + "/config" + "/UserLogin.properties";
    }
    //thuc hien lay du lieu tu trong file luu tai khoan

    public Account getUser() {
        Account acc = null;
        File file = new File(fileName);
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                Properties properties = new Properties();
                properties.load(fis);
                if (properties.size() != 0) {
                    acc = new Account();
                    acc.setUsername(properties.getProperty("username"));
                    acc.setPassword(properties.getProperty("password"));
                    //TODO: chua thuc hien ma hoa duoc password trong file log
                    acc.setPermission(Integer.parseInt(properties.getProperty("permission")));
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
        return acc;
    }

    public void writeFile(Account acc) {
        FileOutputStream fos = null;
        try {
            Properties properties = new Properties();
            properties.setProperty("permission", String.valueOf(acc.getPermission()));
            properties.setProperty("password", acc.getPassword());
            properties.setProperty("username", acc.getUsername());
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
    public void clearUser() {
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
