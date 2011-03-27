/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.dao;

import com.jgoodies.looks.plastic.theme.DarkStar;
import com.jgoodies.looks.plastic.theme.DesertBlue;
import com.jgoodies.looks.plastic.theme.DesertGreen;
import com.jgoodies.looks.plastic.theme.DesertRed;
import com.jgoodies.looks.plastic.theme.DesertYellow;
import com.jgoodies.looks.plastic.theme.ExperienceBlue;
import com.jgoodies.looks.plastic.theme.ExperienceGreen;
import com.jgoodies.looks.plastic.theme.ExperienceRoyale;
import com.jgoodies.looks.plastic.theme.LightGray;
import com.jgoodies.looks.plastic.theme.Silver;
import com.jgoodies.looks.plastic.theme.SkyBlue;
import com.jgoodies.looks.plastic.theme.SkyBluer;
import com.jgoodies.looks.plastic.theme.SkyGreen;
import com.jgoodies.looks.plastic.theme.SkyPink;
import com.jgoodies.looks.plastic.theme.SkyRed;
import com.jgoodies.looks.plastic.theme.SkyYellow;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;

/**
 *
 * @author nhchung
 */
public class GUIDAO {

    JFrame frame = null;

    public GUIDAO(JFrame frame) {
        this.frame = frame;
    }

    public void setGUI(String gui, String theme) {
        try {
            frame.setLocationRelativeTo(null);
            MetalTheme metalTheme = null;
            if (theme.equals("DarkStar")) {
                metalTheme = new DarkStar();
            } else if (theme.equals("DesertBlue")) {
                metalTheme = new DesertBlue();
            } else if (theme.equals("DesertGreen")) {
                metalTheme = new DesertGreen();
            } else if (theme.equals("DesertRed")) {
                metalTheme = new DesertRed();
            } else if (theme.equals("DesertYellow")) {
                metalTheme = new DesertYellow();
            } else if (theme.equals("ExperienceBlue")) {
                metalTheme = new ExperienceBlue();
            } else if (theme.equals("ExperienceRoyale")) {
                metalTheme = new ExperienceRoyale();
            } else if (theme.equals("ExperienceGreen")) {
                metalTheme = new ExperienceGreen();
            } else if (theme.equals("LightGray")) {
                metalTheme = new LightGray();
            } else if (theme.equals("Silver")) {
                metalTheme = new Silver();
            } else if (theme.equals("SkyBlue")) {
                metalTheme = new SkyBlue();
            } else if (theme.equals("SkyBluer")) {
                metalTheme = new SkyBluer();
            } else if (theme.equals("SkyGreen")) {
                metalTheme = new SkyGreen();
            } else if (theme.equals("SkyPink")) {
                metalTheme = new SkyPink();
            } else if (theme.equals("SkyRed")) {
                metalTheme = new SkyRed();
            } else if (theme.equals("SkyYellow")) {
                metalTheme = new SkyYellow();
            }
            MetalLookAndFeel.setCurrentTheme(metalTheme);
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
