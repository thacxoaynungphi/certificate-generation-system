/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * pnlStudentMarkAllReport.java
 *
 * Created on Apr 3, 2011, 8:55:39 AM
 */

package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.StudentMarkAllReportManager;
import com.hueic.CerGS.entity.Mark;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Wind
 */
public class pnlStudentMarkAllReport extends javax.swing.JPanel {

    /** Creates new form pnlStudentMarkAllReport */
    public pnlStudentMarkAllReport(ArrayList<Mark> listMark) {
        initComponents();
        StudentMarkAllReportManager studentMarkAllReportManager = new StudentMarkAllReportManager(listMark);
        try {
            this.add(studentMarkAllReportManager.getPanelViewer(true));
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
