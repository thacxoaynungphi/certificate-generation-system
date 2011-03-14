/*
 * @(#)Splasher.java  2.0  January 31, 2004
 *
 * Copyright (c) 2003-2004 Werner Randelshofer
 * Staldenmattweg 2, Immensee, CH-6405, Switzerland.
 * All rights reserved.
 *
 * This software is in the public domain.
 */

package com.hueic.CerGS.ui.main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author  werni
 */
public class Splasher {
    /**
     * Shows the splash screen, launches the application and then disposes^
     * the splash screen.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //TODO: chua tim duoc duong dan anh
            SplashWindow.splash(Splasher.class.getResource("src/com/hueic/CerGS/images/plashScreen.jpg"));
            SplashWindow.invokeMain("com.hueic.CerGS.ui.frmLogin", args);
            SplashWindow.disposeSplash();
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Splasher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

