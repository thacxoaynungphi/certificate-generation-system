/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hueic.CerGS.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhchung
 */
public class LanguageProperties {

    public String lang = "fr_FR";
    public String filename = null;
    public LanguageProperties()
    {
        filename = "src/com/hueic/CerGS/lang/Languages_"+lang+".properties";
    }
    public String getValueLanguage(String value)
    {
        String str = null;
        FileInputStream fis = null;
        try {
            File file = new File(filename);
            fis = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fis);
            str = properties.getProperty(value);
        } catch (IOException ex) {
            Logger.getLogger(LanguageProperties.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(LanguageProperties.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return str;
    }
}
