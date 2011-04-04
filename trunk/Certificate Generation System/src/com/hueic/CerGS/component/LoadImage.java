/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author nhchung
 */
public class LoadImage {

    public static void copyImage(String source, String destination) {
        try {
            File sourceFile = new File(source);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile), 4096);

            File targetFile = new File(destination);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile), 4096);
            int theChar;
            while ((theChar = bis.read()) != -1) {
                bos.write(theChar);
            }
            bos.close();
            bis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
