
/*
 * NewJPanel.java
 *
 * Created on Apr 2, 2011, 3:32:08 AM
 */

package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.StudentMarkReportManager;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class pnlStudentMarkReport extends javax.swing.JPanel {

    /** Creates new form NewJPanel */
    public pnlStudentMarkReport(String studentId) {
        initComponents();
         StudentMarkReportManager report = new StudentMarkReportManager(studentId);
        try {
            this.add(report.getPanelViewer(true));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Report Message", JOptionPane.ERROR_MESSAGE);
        }
        this.setSize(860, 580);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
