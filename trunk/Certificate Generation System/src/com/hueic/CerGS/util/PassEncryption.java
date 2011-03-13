/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Encoder;

/**
 *
 * @author nhchung
 */
public class PassEncryption {
     public String encryptPass(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = md.digest(pass.getBytes());
            BASE64Encoder base = new BASE64Encoder();
            return base.encode(b);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PassEncryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
