/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.component.GUIProperties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author nhchung
 */
public class GUIDAO {

    JFrame frame = null;

    public GUIDAO(JFrame frame) {
        this.frame = frame;
    }

    public void setGUI(String gui) {
        try {
            frame.setLocationRelativeTo(null);
            GUIProperties prop = new GUIProperties();
            UIManager.setLookAndFeel(gui);
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUIDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUIDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUIDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUIDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setLanguage(String lang) {
        //TODO: thiet lap ngon ngu cho chuong trinh
    }
}
