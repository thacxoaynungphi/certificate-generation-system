/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.ui;

import com.hueic.CerGS.component.IconSystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Load Splash Screen
 * @author Ngo Phuoc Thien
 */
public class frmSplash extends JFrame {

    private int duration;

    public frmSplash(int duration) {
        this.duration = duration;
        new IconSystem(this);
        setTitle("Certificate Splash Screen");
    }
    // Set up contraints so that the user supplied component and the
    // background image label overlap and resize identically
    private static final GridBagConstraints gbc;

    static {
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
    }

    public static JPanel wrapInBackgroundImage(JComponent component, Icon backgroundIcon) {
        return wrapInBackgroundImage(component, backgroundIcon, JLabel.TOP, JLabel.LEADING);
    }

    public static JPanel wrapInBackgroundImage(JComponent component, Icon backgroundIcon, int verticalAlignment, int horizontalAlignment) {
        component.setOpaque(false);
        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        backgroundPanel.add(component, gbc);
        JLabel backgroundImage = new JLabel(backgroundIcon);
        backgroundImage.setPreferredSize(new Dimension(1, 1));
        backgroundImage.setMinimumSize(new Dimension(1, 1));
        backgroundImage.setVerticalAlignment(verticalAlignment);
        backgroundImage.setHorizontalAlignment(horizontalAlignment);
        backgroundPanel.add(backgroundImage, gbc);
        return backgroundPanel;
    }

    public void showSplash() {
        
        int width = 475;
        int height = 290;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        setVisible(true);
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        setVisible(false);
    }

    public void showSplashAndExit() {
        showSplash();
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frmSplash splash = new frmSplash(2000);
        JPanel foregroundPanel = new JPanel(new BorderLayout(10, 10));
        foregroundPanel.setBackground(Color.white);
        foregroundPanel.setOpaque(false);
        splash.setContentPane(wrapInBackgroundImage(foregroundPanel, new ImageIcon(pnlBackground.class.getResource("/com/hueic/CerGS/images/plashScreen.png"))));
        splash.setUndecorated(true);
        splash.showSplash();
        frmMain frm = new frmMain();
        frm.setVisible(true);
        dlgLogin dlg = new dlgLogin(frm, true);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
        splash.dispose();
    }
}
