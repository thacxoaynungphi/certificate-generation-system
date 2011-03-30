package com.hueic.CerGS.component;



import com.l2fprod.common.swing.StatusBar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * Generate status bar
 * @author Unknown
 */
public class StatusBarFactory {
    protected String baseImagePath;
    protected StatusBar statusBar = new StatusBar();
    
    /** Creates a new instance of StatusBarFactory */
    public StatusBarFactory() {
    }
    
    /** Creates a new instance of StatusBarFactory */
    public StatusBarFactory(String baseImagePath) {
        this.setBaseImagePath(baseImagePath);
    }
    
    public StatusBar getStatusBar() {
        return this.statusBar;
    }
    
    public JLabel addZone(String id, String constraints, String initText) {
        CompoundBorder border = new CompoundBorder(BorderFactory.createLineBorder(new Color(236, 233, 216)),
                new EmptyBorder(1, 2, 1, 2));
        
        JLabel zone = new JLabel(initText);
        zone.setBorder(border);
        zone.setFont(new Font("Tahoma", 0, 11));
        
        statusBar.addZone(id, zone, constraints);
        return zone;
    }
    
    public void addSeparator(String id, String constraints, String icon) {
        JLabel sepZone = new JLabel();
        sepZone.setBorder(null);
        sepZone.setIcon(this.createImageIcon(icon));
        
        statusBar.addZone(id, sepZone, constraints);
    }
    
    protected ImageIcon createImageIcon(String icon) {
        return new ImageIcon(getClass().getResource(baseImagePath + icon));
    }    
    
    public void setBaseImagePath(String baseImagePath) {
        this.baseImagePath = baseImagePath;
    }
}