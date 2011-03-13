/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.entity.Account;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhchung
 */
public class RememberAccount {

    String fileName = "";
    //thuc hien lay du lieu tu trong file luu tai khoan

    public Account GetUser() {
        Account acc = null;
        File file = new  File(fileName);
        if(file.exists())
        {
            acc = new Account();
            //TODO: lay du lieu tu file remerber password
        }
        return null;
    }

    //xoa cac du lieu tai khoan da dang nhap vo trong tai khoan
    public void ClearUser() {
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
