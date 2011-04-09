/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hueic.CerGS.component;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author nhchung
 */
public class IconSystem {

    public IconSystem(JFrame frame) {
        Image icon = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "/Logochuan.png");
        frame.setIconImage(icon);
    }
}
