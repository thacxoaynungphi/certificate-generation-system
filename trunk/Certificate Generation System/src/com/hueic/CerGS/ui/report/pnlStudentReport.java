

/*
 * pnlStudentReport.java
 *
 * Created on Apr 2, 2011, 2:51:00 AM
 */
package com.hueic.CerGS.ui.report;

import com.hueic.CerGS.component.report.StudentReportManager;
import com.hueic.CerGS.entity.Student;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nhchung
 */
public class pnlStudentReport extends javax.swing.JPanel {

    /** Creates new form pnlStudentReport */
    public pnlStudentReport(ArrayList<Student> listStudent) {
        initComponents();
        StudentReportManager studentReport = new StudentReportManager(listStudent);
        if (studentReport != null) {
            try {
                this.add(studentReport.getPanelViewer(true));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString(), "Report Message", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.setSize(860, 580);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(860, 550));
        setPreferredSize(new java.awt.Dimension(860, 550));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
