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
 * @author Ngo Phuoc Thien
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

        // make the passed in swing component transparent
        component.setOpaque(false);

        // create wrapper JPanel
        JPanel backgroundPanel = new JPanel(new GridBagLayout());

        // add the passed in swing component first to ensure that it is in front
        backgroundPanel.add(component, gbc);

        // create a label to paint the background image
        JLabel backgroundImage = new JLabel(backgroundIcon);

        // set minimum and preferred sizes so that the size of the image
        // does not affect the layout size
        backgroundImage.setPreferredSize(new Dimension(1, 1));
        backgroundImage.setMinimumSize(new Dimension(1, 1));

        // align the image as specified.
        backgroundImage.setVerticalAlignment(verticalAlignment);
        backgroundImage.setHorizontalAlignment(horizontalAlignment);

        // add the background label
        backgroundPanel.add(backgroundImage, gbc);

        // return the wrapper
        return backgroundPanel;
    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Background Image Panel Example");
//
////        // Create some GUI
//        JPanel foregroundPanel = new JPanel(new BorderLayout(10, 10));
//        foregroundPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        foregroundPanel.setOpaque(false);
//
//        frame.setContentPane(wrapInBackgroundImage(foregroundPanel, new ImageIcon(BackgroundImagePanelExample.class.getResource("../icon/logods.png"))));
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//
//    }
}
