/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nhchung
 */
public class pnlBackground {

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
}
