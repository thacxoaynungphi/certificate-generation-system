/*
 * Copyright 2005 MH-Software-Entwicklung. All rights reserved.
 * Use is subject to license terms.
 */
package com.hueic.CerGS.component;

/**
 * @author Michael Hagen
 */
public class GUIProperties {

    public static final String PLAF_METAL = "javax.swing.plaf.metal.MetalLookAndFeel";
    public static final String PLAF_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
    public static final String PLAF_WINDOWS = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    public static final String PLAF_MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    public static final String PLAF_MAC = "com.birosoft.liquid.LiquidLookAndFeel";
    public static final String PLAF_JGOODIES = "com.jgoodies.looks.plastic.Plastic3DLookAndFeel";
    private String lookAndFeel = PLAF_JGOODIES;
    private String theme = "Default";

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

    public boolean isMetalLook() {
        return lookAndFeel.equals(PLAF_METAL);
    }

    public boolean isNimbusLook() {
        return lookAndFeel.equals(PLAF_NIMBUS);
    }

    public boolean isWindowsLook() {
        return lookAndFeel.equals(PLAF_WINDOWS);
    }

    public boolean isMotifLook() {
        return lookAndFeel.equals(PLAF_MOTIF);
    }

    public boolean isMacLook() {
        return lookAndFeel.equals(PLAF_MAC);
        }
}
