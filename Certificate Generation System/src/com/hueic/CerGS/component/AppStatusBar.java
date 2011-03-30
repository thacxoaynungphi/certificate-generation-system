package com.hueic.CerGS.component;

import com.l2fprod.common.swing.StatusBar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.JLabel;

/**
 * Load Status Bar
 * @author Unknown
 */
public class AppStatusBar {
    private StatusBarFactory statusBarFactory;
    private StatusBar bar;
    
    /** Creates a new instance of AppStatusBar */
    public AppStatusBar() {
        this.initAppStatusBar();
    }
    
    private void initAppStatusBar() {
        String TIME_FORMAT = "MM'/'dd'/'yyyy' 'h':'mm' 'a";
        final SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        Calendar calCurrent = Calendar.getInstance(TimeZone.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        
        statusBarFactory = new StatusBarFactory("/com/hueic/CerGS/images/");
        
        final JLabel statusZone = statusBarFactory.addZone("statusZone", "75%", "Ready");
        statusBarFactory.addSeparator("sepIZone", "0.2%", "separator.png");
        final JLabel timerZone = statusBarFactory.addZone("timerZone", "*", "Time: " + sdf.format(calCurrent.getTime()));
        
        Runnable r = new Runnable() {
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
                        timerZone.setText("Time: " + sdf.format(cal.getTime()));
                    }
                } catch ( Exception x ) {
                    x.printStackTrace();
                }
            }
        };
        Thread timerThread = new Thread(r);
        timerThread.start();
        
        bar = statusBarFactory.getStatusBar();        
    }

    /**
     * Set current status
     * @param status
     */
    public void setCurrentStatus(String status) {
        ((JLabel) this.bar.getZone("statusZone")).setText(status);
    }

    /**
     * Get status bar
     * @return StatusBar
     */
    public StatusBar getBar() {
        return this.bar;
    }
    
}