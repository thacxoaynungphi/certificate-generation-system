/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.hueic.CerGS.component.GUIProperties;
import com.jgoodies.looks.plastic.theme.SkyGreen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

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

            ///SkyBlue skyBlue = new SkyBlue();
            //Silver silver = new Silver();

            SkyGreen green = new SkyGreen();
            MetalLookAndFeel.setCurrentTheme(green);
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
}
