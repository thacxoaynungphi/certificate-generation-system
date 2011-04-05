/*
 * Copyright 2005 MH-Software-Entwicklung. All rights reserved.
 * Use is subject to license terms.
 */
package com.hueic.CerGS.component;

/**
 * @author nhchung
 */
public class GUIProperties {

    public static final String PLAF_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
    public static final String PLAF_WINDOWS = "com.jgoodies.looks.windows.WindowsLookAndFeel";
    public static final String PLAF_WINDOWSXP = "com.jgoodies.looks.plastic.PlasticXPLookAndFeel";
    public static final String PLAF_JGOODIES = "com.jgoodies.looks.plastic.Plastic3DLookAndFeel";
    public static final String PLAF_METAL = "com.jgoodies.looks.plastic.PlasticLookAndFeel";
    private String lookAndFeel = PLAF_JGOODIES;
    private String theme = "DarkStar";

    public GUIProperties() {
    }

    public void setLookAndFeel(String aLookAndFeel) {
        lookAndFeel = aLookAndFeel;
    }

    public String getLookAndFeel() {
        return lookAndFeel;
    }

    public void setTheme(String aTheme) {
        theme = aTheme;
    }

    public String getTheme() {
        return theme;
    }
}
