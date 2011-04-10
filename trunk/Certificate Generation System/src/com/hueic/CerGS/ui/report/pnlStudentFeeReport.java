/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StudentFeeReport.java
 *
 * Created on Apr 3, 2011, 8:49:37 AM
 */

package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.StudentFeeReportManger;
import javax.swing.JOptionPane;
/**
 *
 * @author Wind
 */
public class pnlStudentFeeReport extends javax.swing.JPanel {

    /** Creates new form StudentFeeReport */
    public pnlStudentFeeReport(String studentId) {
        initComponents();
        StudentFeeReportManger studentFeeReport = new StudentFeeReportManger(studentId);
        try {
            this.add(studentFeeReport.getPanelViewer(true));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString(), "Report Message", JOptionPane.ERROR_MESSAGE);
        }

        setSize(860, 580);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
